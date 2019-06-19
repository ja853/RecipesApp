package com.example.recipesmkiii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import java.util.ArrayList;

public class databaseTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        getDatabase();
    }

    private void getDatabase() {
        ArrayList<RecipeCard> cards = databaseHandler.openDatabaseAndGetContents(this);
        for(int i = 0; i<cards.size(); i++){
            Log.d("contents", "getDatabase: " + cards.get(i).getRecipeTitle());
        }
    }
}
