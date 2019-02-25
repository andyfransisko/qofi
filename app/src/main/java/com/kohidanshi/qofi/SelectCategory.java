package com.kohidanshi.qofi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectCategory extends AppCompatActivity {

    ImageView coffeeart, coffeebeans, coffeebrew, coffeetypes;
    Button icoffeeart, icoffeebeans, icoffeebrew, icoffeetypes;
    sqlLiteConfig dbHelper;

    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        dbHelper = new sqlLiteConfig(this);

        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        coffeeart = (ImageView) findViewById(R.id.coffeeart);
        coffeebeans = (ImageView) findViewById(R.id.coffeebeans);
        coffeebrew = (ImageView) findViewById(R.id.coffeebrew);
        coffeetypes = (ImageView) findViewById(R.id.coffeetypes);

        icoffeeart = (Button) findViewById(R.id.icoffeeart);
        icoffeebeans = (Button) findViewById(R.id.icoffeebeans);
        icoffeebrew = (Button) findViewById(R.id.icoffeebrewing);
        icoffeetypes = (Button) findViewById(R.id.icoffeetypes);

        final String username = session.getString("username","");


        coffeeart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String id = "1";

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE user SET categoryId='"+
                        id+"' WHERE userName='" +
                        username +"'");


                db.execSQL("DELETE FROM favorite WHERE userName = '"+username+"'");

                SharedPreferences.Editor editor = session.edit();

                editor.putString("categoryid", id);
                editor.commit();


                Intent i = new Intent(getApplicationContext(), MainMenu.class);


                String value = "home";
                i.putExtra("frgName", value);

                startActivity(i);
                finish();
            }


        });

        coffeebeans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String id = "2";

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE user SET categoryId='"+
                        id+"' WHERE userName='" +
                        username +"'");

                db.execSQL("DELETE FROM favorite WHERE userName = '"+username+"'");

                SharedPreferences.Editor editor = session.edit();


                editor.putString("categoryid", id);
                editor.commit();
                Intent i = new Intent(getApplicationContext(), MainMenu.class);


                String value = "home";
                i.putExtra("frgName", value);
                startActivity(i);
                finish();
            }


        });

        coffeebrew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String id = "3";

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE user SET categoryId='"+
                        id+"' WHERE userName='" +
                        username +"'");

                db.execSQL("DELETE FROM favorite WHERE userName = '"+username+"'");

                SharedPreferences.Editor editor = session.edit();


                editor.putString("categoryid", id);
                editor.commit();


                Intent i = new Intent(getApplicationContext(), MainMenu.class);

                String value = "home";
                i.putExtra("frgName", value);
                startActivity(i);
                finish();
            }


        });

        coffeetypes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String id = "4";

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE user SET categoryId='"+
                        id+"' WHERE userName='" +
                        username +"'");

                db.execSQL("DELETE FROM favorite WHERE userName = '"+username+"'");

                SharedPreferences.Editor editor = session.edit();


                editor.putString("categoryid", id);
                editor.commit();
                Intent i = new Intent(getApplicationContext(), MainMenu.class);

                String value = "home";
                i.putExtra("frgName", value);
                startActivity(i);
                finish();
            }


        });

        icoffeeart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), CoffeeArtDesc.class);
                startActivity(i);
                finish();
            }


        });

        icoffeebeans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), CoffeeBeansDesc.class);
                startActivity(i);
                finish();
            }


        });

        icoffeebrew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), CoffeeBrewingDesc.class);
                startActivity(i);
                finish();
            }


        });

        icoffeetypes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), CoffeeTypesDesc.class);
                startActivity(i);
                finish();
            }


        });
    }
}
