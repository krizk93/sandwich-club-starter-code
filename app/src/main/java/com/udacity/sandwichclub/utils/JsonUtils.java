package com.udacity.sandwichclub.utils;

import android.content.Context;
import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        if (json == null){;
            return null;
        }
        else{
            try {
                JSONObject jsonSandwich = new JSONObject(json);
                JSONObject jsonName = jsonSandwich.getJSONObject("name");
                JSONArray arrayAlsoKnownAs = jsonName.getJSONArray("alsoKnownAs");
                JSONArray arrayIngredients = jsonSandwich.getJSONArray("ingredients");
                String mainName = jsonName.getString("mainName");
                List<String> alsoKnownAs = new ArrayList<>();
                String placeOfOrigin = jsonSandwich.getString("placeOfOrigin");
                String description = jsonSandwich.getString("description");
                String image = jsonSandwich.getString("image");
                List<String> ingredients = new ArrayList<>();

                if (arrayAlsoKnownAs != null && arrayAlsoKnownAs.length() > 0) {
                    for (int i = 0; i < arrayAlsoKnownAs.length(); i++) {
                        alsoKnownAs.add(arrayAlsoKnownAs.getString(i));
                    }
                }
                if (arrayIngredients != null && arrayIngredients.length() > 0){
                    for (int i = 0; i < arrayIngredients.length(); i++){
                        ingredients.add(arrayIngredients.getString(i));
                    }
                }
                return new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

            }catch(JSONException e){
                e.printStackTrace();
                return null;
            }
        }

    }
}
