package com.kohidanshi.qofi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MacchiatoCoffeeType extends AppCompatActivity {
    TextView d_title, d_desc;
    Typeface lig, med, medit, thicc;
    ImageView bacc, star;

    SharedPreferences session;

    sqlLiteConfig dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macchiato_coffee_type);
        dbHelper = new sqlLiteConfig(this);
        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        d_title = (TextView) findViewById(R.id.macchiato_title);
        d_desc = (TextView) findViewById(R.id.macchiato_descript);
        bacc = (ImageView) findViewById(R.id.backbtn);
        star = (ImageView) findViewById(R.id.imageView23);


        lig = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Light.ttf");
        med = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Medium.ttf");
        medit = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-MediumItalic.ttf");
        thicc = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Bold.ttf");

        d_title.setTypeface(thicc);
        d_desc.setTypeface(med);


        SQLiteDatabase db = dbHelper.getReadableDatabase();

        final String s1;
        s1 = d_title.getText().toString();

        cursor = db.rawQuery("SELECT topicDesc FROM topic WHERE topicName = '"+s1+"'", null);

        if(cursor.moveToFirst()) {

            String descr = cursor.getString(0).toString();

            d_desc.setText(descr);


            d_title.setTypeface(med);
            d_desc.setTypeface(med);

        }

        String uname = session.getString("username","");


        SQLiteDatabase db4 = dbHelper.getReadableDatabase();

        cursor = db4.rawQuery("SELECT * FROM topic WHERE topicName = '"+s1+"'", null);

        if(cursor.moveToFirst()) {

            String tid, catid;

            tid = cursor.getString(0).toString();
            catid = cursor.getString(1).toString();


            SQLiteDatabase db3 = dbHelper.getReadableDatabase();

            cursor = db3.rawQuery("SELECT * FROM favorite WHERE userName = '" + uname + "' AND topicId = '" + tid + "'", null);

            if (cursor.moveToFirst()) {
                star.setImageResource(R.drawable.fav_btn_clicked);

            }
        }

        star.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String uname = session.getString("username","");


                SQLiteDatabase db3 = dbHelper.getReadableDatabase();

                cursor = db3.rawQuery("SELECT * FROM topic WHERE topicName = '"+s1+"'", null);

                if(cursor.moveToFirst()) {

                    String tid, catid;

                    tid = cursor.getString(0).toString();
                    catid = cursor.getString(1).toString();



                    SQLiteDatabase db1 = dbHelper.getReadableDatabase();

                    cursor = db1.rawQuery("SELECT * FROM favorite WHERE userName = '"+uname+"' AND topicId = '"+tid+"'", null);

                    if(cursor.moveToFirst()) {

                        Toast.makeText(getApplicationContext(), "This topic is already in your favorite.", Toast.LENGTH_LONG).show();

                    }else{


                        SQLiteDatabase db2 = dbHelper.getWritableDatabase();

                        db2.execSQL("insert into favorite(favoriteId, userName, categoryId, topicId) values(null,'" + uname + "','" +
                                catid + "','" +
                                tid + "')");

                        star.setImageResource(R.drawable.fav_btn_clicked);

                        Toast.makeText(getApplicationContext(), "Topic added to favorite.", Toast.LENGTH_LONG).show();


                    }

                }
                else{
                    Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}