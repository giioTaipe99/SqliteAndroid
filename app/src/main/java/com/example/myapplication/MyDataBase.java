package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDataBase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Profiles.db";
    private static final  int DATABASE_VERSION = 3;

    private static final String TABLE_NAME = "PROFILES";
    private static final String COLUM_ID = "_id";
    private static final String COLUM_NAME = "name";
    private static final String COLUM_ADREÇA = "adreça";
    private static final String COLUM_TEL = "telefon";
    private static final String COLUM_ENTREGA = "entrega";

    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION  );
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUM_NAME + " VARCHAR, " +
                COLUM_ADREÇA + " VARCHAR, " +
                COLUM_TEL + " INTEGER, " +
                COLUM_ENTREGA + " VARCHAR );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addProfile(String nom, String mail, int tel, String opcionSeleccionada){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUM_NAME, nom);
        cv.put(COLUM_ADREÇA, mail);
        cv.put(COLUM_TEL, tel);
        cv.put(COLUM_ENTREGA, opcionSeleccionada);

        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1){
            Toast.makeText(context, "Insert failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Insert Successfully", Toast.LENGTH_SHORT).show();

            // De esta manera obtenemos la ruta del .db
            /*String databasePath = context.getDatabasePath(DATABASE_NAME).getAbsolutePath();
            Log.d("DatabasePath", "Path: " + databasePath);*/
        }
    }
    Cursor readAllData(){
        String query = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return  cursor;
    }

}
