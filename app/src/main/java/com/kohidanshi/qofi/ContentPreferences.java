package com.kohidanshi.qofi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContentPreferences extends AppCompatActivity {
    ImageView bacc, mainpref, pref1, pref2, pref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_preferences);

        bacc = (ImageView) findViewById(R.id.backbtn);
        mainpref = (ImageView) findViewById(R.id.cartcontent_pdesc);
        pref1 = (ImageView) findViewById(R.id.cbeanscontent_desc);
        pref2 = (ImageView) findViewById(R.id.cbrewingcontent_desc);
        pref3 = (ImageView) findViewById(R.id.ctypecontent_desc);

        bacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });
    }
}
