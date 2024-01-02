package com.example.donation;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.core.app.ComponentActivity;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "User3.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(donation,name TEXT primary key, contact TEXT, email TEXT,address TEXT,age INTEGER,gender TEXT,bloodgrp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserdata(String donation,String name, String contact, String email,String address,String age,String gender,String bloodgrp) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("donation", donation);
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("email", email);
        contentValues.put("address", address);
        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("bloodgrp", bloodgrp);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getdata() {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;

    }


}



