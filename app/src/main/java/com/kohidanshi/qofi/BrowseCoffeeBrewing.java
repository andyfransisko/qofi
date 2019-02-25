package com.kohidanshi.qofi;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class BrowseCoffeeBrewing extends AppCompatActivity {

    private BottomNavigationView MainNav;
    private FrameLayout MainFrame;
    TextView cd1, cd2, cd3, cd4, cd5, cd6, cd7;
    Typeface lig, med, medit, thicc;
    ImageView bacc, cp1, cp2, cp3, cp4, cp5, cp6, cp7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_coffee_brewing);

        cd2 = (TextView) findViewById(R.id.text2_desc);
        cd4 = (TextView) findViewById(R.id.text4_desc);
        cd5 = (TextView) findViewById(R.id.text5_desc);
        cd6 = (TextView) findViewById(R.id.text6_desc);
        cd7 = (TextView) findViewById(R.id.text7_desc);


        cp2 = (ImageView) findViewById(R.id.pic2);
        cp4 = (ImageView) findViewById(R.id.pic4);
        cp5 = (ImageView) findViewById(R.id.pic5);
        cp6 = (ImageView) findViewById(R.id.pic6);
        cp7 = (ImageView) findViewById(R.id.pic7);

        bacc = (ImageView) findViewById(R.id.backbtn);
        lig = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Light.ttf");
        med = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Medium.ttf");
        medit = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-MediumItalic.ttf");
        thicc = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Bold.ttf");

        MainFrame = (FrameLayout) findViewById(R.id.main_frame);
        MainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        cd2.setTypeface(med);
        cd4.setTypeface(med);
        cd5.setTypeface(med);
        cd6.setTypeface(med);
        cd7.setTypeface(med);


        cp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), EspressoMachineCoffeeBrewing.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });


        cp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), MokaPotCoffeeBrewing.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), PourOverCoffeeBrewing.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SiphonCoffeeBrewing.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ThePressCoffeeBrewing.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        bacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), BrowseCategory.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });

    }


}
