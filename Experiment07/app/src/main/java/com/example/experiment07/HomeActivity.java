package com.example.experiment07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME ="myPreference";
    private static final String KEY_NAME = "name" ;
    private static final String KEY_GROUP = "blood group" ;
    TextView name,bloodGrp;
    Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.Name);
        bloodGrp = findViewById(R.id.BloodGroup);
        download = findViewById(R.id.clearText);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String bloodGroup = sharedPreferences.getString(KEY_GROUP, null);
        String nm = sharedPreferences.getString(KEY_NAME, null);

        if (nm != null) {
            name.setText("Name: "+nm);
            bloodGrp.setText("Blood Group: "+bloodGroup);
        }

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();

                new pdfDownloader().execute("https://i.imgur.com/vxCPytv.png");
            }
        });

    }

    private class pdfDownloader extends AsyncTask<String, Void, Bitmap> {
        HttpURLConnection httpURLConnection;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream() );
                Bitmap temp = BitmapFactory.decodeStream(inputStream);
                return temp;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                httpURLConnection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null){
                Toast.makeText(HomeActivity.this, "File Downloaded Successfully !!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(HomeActivity.this, "File Download Failed !!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}