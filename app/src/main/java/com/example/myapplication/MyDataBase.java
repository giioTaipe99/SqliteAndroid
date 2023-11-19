package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Profiles.db";
    private static final  int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "PROFILES";
    private static final String COLUM_ID = "_id";
    private static final String COLUM_NAME = "name";
    private static final String COLUM_MAIL = "mail";
    private static final String COLUM_BANK = "BANK";

    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION  );
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME +
                " ("+ COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "+
                COLUM_NAME + "VARCHAR" +
                COLUM_MAIL + "VARCHAR" +
                COLUM_BANK + "VARCHAR );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
