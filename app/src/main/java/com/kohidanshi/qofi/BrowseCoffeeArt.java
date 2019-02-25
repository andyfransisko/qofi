package com.kohidanshi.qofi;

import android.content.Intent;
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

public class BrowseCoffeeArt extends AppCompatActivity {

    private BottomNavigationView MainNav;
    private FrameLayout MainFrame;
    ImageView cp1, cp2, cp3, cp4, cp5, bacc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_coffee_art);

        cp1 = (ImageView) findViewById(R.id.pic1);
        cp2 = (ImageView) findViewById(R.id.pic2);
        cp3 = (ImageView) findViewById(R.id.pic3);
        cp4 = (ImageView) findViewById(R.id.pic4);
        cp5 = (ImageView) findViewById(R.id.pic5);
        bacc = (ImageView) findViewById(R.id.backbtn);

        MainFrame = (FrameLayout) findViewById(R.id.main_frame);
        MainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        bacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), BrowseCategory.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });

        cp1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), CappuccinoArtCoffeeArt.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ChocolateArtCoffeeArt.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), EtchingCoffeeArt.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), FreePouringCoffeeArt.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });

        cp5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), MicrofoamingCoffeeArt.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });
        }
    }

