package com.kohidanshi.qofi;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;



public class MainMenu extends AppCompatActivity {
    TextView welcome, username, news_main, news_head, news_desc, reco, reco_desc, mind, mind_desc;
    Typeface lig, med, medit, thicc;
    ImageView intercoffee, fuglencoffee, brewbrewcoffee, undergroundcoffee, qr1, qr2, qr3, qr4;
    private BottomNavigationView MainNav;
    private FrameLayout MainFrame;
    private HomeFragment homeFragment;
    private BrowseFragment1 browseFragment1;
    private BrowseFragment2 browseFragment2;
    private BrowseFragment3 browseFragment3;
    private BrowseFragment4 browseFragment4;
    private FavoriteFragment favoriteFragment;
    private ProfileFragment profileFragment;

    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
/*
        welcome = (TextView) findViewById(R.id.welcome);
        username = (TextView) findViewById(R.id.email);
        news_main = (TextView) findViewById(R.id.ma_main);
        news_head = (TextView) findViewById(R.id.ma_head);
        news_desc = (TextView) findViewById(R.id.ma_desc);
        reco = (TextView) findViewById(R.id.qofurecommend);
        reco_desc = (TextView) findViewById(R.id.qofurecommend_desc);
        mind = (TextView) findViewById(R.id.qontrolmind);
        mind_desc = (TextView) findViewById(R.id.qontrolmind_desc);
        intercoffee = (ImageView) findViewById(R.id.imageView2);

        */

        MainFrame = (FrameLayout) findViewById(R.id.main_frame);
        MainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        browseFragment1 = new BrowseFragment1();
        browseFragment2 = new BrowseFragment2();
        browseFragment3 = new BrowseFragment3();
        browseFragment4 = new BrowseFragment4();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();


        setFragment(homeFragment);

        String data = getIntent().getExtras().getString("frgName", "home");




            switch (data){

                case "home" :
                    setFragment(homeFragment);
                    break;

                case "favorite" :
                    setFragment(favoriteFragment);
                    break;

                case "profile" :
                    setFragment(profileFragment);
                    break;

                    default:
                        setFragment(homeFragment);
                        break;



            }


        final String id = session.getString("categoryid","");



        MainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {




                switch (menuItem.getItemId()){

                    case R.id.nav_home :
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_browse :
                        if (id.equals("1"))
                            setFragment(browseFragment1);

                        if (id.equals("2"))
                            setFragment(browseFragment2);

                        if (id.equals("3"))
                            setFragment(browseFragment3);

                        if (id.equals("4"))
                            setFragment(browseFragment4);


                        return true;

                    case R.id.nav_favorites :
                        setFragment(favoriteFragment);
                        return true;

                    case R.id.nav_profile :
                        setFragment(profileFragment);
                        return true;

                        default:
                            return false;


                }



            }
        });



    }

    private void setFragment (Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}
