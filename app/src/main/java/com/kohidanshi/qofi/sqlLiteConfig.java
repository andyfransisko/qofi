package com.kohidanshi.qofi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class sqlLiteConfig extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "qofiDBfix.db";
    private static final int DATABASE_VERSION = 30;

    public sqlLiteConfig(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade(30);
    }


    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
