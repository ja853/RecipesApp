package com.example.recipesmkiii;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;


public class databaseHandler extends SQLiteOpenHelper {

    private static final String DATABASEPATH = "";
    private static final String DATABASENAME = "recipeCards";
    private static final String TABLE_NAME = "cards";

    // FIELDS
    public static final String RECIPE_ID = "cardID";
    public static final String RECIPE_TITLE = "cardTitle";
    public static final String CARD_IMAGE = "cardImage";
    public static final String INGREDIENTS = "ingredients";

    public databaseHandler(@Nullable Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.getReadableDatabase();
        Log.d("databaseHandler", "onCreate: called");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + RECIPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + CARD_IMAGE + " BLOB, "
                        + RECIPE_TITLE + " TEXT NOT NULL, "
                        + INGREDIENTS + " INTEGER) ");

        //CREATE TABLE "cards" (
        //	"cardID"	INTEGER NOT NULL UNIQUE,
        //	"cardImage"	BLOB,
        //	"cardTitle"	TEXT NOT NULL,
        //	"ingredients"	INTEGER,
        //	PRIMARY KEY("cardID")
        //)
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("databaseHandler", "onUpgrade: called");
    }

    public static ArrayList<RecipeCard> openDatabaseAndGetContents(Context context){
        SQLiteOpenHelper handler = new databaseHandler(context);
        SQLiteDatabase theDatabaseItself = handler.getReadableDatabase();
        Cursor cursor = theDatabaseItself.rawQuery(" SELECT " + RECIPE_TITLE
                        + " FROM " + TABLE_NAME, null);

        /* Cursor cursor = theDatabaseItself.rawQuery(
                " SELECT " + RECIPE_TITLE +
                        " FROM " + DATABASENAME +
                        " WHERE " + INGREDIENTS + " = \"chicken\"",null);
        */

        ArrayList<RecipeCard> recipeCards = new ArrayList<>();
        if(cursor.getCount() == 0){
            Log.d("databaseHandler", "openDatabaseAndGetContents: database is empty or non existent");
        } else{
            cursor.moveToFirst();
            for (int i = 0; i<cursor.getCount(); i++) {
                String title = cursor.getString(cursor.getColumnIndex(RECIPE_TITLE));
                recipeCards.add(new RecipeCard(title));
                cursor.moveToNext();
            }
        }

    return recipeCards;
    }
}
