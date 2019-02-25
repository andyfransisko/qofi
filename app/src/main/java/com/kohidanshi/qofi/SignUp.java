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
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private Button signup;
    private ImageView back;
    EditText fname, lname, email, uname, pass, cpass;
    sqlLiteConfig dbHelper;

    SharedPreferences session;
    protected Cursor cursor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbHelper = new sqlLiteConfig(this);

        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        signup = (Button) findViewById(R.id.signup);

        back = (ImageView) findViewById(R.id.back);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        uname = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        cpass = (EditText) findViewById(R.id.cpassword);





        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {



                String s1, s2, s3, s4, s5, s6;
                s1 = fname.getText().toString();
                s2 = lname.getText().toString();
                s3 = email.getText().toString();
                s4 = uname.getText().toString();
                s5 = pass.getText().toString();
                s6 = cpass.getText().toString();

                if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0 || s4.length() == 0 || s5.length() == 0 || s6.length() == 0) {
                    Toast.makeText(getApplication(), "All field must be filled.", Toast.LENGTH_SHORT).show();
                }
                else {


                    if (s4.matches("[a-zA-Z0-9]*")) {

                        if (s5.length() < 8) {
                            Toast.makeText(getApplication(), "Password must contain at least 8 characters.", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            if (!s6.equals(s5)) {

                                Toast.makeText(getApplication(), "Password and confirm password doesn't match.", Toast.LENGTH_SHORT).show();

                            } else {

                                SQLiteDatabase db = dbHelper.getReadableDatabase();


                                cursor = db.rawQuery("SELECT * FROM user WHERE userName = '" +s4+ "'", null);

                                if(cursor.moveToFirst()) {
                                    Toast.makeText(getApplicationContext(), "Username already exist.", Toast.LENGTH_LONG).show();

                                }
                                else {


                                    SQLiteDatabase db2 = dbHelper.getWritableDatabase();
                                    db2.execSQL("insert into user(userName, userFirstName, userLastName, userEmail, userPass, categoryId) values('" +
                                            s4 + "','" +
                                            s1 + "','" +
                                            s2 + "','" +
                                            s3 + "','" +
                                            s5 + "', NULL)");

                                    SharedPreferences.Editor editor = session.edit();

                                    editor.putString("username", s4);
                                    editor.putString("fname", s1);
                                    editor.putString("lname", s2);
                                    editor.putString("email", s3);
                                    editor.commit();

                                    Toast.makeText(getApplicationContext(), "You are now signed up.", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(getApplicationContext(), Introduction.class);
                                    startActivity(i);
                                    finish();
                                }

                            }
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username must only contain numbers and letters.", Toast.LENGTH_LONG).show();
                    }
                }


            }


        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });
    }
}
