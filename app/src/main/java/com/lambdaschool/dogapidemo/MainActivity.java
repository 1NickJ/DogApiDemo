package com.lambdaschool.dogapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<String> allBreeds = DogApiDAO.getAllBreeds();
                Log.i(getLocalClassName(), allBreeds.toString());
            }
        }).start();
    }
}
