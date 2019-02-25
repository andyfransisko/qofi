package com.kohidanshi.qofi;

import android.content.Intent;
import android.graphics.Typeface;
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

public class BrowseCoffeeBeans extends AppCompatActivity {

    private BottomNavigationView MainNav;
    private FrameLayout MainFrame;
    TextView cd1, cd2, cd3, cd4;
    Typeface lig, med, medit, thicc;
    ImageView bacc, cp1, cp2, cp3, cp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_coffee_beans);

        cd1 = (TextView) findViewById(R.id.text1_desc);
        cd2 = (TextView) findViewById(R.id.text2_desc);
        cd3 = (TextView) findViewById(R.id.text3_desc);
        cd4 = (TextView) findViewById(R.id.text4_desc);

        cp1 = (ImageView) findViewById(R.id.pic1);
        cp2 = (ImageView) findViewById(R.id.pic2);
        cp3 = (ImageView) findViewById(R.id.pic3);
        cp4 = (ImageView) findViewById(R.id.pic4);

        bacc = (ImageView) findViewById(R.id.backbtn);
        lig = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Light.ttf");
        med = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Medium.ttf");
        medit = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-MediumItalic.ttf");
        thicc = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Bold.ttf");

        MainFrame = (FrameLayout) findViewById(R.id.main_frame);
        MainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        cd1.setTypeface(med);
        cd2.setTypeface(med);
        cd3.setTypeface(med);
        cd4.setTypeface(med);

        cp1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ArabicaCoffeeBeans.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ExcelsaCoffeeBeans.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), LibericaCoffeeBeans.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), RobustaCoffeeBeans.class);
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
