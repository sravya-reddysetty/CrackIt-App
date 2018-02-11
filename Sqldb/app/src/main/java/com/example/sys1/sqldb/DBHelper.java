package com.example.sys1.sqldb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by sys1 on 10/2/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
   // private static final String SELECT_SQL = "select * from doctordetails";
    String DB_PATH=null;
    private static String DB_NAME="doctordetails";
    private SQLiteDatabase sq;
    private final Context con;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 0);
       // this.sq = sq;
        this.con = context;
        this.DB_PATH="/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("path 1",DB_PATH);
    }
    public void createDB() throws IOException{
        boolean dbexists=checkDataBase();
        if(dbexists){

        }else{
            this.getReadableDatabase();
            try
            {
                copyDB();
            }
            catch(IOException e){
                throw new Error("error");
            }
        }
    }

    private boolean checkDataBase()
    {
        SQLiteDatabase ch=null;
        try{
            String p=DB_PATH+DB_NAME;
            ch=SQLiteDatabase.openDatabase(p,null,SQLiteDatabase.OPEN_READONLY);
        }catch (SQLiteException e){

        }
        if(ch!=null){
            ch.close();
        }
        return ch!=null?true:false;
    }
    private void copyDB() throws IOException{
        InputStream i=con.getAssets().open(DB_NAME);
        String out=DB_PATH+DB_NAME;
        OutputStream myout=new FileOutputStream(out);
        byte[] buffer=new byte[10];
        int length;
        while((length=i.read(buffer))>0){
            myout.write(buffer,0,length);
        }
        myout.flush();
        myout.close();
        myout.close();
    }
    public void openDatabase() throws SQLiteException{
        String my=DB_PATH+DB_NAME;
        sq=SQLiteDatabase.openDatabase(my,null,SQLiteDatabase.OPEN_READONLY);
    }
    @Override
    public synchronized void close()
    {
        if(sq!=null){
            sq.close();
        super.close();
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor query(){
        return sq.rawQuery("select * from "+DB_PATH+DB_NAME+"doctordetails",null);
    }

}
