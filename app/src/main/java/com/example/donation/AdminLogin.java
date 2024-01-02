package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class AdminLogin extends AppCompatActivity {
DBHelper DB;
EditText email,password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        DB= new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("helpinghands4@gmail.com") && password.getText().toString().equals("savelives4")) {
                    Cursor res = DB.getdata();
                    if (res.getCount() == 0) {
                        Toast.makeText(AdminLogin.this, "No Data Exists", Toast.LENGTH_LONG).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Donation : " + res.getString(0) +"\n");
                        buffer.append("Name : " + res.getString(1) + "\n");
                        buffer.append("Phone No : " + res.getString(2) + "\n");
                        buffer.append("Email : " + res.getString(3) + "\n");
                        buffer.append("Address : " + res.getString(4) + "\n");
                        buffer.append("Age: " + res.getString(5) + "\n");
                        buffer.append("Gender: " + res.getString(6) + "\n");
                        buffer.append("Blood Group: " + res.getString(7) + "\n\n");
                    }
                    Intent intent1 = new Intent(AdminLogin.this, ViewData.class);
                    intent1.putExtra("key", (Serializable) buffer);
                    startActivity(intent1);


                }
            }
        });

    }
}