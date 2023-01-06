package com.example.experiment01;
import android.util.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag","OnCreate Ran");
    }
    public void onResume() {
        super.onResume();
        Log.d("tag","OnResume Ran");
    }

    public void onStart() {
        super.onStart();
        Log.d("tag","onStart Ran");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("tag","onDestroy Ran");
    }

    public void onPause() {
        super.onPause();
        Log.d("tag","onPause Ran");
    }

    public void onStop() {
        super.onStop();
        Log.d("tag","onStop Ran");
    }
}