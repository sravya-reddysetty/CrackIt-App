package com.example.sys1.prescriptor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sys1 on 9/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="prescriptor.db";
    public static final String TABLE_NAME="users_table";
    public static final String COL_ID="id";
    public static final String COL_USERNAME="username";
    public static final String COL_EMAIL="email";
    public static final String COL_PASSWORD="password";
    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME+ " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                COL_USERNAME + "TEXT NOT NULL, "+
                COL_EMAIL + "TEXT NOT NULL ," +
                COL_PASSWORD + "TEXT NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String n,String e,String p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_USERNAME,n);
        contentValues.put(COL_EMAIL,e);
        contentValues.put(COL_PASSWORD,p);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
