package com.lambdaschool.dogapidemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DogApiDAO {
    private static final String ALL_BREEDS_URL = "https://dog.ceo/api/breeds/list/all";

    public static ArrayList<String> getAllBreeds() {
        String result = NetworkAdapter.httpGetRequest(ALL_BREEDS_URL);
        ArrayList<String> breeds = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(result);
            final JSONObject message = json.getJSONObject("message");
            final JSONArray names = message.names();
            for(int i = 0; i < names.length(); ++i) {
                String breed = names.getString(i);
                breeds.add(breed);
                JSONArray subBreedArray = message.getJSONArray(breed);
                for(int n = 0; n < subBreedArray.length(); ++n) {
                    String subBreed = subBreedArray.getString(n);
                    breeds.add(breed  + " " + subBreed);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return breeds;
    }
}
