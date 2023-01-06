package com.example.foodbookingapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    // Veg Pizza

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("black"));
        actionBar.setBackgroundDrawable(colorDrawable);

        // -------------------------PIZZA1----------------------------------------------------------------------------------
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Added to cart", Toast.LENGTH_SHORT).show();

                TextView name = (TextView) findViewById(R.id.textView2);
                TextView price = (TextView) findViewById(R.id.textView3);
                int cost = Integer.parseInt(price.getText().toString());
                Cart.addItem(name.getText().toString(), cost);

            }
        });

        // -------------------------PIZZA2----------------------------------------------------------------------------------
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Added to cart", Toast.LENGTH_SHORT).show();
                TextView name = (TextView) findViewById(R.id.p2t1);
                TextView price = (TextView) findViewById(R.id.p2t2);
                int cost = Integer.parseInt(price.getText().toString());
                Cart.addItem(name.getText().toString(), cost);

            }
        });

        // -------------------------PIZZA3----------------------------------------------------------------------------------
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Added to cart", Toast.LENGTH_SHORT).show();
                TextView name = (TextView) findViewById(R.id.p3t1);
                TextView price = (TextView) findViewById(R.id.p3t2);
                int cost = Integer.parseInt(price.getText().toString());
                Cart.addItem(name.getText().toString(), cost);

            }
        });

        ImageView image = (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(image);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        registerForContextMenu(image2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        registerForContextMenu(image3);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle("Add Toppings");
        menu.add(0, v.getId(), 0, "Rs20: Olives");
        menu.add(0, v.getId(), 0, "Rs50: Pepperoni");
        menu.add(0, v.getId(), 0, "Rs70: Mushrooms");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        if (item.getTitle() == "Rs20: Olives") {
            TextView price = (TextView) findViewById(R.id.textView3);
            int cost = Integer.parseInt(price.getText().toString());
            cost = cost + 20;
            price.setText(Integer.toString(cost));

        } else if (item.getTitle() == "Rs50: Pepperoni") {
            TextView price = (TextView) findViewById(R.id.textView3);
            int cost = Integer.parseInt(price.getText().toString());
            cost = cost + 50;
            price.setText(Integer.toString(cost));

        } else if (item.getTitle() == "Rs70: Mushrooms") {
            TextView price = (TextView) findViewById(R.id.textView3);
            int cost = Integer.parseInt(price.getText().toString());
            cost = cost + 60;
            price.setText(Integer.toString(cost));

        }
        return true;
    }

}
