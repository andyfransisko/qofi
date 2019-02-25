package com.kohidanshi.qofi;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {


    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    sqlLiteConfig dbHelper;
    public static MainActivity ma;
    SharedPreferences session;
    TextView title;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        session = getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        final String uname = session.getString("username","");


        dbHelper = new sqlLiteConfig(getActivity());

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT topicName FROM topic INNER JOIN favorite ON topic.topicId = favorite.topicId WHERE favorite.userName = '"+uname+"'", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(0).toString();

        }
        ListView01 = (ListView) view.findViewById(R.id.listview);
        title = (TextView) view.findViewById(R.id.textView37);

        //final String titl = title.getText().toString();



        ListView01.setAdapter(new ArrayAdapter(getActivity(), R.layout.listrow, R.id.textView37, daftar));
        ListView01.setSelected(true);

        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"See Topic", "Remove From Favorite"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choice");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:


                                if(selection.equals("Cappuccino Art")) {
                                    Intent in1 = new Intent(getActivity(), CappuccinoArtCoffeeArt.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Chocolate Art")) {
                                    Intent in1 = new Intent(getActivity(), ChocolateArtCoffeeArt.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Etching")) {
                                    Intent in1 = new Intent(getActivity(), EtchingCoffeeArt.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Free Pouring")) {
                                    Intent in1 = new Intent(getActivity(), FreePouringCoffeeArt.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Microfoaming")) {
                                    Intent in1 = new Intent(getActivity(), MicrofoamingCoffeeArt.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Arabica")) {
                                    Intent in1 = new Intent(getActivity(), ArabicaCoffeeBeans.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Excelsa")) {
                                    Intent in1 = new Intent(getActivity(), ExcelsaCoffeeBeans.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Liberica")) {
                                    Intent in1 = new Intent(getActivity(), LibericaCoffeeBeans.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Robusta")) {
                                    Intent in1 = new Intent(getActivity(), RobustaCoffeeBeans.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Espresso Machine")) {
                                    Intent in1 = new Intent(getActivity(), EspressoMachineCoffeeBrewing.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Moka Pot")) {
                                    Intent in1 = new Intent(getActivity(), MokaPotCoffeeBrewing.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Pour Over")) {
                                    Intent in1 = new Intent(getActivity(), PourOverCoffeeBrewing.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Siphon")) {
                                    Intent in1 = new Intent(getActivity(), SiphonCoffeeBrewing.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("The Press")) {
                                    Intent in1 = new Intent(getActivity(), ThePressCoffeeBrewing.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Affogato")) {
                                    Intent in1 = new Intent(getActivity(), AffogatoCoffeeType.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Americano")) {
                                    Intent in1 = new Intent(getActivity(), AmericanoCoffeeType.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Cappuccino")) {
                                    Intent in1 = new Intent(getActivity(), CappuccinoCoffeeType.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Espresso")) {
                                    Intent in1 = new Intent(getActivity(), EspressoCoffeeType.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Latte")) {
                                    Intent in1 = new Intent(getActivity(), LatteCoffeeType.class);
                                    startActivity(in1);
                                    break;
                                }

                                if(selection.equals("Macchiato")) {
                                    Intent in1 = new Intent(getActivity(), MacchiatoCoffeeType.class);
                                    startActivity(in1);
                                    break;
                                }


                            case 1:
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.execSQL("DELETE FROM favorite WHERE topicId IN (SELECT topicId FROM topic WHERE topicName = '"+selection+"') AND userName = '"+uname+"'");
                                Toast.makeText(getActivity(), "Topic removed from favorite.", Toast.LENGTH_SHORT).show();
                                dbHelper = new sqlLiteConfig(getActivity());

                                SQLiteDatabase dbb = dbHelper.getReadableDatabase();
                                cursor = dbb.rawQuery("SELECT topicName FROM topic INNER JOIN favorite ON topic.topicId = favorite.topicId WHERE favorite.userName = '"+uname+"'", null);
                                daftar = new String[cursor.getCount()];
                                cursor.moveToFirst();
                                for (int cc = 0; cc < cursor.getCount(); cc++) {
                                    cursor.moveToPosition(cc);
                                    daftar[cc] = cursor.getString(0).toString();

                                }
                                ListView01.setAdapter(new ArrayAdapter(getActivity(), R.layout.listrow, R.id.textView37, daftar));
                                /*Intent i = new Intent(getActivity(), MainMenu.class);
                                String value = "favorite";
                                i.putExtra("frgName", value);


                                startActivity(i);*/
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();






    //public void RefreshList() {




    //}

    //

        // Inflate the layout for this fragment*/
        return view;
    }

}
