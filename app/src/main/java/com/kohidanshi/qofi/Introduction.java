package com.kohidanshi.qofi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {
    Typeface lig, med, medit, thicc;

    private ViewPager mslideViewPager;
    private LinearLayout mdotLayout;
    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private ImageView ok;
    private Button back, next;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        mslideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mdotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        ok = (ImageView) findViewById(R.id.btnok);
        back = (Button) findViewById(R.id.back);
        next = (Button) findViewById(R.id.next);

        sliderAdapter = new SliderAdapter(this);
        mslideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListener);
        ok.setVisibility(View.INVISIBLE);
        ok.setEnabled(false);
        back.setVisibility(View.INVISIBLE);
        back.setEnabled(false);

        lig = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Light.ttf");
        med = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Medium.ttf");
        medit = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-MediumItalic.ttf");
        thicc = Typeface.createFromAsset(getAssets(), "fonts/CoreSansG-Bold.ttf");

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SelectCategory.class);
                startActivity(i);
                finish();
            }

        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[4];
        mdotLayout.removeAllViews();

        for(int i = 0;  i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(36);
            mDots[i].setTextColor(getResources().getColor(R.color.dotDark));

            mdotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled (int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;


            if(i == 0) {
                back.setEnabled(false);
                back.setVisibility(View.INVISIBLE);

            }
            else if(i == 3){
                ok.setVisibility(View.VISIBLE);
                ok.setEnabled(true);
                next.setEnabled(false);
                next.setVisibility(View.INVISIBLE);

            }


            else{
                ok.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);
                back.setEnabled(true);
                next.setVisibility(View.VISIBLE);
                next.setEnabled(true);

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }

    };
}
