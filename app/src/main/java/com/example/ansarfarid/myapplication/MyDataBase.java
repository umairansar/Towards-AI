package com.example.ansarfarid.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Playlist.db";
    public static final String TABLE_ACTION = "ACTION_TABLE";
    public static final String TABLE_COMEDY = "COMEDY_TABLE";
    public static final String TABLE_DRAMA= "DRAMA_TABLE";
    public static final String TABLE_RANDOM = "RANDOM_TABLE";
    //public static final String TABLE_FAVOURITES = "FAVOURITES_TABLE";
    public static  final String COL = "ID";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "LINK";
    //public static final String COL_3 = "Drama";
    //public static final String COL_4 = "Random";

    ContentValues cv = new ContentValues();

    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_ACTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LINK TEXT)");
        db.execSQL("create table " + TABLE_COMEDY + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LINK TEXT)");
        db.execSQL("create table " + TABLE_DRAMA + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LINK TEXT)");
        db.execSQL("create table " + TABLE_RANDOM + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LINK TEXT)");
        //db.execSQL("create table " + TABLE_FAVOURITES + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LINK TEXT)");

        db.delete(TABLE_ACTION, null, null);
        db.delete(TABLE_COMEDY, null, null);
        db.delete(TABLE_DRAMA, null, null);
        db.delete(TABLE_RANDOM, null, null);
        //db.delete(TABLE_FAVOURITES, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_ACTION);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_COMEDY);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_DRAMA);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_RANDOM);
        //db.execSQL( "DROP TABLE IF EXISTS " + TABLE_FAVOURITES);
        onCreate(db);
    }

    public void update_data(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACTION, null, null);
        db.delete(TABLE_COMEDY, null, null);
        db.delete(TABLE_DRAMA, null, null);
        db.delete(TABLE_RANDOM, null, null);
        //db.delete(TABLE_FAVOURITES, null, null);
    }


    public long Insert_data(String Table, String name, String link){
        cv.put(COL_1, name);
        cv.put(COL_2, link);
        long res = getWritableDatabase().insertOrThrow(Table, null, cv);
        return res;
    }

    public Cursor getAllDATA(String TABLE_NAME){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from " + TABLE_NAME , null);
        return res;
    }

}
