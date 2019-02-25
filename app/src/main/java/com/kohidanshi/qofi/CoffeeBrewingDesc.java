package com.kohidanshi.qofi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CoffeeBrewingDesc extends AppCompatActivity {
    Typeface lig, med, medit, thicc;
    TextView title, desc;
    ImageView bacc;


    sqlLiteConfig dbHelper;
    protected Cursor cursor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_brewing_desc);

        dbHelper = new sqlLiteConfig(this);

        title = (TextView)findViewById(R.id.coffeebrew);
        desc = (TextView)findViewById(R.id.coffeebrewdesc);
        bacc = (ImageView)findViewById(R.id.bacc);

        lig = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Light.ttf");
        med = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Medium.ttf");
        medit = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-MediumItalic.ttf");
        thicc = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Bold.ttf");

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String s1;
        s1 = title.getText().toString();

        cursor = db.rawQuery("SELECT categoryDesc FROM category WHERE categoryName = '"+s1+"'", null);

        if(cursor.moveToFirst()) {

            String descr = cursor.getString(0).toString();

            desc.setText(descr);


            title.setTypeface(med);
            desc.setTypeface(med);

        }

        bacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SelectCategory.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });
    }
}
