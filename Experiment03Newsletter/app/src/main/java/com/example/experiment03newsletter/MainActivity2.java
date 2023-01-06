package com.example.experiment03newsletter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name,email,dob,age,phone;
    Button portfolioBtn, callMeBtn, storeBtn, gitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.dataName);
        email = findViewById(R.id.dataEmail);
        dob = findViewById(R.id.dataDob);
        age = findViewById(R.id.dataAge);
        phone = findViewById(R.id.dataPhone);

        callMeBtn = findViewById(R.id.callMe);
        portfolioBtn = findViewById(R.id.portfolioButton);
        storeBtn = findViewById(R.id.visitMyStore);
        gitBtn = findViewById(R.id.LetsConnect);

        Intent intent = getIntent();

        String r_name = intent.getStringExtra("data_nm");
        String r_email =intent.getStringExtra("data_e");
        String r_age = intent.getStringExtra("data_ag");
        String r_dob = intent.getStringExtra( "data_d");
        String r_phone =intent.getStringExtra("data_p");

        name.setText("Name -" + r_name);
        email.setText("Email -" + r_email);
        dob.setText("Age -" + r_dob);
        age.setText("DOB -" +r_age);
        phone.setText("Phone -" + r_phone);

        callMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callMeBtnIntent = new Intent(Intent.ACTION_DIAL);
                callMeBtnIntent.setData(Uri.parse("tel: 7878918799"));
                startActivity(callMeBtnIntent);
            }
        });

        portfolioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent portfolioIntent = new Intent(Intent.ACTION_VIEW);
                portfolioIntent.setData(Uri.parse("https://kushmunot.netlify.app/"));
                startActivity(portfolioIntent);
            }
        });

        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent storeBtnIntent = new Intent(Intent.ACTION_VIEW);
                storeBtnIntent.setData(Uri.parse("https://gitforgeeks.netlify.app/"));
                startActivity(storeBtnIntent);
            }
        });

        gitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitBtnIntent = new Intent(Intent.ACTION_VIEW);
                gitBtnIntent.setData(Uri.parse("https://github.com/Kush-munot"));
                startActivity(gitBtnIntent);
            }
        });

    }
}