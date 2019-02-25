package com.kohidanshi.qofi;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView name, username, email;
    Button changepr, notify, contentpr, managefav, clearfav, qofiprofile, byebye, changepass;

    SharedPreferences session;
    sqlLiteConfig dbHelper;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        dbHelper = new sqlLiteConfig(getActivity());

        changepr = (Button) view.findViewById(R.id.changeprofile);
        contentpr = (Button) view.findViewById(R.id.contentpref);
        clearfav = (Button) view.findViewById(R.id.clearfavnotes);
        qofiprofile = (Button) view.findViewById(R.id.aboutqofi);
        byebye = (Button) view.findViewById(R.id.logout);
        changepass = (Button) view.findViewById(R.id.changepass);

        session = getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        name = (TextView) view.findViewById(R.id.name);
        username = (TextView) view.findViewById(R.id.usrname);
        email = (TextView) view.findViewById(R.id.eml);

        final String uname = session.getString("username","");
        String fname = session.getString("fname","");
        String lname = session.getString("lname","");

        String emaill = session.getString("email","");
        String id = session.getString("categoryid","");

        name.setText(fname+" "+lname);
        username.setText(uname);
        email.setText(emaill);

        changepass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), ChangePass.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        changepr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), ProfileCredentials.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }


        });

        contentpr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), SelectCategory.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        qofiprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), AboutQofi.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        clearfav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM favorite WHERE userName = '"+uname+"'");
                Toast.makeText(getActivity(), "All favorite has been cleared.", Toast.LENGTH_SHORT).show();

            }


        });

        byebye.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {



                SharedPreferences.Editor editor = session.edit();

                editor.clear();
                editor.commit();

                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);

            }


        });










        // Inflate the layout for this fragment
        return view;
    }

}
