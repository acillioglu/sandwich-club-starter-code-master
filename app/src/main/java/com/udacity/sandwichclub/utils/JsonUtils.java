package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {


            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");


            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            int alsoKnownasLength = alsoKnownAs.length();
            for (int i = 0; i < alsoKnownasLength; i++) {

                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }


            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            int ingredientsLength = ingredients.length();
            for (int i = 0; i < ingredientsLength; i++) {

                ingredientsList.add(ingredients.getString(i));
            }


            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);


        } catch (JSONException e) {
            Log.e("JSONUTils", "There is an error in JsonUtils");
        }

        return null;
    }
}
