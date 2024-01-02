package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;


public class Form extends AppCompatActivity  {
    String[] bloodgrp = { "A+", "A-", "B+", "B-", "O+","O-","AB+","AB-"};
     public  static TextView bloodtext,organtxt;
     TableRow organcheck1,organcheck2;
    Spinner spin;
    Button submit;
    RadioGroup gender;
    RadioButton rb;
    EditText fname,address,mail,age,phn;
    Button view;
    DBHelper DB;
    public static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        spin = findViewById(R.id.spinner);
        bloodtext=findViewById(R.id.bloodtxt);
        organtxt=findViewById(R.id.organtxt);
        organcheck1=findViewById(R.id.organcheck1);
        organcheck2=findViewById(R.id.organcheck2);
        submit=findViewById(R.id.submit);
        tv=findViewById(R.id.tv);


        gender=findViewById(R.id.gender);

        fname=findViewById(R.id.fname);
        address=findViewById(R.id.address);
        phn=findViewById(R.id.phn);
        mail=findViewById(R.id.mail);
        age=findViewById(R.id.age);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bloodgrp);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        if(OptionsActivity.blood.isPressed()==false)
        {
            bloodtext.setVisibility(View.GONE);
            spin.setVisibility(View.GONE);
        }
        if(OptionsActivity.organ.isPressed()==false)
        {
            organtxt.setVisibility(View.GONE);
            organcheck1.setVisibility(View.GONE);
            organcheck2.setVisibility(View.GONE);
        }
        else
        {
            bloodtext.setVisibility(View.VISIBLE);
            spin.setVisibility(View.VISIBLE);

        }
        if(OptionsActivity.cloths.isPressed()==true)
        {
            tv.setText("Clothes");
        }
        if(OptionsActivity.food.isPressed()==true)
        {
            tv.setText("Food");
        }
        if(OptionsActivity.organ.isPressed()==true)
        {
            tv.setText("Organs");
        }
        if(OptionsActivity.blood.isPressed()==true)
        {
            tv.setText("Blood");
        }

            DB= new DBHelper(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedid=gender.getCheckedRadioButtonId();
                rb=findViewById(selectedid);

                String donation=tv.getText().toString();
                String fnameTXT = fname.getText().toString();
                String phnTXT = phn.getText().toString();
                String addressTXT = address.getText().toString();
                String emailTXT = mail.getText().toString();
                String ageTXT = age.getText().toString();
                String genderTXT = rb.getText().toString();

                String bloodgrpTXT= (String) spin.getSelectedItem();

                Boolean checkinsertdata = DB.insertuserdata(donation,fnameTXT, phnTXT, emailTXT,addressTXT,ageTXT,genderTXT,bloodgrpTXT);
                if (checkinsertdata == true) {
                    Toast.makeText(Form.this, "Donation Request Successfully..Organization Cantact to you..Thank You!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Form.this, "Something went wrong!!Please try again", Toast.LENGTH_LONG).show();
                }
            }

        });



    }


    }
