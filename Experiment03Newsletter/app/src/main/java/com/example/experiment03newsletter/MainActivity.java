package com.example.experiment03newsletter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Submit;
    EditText Name,Email,PhoneNum,Dob,Age;
    CheckBox cb;
    String[] courses = { "Daily", "Weekly",
            "Fortnight", "Monthly",
            "Quarterly","Half Yearly", "Yearly" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.freqSpinner);
        //spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        //Assigning values to variables

        Submit = findViewById(R.id.submit);
        Name = findViewById(R.id.nameField);
        Email = findViewById(R.id.emailField);
        PhoneNum = findViewById(R.id.mobileField);
        Age = findViewById(R.id.ageField);
        Dob = findViewById(R.id.dobInput);
        cb = findViewById(R.id.ckBox);



        Submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name  =  Name.getText().toString();
                String email = Email.getText().toString();
                String age = Age.getText().toString();
                String phone = PhoneNum.getText().toString();
                String dob = Dob.getText().toString();

                boolean check = validationFun(name,email,age,phone,dob);
                    
                if(check == true){
                    Toast.makeText(getApplicationContext(),"Data Submitted Successfully !!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Please check the Data Entered. Some fields are missing",Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data_nm",name);
                intent.putExtra("data_e",email);
                intent.putExtra("data_ag",age);
                intent.putExtra("data_p",phone);
                intent.putExtra("data_d",dob);
                startActivity(intent);
            }
        });

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spin.setAdapter(ad);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked()){
                    Submit.setEnabled(true);
                }
            }
        });



    }

    private Boolean validationFun(String name, String email, String age, String phone, String dob) {
        if (name.length() == 0) {
            Name.requestFocus();
            Name.setError("This field cannot be Empty");
            return false;
        }else if(!name.matches("[a-zA-Z]+")){
            Name.requestFocus();
            Name.setError("Enter only Alphabetical Characters.");
            return false;
        }else if (email.length() == 0) {
            Email.requestFocus();
            Email.setError("This field cannot be Empty");
            return false;
        }else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            Email.requestFocus();
            Email.setError("Enter Valid Email Address");
            return false;
        }else if (phone.length() == 0) {
            PhoneNum.requestFocus();
            PhoneNum.setError("This field cannot be Empty");
            return false;
        }else if(!phone.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
            PhoneNum.requestFocus();
            PhoneNum.setError("Enter valid Phone Number");
            return false;
        }else if (dob.length() == 0) {
            Dob.requestFocus();
            Dob.setError("This field cannot be Empty");
            return false;
        }else if(!dob.matches("[0-9]+")) {
            Dob.requestFocus();
            Dob.setError("Enter only numerical characters that is your year of birth");
            return false;
        }else if (age.length() == 0) {
            Age.requestFocus();
            Age.setError("This field cannot be Empty");
            return false;
        }else if(!age.matches("[0-9]+")) {
            Age.requestFocus();
            Age.setError("Enter only Numerical Characters.");
            return false;
        }else{
            return true;
        }
    }
}