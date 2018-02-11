package com.example.sys1.prescriptor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by sys1 on 9/25/2017.
 */

public class DatabaseCHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contactsManager.db";
    private static final String CREATE_TABLE="CREATE TABLE " + Contact.ContactEntry.TABLE_NAME+ " ("
            + Contact.ContactEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
            Contact.ContactEntry.COL_USERNAME + "TEXT NOT NULL, "+
            Contact.ContactEntry.COL_EMAIL + "TEXT NOT NULL ," +
            Contact.ContactEntry.COL_PASSWORD + "TEXT NOT NULL );";
    SQLiteDatabase db;


    public DatabaseCHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
       // SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + Contact.ContactEntry.TABLE_NAME);
        onCreate(db);
        this.onCreate(db);
    }
        public boolean addContact(String name,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Contact.ContactEntry.COL_EMAIL,email);
        contentValues.put(Contact.ContactEntry.COL_USERNAME,name);
        contentValues.put(Contact.ContactEntry.COL_PASSWORD,password);
        long res=db.insert(Contact.ContactEntry.TABLE_NAME,null,contentValues);
        if(res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getContact(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ Contact.ContactEntry.TABLE_NAME,null);
        return res;
    }
        }

