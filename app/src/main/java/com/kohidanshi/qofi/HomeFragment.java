package com.kohidanshi.qofi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView welcome, username, news_main, news_head, news_desc, reco, reco_desc, mind, mind_desc;
    Typeface lig, med, medit, thicc;
    ImageView intercoffee, fuglencoffee, brewbrewcoffee, undergroundcoffee, qr1, qr2, qr3, qr4;

    SharedPreferences session;


    public HomeFragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        session = getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        welcome = (TextView) view.findViewById(R.id.welcome);
        username = (TextView) view.findViewById(R.id.unamelog);
        news_main = (TextView) view.findViewById(R.id.ma_main);
        news_head = (TextView) view.findViewById(R.id.ma_head);
        reco = (TextView) view.findViewById(R.id.qofurecommend);
        reco_desc = (TextView) view.findViewById(R.id.qofurecommend_desc);
        mind = (TextView) view.findViewById(R.id.qontrolmind);
        mind_desc = (TextView) view.findViewById(R.id.qontrolmind_desc);
        intercoffee = (ImageView) view.findViewById(R.id.imageView2);


        qr1 = (ImageView) view.findViewById(R.id.imageView16);
        qr2 = (ImageView) view.findViewById(R.id.imageView17);

        intercoffee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), News_InternationalCoffeeDay.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });

        qr1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), Recommend_MetalStraws.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });

        qr2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), Recommend_VintageDesign.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });
        String uname = session.getString("username","");
        String fname = session.getString("fname","");
        String lname = session.getString("lname","");

        String id = session.getString("categoryid","");

        username.setText(fname+" "+lname);

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
