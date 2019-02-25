package com.kohidanshi.qofi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrowseFragment4 extends Fragment {

    ImageView cp1, cp2, cp3, cp6, cp7, cp8, cp9, cp10, cp11, cp12, cp13;


    public BrowseFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_browse4, container, false);



        cp1 = (ImageView) view.findViewById(R.id.pic1);
        cp2 = (ImageView) view.findViewById(R.id.pic2);
        cp3 = (ImageView) view.findViewById(R.id.pic3);
        cp7 = (ImageView) view.findViewById(R.id.pic7);
        cp10 = (ImageView) view.findViewById(R.id.pic10);
        cp12 = (ImageView) view.findViewById(R.id.pic12);

        cp1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), AffogatoCoffeeType.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        cp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), AmericanoCoffeeType.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        cp3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), CappuccinoCoffeeType.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });




        cp7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), EspressoCoffeeType.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });


        cp10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), LatteCoffeeType.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });


        cp12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), MacchiatoCoffeeType.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });


        // Inflate the layout for this fragment
        return view;
    }

}
