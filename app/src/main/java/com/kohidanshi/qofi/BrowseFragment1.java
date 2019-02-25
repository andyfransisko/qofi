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
public class BrowseFragment1 extends Fragment {

    ImageView cp1, cp2, cp3, cp4, cp5;


    public BrowseFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        cp1 = (ImageView) view.findViewById(R.id.pic1);
        cp2 = (ImageView) view.findViewById(R.id.pic2);
        cp3 = (ImageView) view.findViewById(R.id.pic3);
        cp4 = (ImageView) view.findViewById(R.id.pic4);
        cp5 = (ImageView) view.findViewById(R.id.pic5);


        cp1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), CappuccinoArtCoffeeArt.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });

        cp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), ChocolateArtCoffeeArt.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });

        cp3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), EtchingCoffeeArt.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        cp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), FreePouringCoffeeArt.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });

        cp5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), MicrofoamingCoffeeArt.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }


        });

        // Inflate the layout for this fragment
        return view;
    }

}
