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
import android.widget.Toast;

public class ChangePass extends AppCompatActivity {

    EditText opass, npass, cpass;
    Button savepr;

    sqlLiteConfig dbHelper;
    protected Cursor cursor;

    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);


        dbHelper = new sqlLiteConfig(this);

        opass = (EditText) findViewById(R.id.opass);
        npass = (EditText) findViewById(R.id.npass);
        cpass = (EditText) findViewById(R.id.cpass);
        savepr = (Button) findViewById(R.id.changeprof);

        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        final String uname = session.getString("username", "");

        savepr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String s1, s2, s3, s4, s5, s6;
                s1 = opass.getText().toString();
                s2 = npass.getText().toString();
                s3 = cpass.getText().toString();

                if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0) {
                    Toast.makeText(getApplication(), "All field must be filled.", Toast.LENGTH_SHORT).show();
                }
                else {


                        if (s1.length() < 8 || s2.length() < 8 || s3.length() < 8) {
                            Toast.makeText(getApplication(), "Password must contain at least 8 characters.", Toast.LENGTH_SHORT).show();
                        }

                        else{

                            SQLiteDatabase db = dbHelper.getReadableDatabase();


                            cursor = db.rawQuery("SELECT * FROM user WHERE userName = '" +uname+ "' AND userPass = '"+s1+ "'", null);

                            if(cursor.moveToFirst()) {

                                    if (!s3.equals(s2)) {

                                    Toast.makeText(getApplication(), "Password and confirm password doesn't match.", Toast.LENGTH_SHORT).show();

                                    }

                                    else{



                                            SQLiteDatabase db2 = dbHelper.getWritableDatabase();
                                            db2.execSQL("UPDATE user SET userPass = '"+s2+"' WHERE userName = '"+uname+"' AND userPass = '"+s1+"'");


                                            Toast.makeText(getApplicationContext(), "Your password has been changed.", Toast.LENGTH_LONG).show();



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


            }



        });



    }
}
