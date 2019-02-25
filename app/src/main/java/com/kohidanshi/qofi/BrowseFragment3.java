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
public class BrowseFragment3 extends Fragment {

    ImageView bacc, cp1, cp2, cp3, cp4, cp5, cp6, cp7;



    public BrowseFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_browse3, container, false);

        cp2 = (ImageView) view.findViewById(R.id.pic2);
        cp4 = (ImageView) view.findViewById(R.id.pic4);
        cp5 = (ImageView) view.findViewById(R.id.pic5);
        cp6 = (ImageView) view.findViewById(R.id.pic6);
        cp7 = (ImageView) view.findViewById(R.id.pic7);


        cp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), EspressoMachineCoffeeBrewing.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });


        cp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), MokaPotCoffeeBrewing.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        cp5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), PourOverCoffeeBrewing.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        cp6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), SiphonCoffeeBrewing.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        cp7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), ThePressCoffeeBrewing.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        // Inflate the layout for this fragment
        return view;
    }

}
