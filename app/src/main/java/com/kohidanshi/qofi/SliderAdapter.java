package com.kohidanshi.qofi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;




public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    Typeface lig, med, medit, thicc;




    public SliderAdapter(Context context) {
        this.context = context;

    }

    public int[] slide_images = {
            R.drawable.qofilogo05,
            R.drawable.qofilogo03,
            R.drawable.qofilogo96,
            R.drawable.qofilogo07
    };

    public String[] slide_headings = {
            "Welcome to Qofi",
            "New Era of Coffee Tour",
            "Sipping through Nature & City",
            "Qualified as a New User"
    };

    public String[] slide_descs = {
            "Explore through the whole application by select each section of coffee knowledge",
            "Qofi offers you an enjoyable experience of coffee touring with great accessibility",
            "Qofi provided a glossary of what you can expect from the coffee scene in the world",
            "Now you're in lad! Let's seek into the coffee universe and enjoy Qofi with a cup of coffee"
    };








    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);



        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);


        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
