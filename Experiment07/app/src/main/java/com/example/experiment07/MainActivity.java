package com.example.experiment07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit_name, password, bGroup, phoneNum;
    Button button;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME ="myPreference";
    private static final String KEY_NAME = "name" ;
    private static final String KEY_PASSWORD = "email" ;
    private static final String KEY_GROUP = "blood group" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = findViewById(R.id.edit1);
        password = findViewById(R.id.edit2);
        bGroup = findViewById(R.id.edit3);
        button = findViewById(R.id.button1);
        phoneNum = findViewById(R.id.edit4);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,edit_name.getText().toString());
                editor.putString(KEY_PASSWORD,password.getText().toString());
                editor.putString(KEY_GROUP,bGroup.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Form Filled Successfully", Toast.LENGTH_SHORT).show();

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendMessage();
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }

    private void sendMessage(){
        String sPhno = phoneNum.getText().toString().trim();
        String sMsg = "User Registered Successfully for Blood Donation Camp at RCOEM on 12 Jan 2022!!" ;
        if(!sPhno.equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(sPhno, null, sMsg, null, null);
        }else{
            Toast.makeText(MainActivity.this, "Enter Valid Values !!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            sendMessage();
        }else{
            Toast.makeText(MainActivity.this, "Permission Denied :((", Toast.LENGTH_SHORT).show();

        }
    }
}
