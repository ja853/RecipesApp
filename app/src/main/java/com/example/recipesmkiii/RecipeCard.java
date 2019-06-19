package com.example.recipesmkiii;

import android.content.Intent;

import java.sql.Blob;
import java.util.ArrayList;

public class RecipeCard {
    public Integer recipeID;
    public String recipeTitle;
    public Blob cardImage; // Blob? String?
    public ArrayList<String> recipeIngredients;

    RecipeCard(String title){
        this.recipeTitle = title;
    }

    RecipeCard(String title, Integer id){
        this.recipeID = id;
        this.recipeTitle = title;
    }

    RecipeCard(String title, Integer id, Blob image, ArrayList<String> ingredients){
        this.recipeID = id;
        this.recipeTitle = title;
        this.cardImage = image;
        this.recipeIngredients = ingredients;
    }

    Integer getRecipeID(){
        return recipeID;
    }

    String getRecipeTitle(){
        return recipeTitle;
    }

    Blob getCardImage(){
        return cardImage;
    }

    ArrayList<String> getIngredients(){
        return recipeIngredients;
    }
}
