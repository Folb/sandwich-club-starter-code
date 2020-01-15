package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            JSONObject jsonNames = jsonSandwich.getJSONObject("name");
            JSONArray jsonAlsoKnownAs = jsonNames.getJSONArray("alsoKnownAs");
            JSONArray jsonIngredients = jsonSandwich.getJSONArray("ingredients");

            String mainName = jsonNames.getString("mainName");
            String placeOfOrigin = jsonSandwich.getString("placeOfOrigin");
            String description = jsonSandwich.getString("description");
            String image = jsonSandwich.getString("image");

            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < jsonAlsoKnownAs.length(); i++) {
                alsoKnownAs.add(jsonAlsoKnownAs.getString(i));
            }

            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < jsonIngredients.length(); i++) {
                ingredients.add(jsonIngredients.getString(i));
            }

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
