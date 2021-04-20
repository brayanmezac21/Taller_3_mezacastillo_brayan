package com.brayanmezac.taller_3_mezacastillo_brayan.bd;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class BaseDatos extends SQLiteOpenHelper {

    private final static String NAME = "pedidos.db";
    private final static int VERSION = 1;

    public BaseDatos(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ClienteDAO.TABLE_NAME);
        onCreate(db);
    }
}
