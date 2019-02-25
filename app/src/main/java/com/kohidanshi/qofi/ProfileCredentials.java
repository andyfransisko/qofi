package com.kohidanshi.qofi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileCredentials extends AppCompatActivity {
    ImageView bacc;
    EditText e_uname, e_fname, e_lname, e_email, e_pass;
    Button savepr, navprof;

    sqlLiteConfig dbHelper;

    SharedPreferences session;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_credentials);

        dbHelper = new sqlLiteConfig(this);

        e_uname = (EditText) findViewById(R.id.username2);
        e_fname = (EditText) findViewById(R.id.fname2);
        e_lname = (EditText) findViewById(R.id.lname2);
        e_email = (EditText) findViewById(R.id.email2);
        e_pass = (EditText) findViewById(R.id.password2);
        savepr = (Button) findViewById(R.id.changeprof);
        navprof = (Button) findViewById(R.id.nav_profile);

        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);


        final String uname = session.getString("username", "");
        String fname = session.getString("fname", "");
        String lname = session.getString("lname", "");

        String emaill = session.getString("email", "");
        String id = session.getString("categoryid", "");

        e_fname.setText(fname);
        e_lname.setText(lname);
        e_uname.setText(uname);
        e_email.setText(emaill);


        savepr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String s1, s2, s3, s4, s5, s6;
                s1 = e_fname.getText().toString();
                s2 = e_lname.getText().toString();
                s3 = e_email.getText().toString();
                s4 = e_uname.getText().toString();
                s5 = e_pass.getText().toString();

                if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0 || s4.length() == 0 || s5.length() == 0) {
                    Toast.makeText(getApplication(), "All field must be filled.", Toast.LENGTH_SHORT).show();
                }
                else {


                    if (s4.matches("[a-zA-Z0-9]*")) {

                        if (s5.length() < 8) {
                            Toast.makeText(getApplication(), "Password must contain at least 8 characters.", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            SQLiteDatabase db = dbHelper.getReadableDatabase();


                            cursor = db.rawQuery("SELECT * FROM user WHERE userName = '" +uname+ "' AND userPass = '"+s5+ "'", null);

                            if(cursor.moveToFirst()) {

                                SQLiteDatabase db3 = dbHelper.getReadableDatabase();


                                cursor = db3.rawQuery("SELECT * FROM user WHERE userName = '" +s4+ "'", null);

                                if(cursor.moveToFirst() && !s4.equals(uname)) {


                                    Toast.makeText(getApplicationContext(), "Username already exist.", Toast.LENGTH_LONG).show();

                                }
                                else {


                                    SQLiteDatabase db2 = dbHelper.getWritableDatabase();
                                    db2.execSQL("UPDATE user SET userName = '"+s4+"', userFirstName = '"+s1+"', userLastName = '"+s2+"', userEmail = '"+s3+"' WHERE userName = '"+uname+"' AND userPass = '"+s5+"'");

                                    SharedPreferences.Editor editor = session.edit();

                                    editor.putString("username", s4);
                                    editor.putString("fname", s1);
                                    editor.putString("lname", s2);
                                    editor.putString("email", s3);
                                    editor.commit();

                                    Toast.makeText(getApplicationContext(), "Your profile has been updated.", Toast.LENGTH_LONG).show();



                                    Intent i = new Intent(getApplicationContext(), MainMenu.class);

                                    String value = "profile";
                                    i.putExtra("frgName", value);

                                    startActivity(i);

                                }



                            } else {

                                Toast.makeText(getApplication(), "Incorrect password.", Toast.LENGTH_SHORT).show();

                            }
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username must only contain numbers and letters.", Toast.LENGTH_LONG).show();
                    }
                }


            }



        });
    }


}
