package com.example.gging.hw10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDbOpenHelper extends SQLiteOpenHelper{

    private static String DB_TABLE;


    public ContactDbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name + "db", factory, version);
        DB_TABLE = name;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DB_TABLE + " (" +
                "_id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "number TEXT," +
                "phonetype TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
