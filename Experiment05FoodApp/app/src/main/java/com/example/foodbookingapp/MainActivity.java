package com.example.foodbookingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("black"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.menufile, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item1:
                // Pasta
                Intent i = new Intent();
                i.setAction("android.intent.action.A4");
                startActivity(i);
                return true;

            case R.id.item2:
                return true;

            case R.id.item11:
                // Pizza
                Intent i2 = new Intent();
                i2.setAction("android.intent.action.A2");
                startActivity(i2);
                return true;

            case R.id.item12:
                // Exotic Pizza
                Intent i3 = new Intent();
                i3.setAction("android.intent.action.A3");
                startActivity(i3);
                return true;

            case R.id.item3:
                // Cart
                Intent i4 = new Intent();
                i4.setAction("android.intent.action.A5");
                startActivity(i4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
