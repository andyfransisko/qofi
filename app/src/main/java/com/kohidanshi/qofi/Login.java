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
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button login;
    private TextView signup;
    private EditText usrname, password;

    sqlLiteConfig dbHelper;

    protected Cursor cursor;

    SharedPreferences session;
    String[] daftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new sqlLiteConfig(this);

        session = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);


        login = (Button) findViewById(R.id.login);
        signup = (TextView) findViewById(R.id.signuplog);

        usrname = (EditText) findViewById(R.id.unamelog);
        password = (EditText) findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String s1, s2;
                s1 = usrname.getText().toString();
                s2 = password.getText().toString();

                if (s1.length() == 0 || s2.length() == 0) {
                    Toast.makeText(getApplication(), "All field must be filled.", Toast.LENGTH_SHORT).show();
                } else {

                    String uname, fname, lname, pass, categoryid, email;

                    SQLiteDatabase db = dbHelper.getReadableDatabase();

                    cursor = db.rawQuery("SELECT * FROM user WHERE userName = '" +s1+ "' AND userPass = '"+s2+ "' AND categoryId IS NULL" ,null);

                    if(cursor.moveToFirst()) {

                        uname = cursor.getString(0).toString();
                        fname = cursor.getString(1).toString();
                        lname = cursor.getString(2).toString();
                        email = cursor.getString(3).toString();
                        pass = cursor.getString(4).toString();

                        SharedPreferences.Editor editor = session.edit();

                        editor.putString("username", uname);
                        editor.putString("fname", fname);
                        editor.putString("lname", lname);
                        editor.putString("email", email);
                        editor.commit();

                        Toast.makeText(getApplicationContext(), "You are now logged in.", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), SelectCategory.class);
                        startActivity(i);
                        finish();
                    }

                    cursor = db.rawQuery("SELECT * FROM user WHERE userName = '" +s1+ "' AND userPass = '"+s2+ "'", null);

                    if(cursor.moveToFirst()) {

                        uname = cursor.getString(0).toString();
                        fname = cursor.getString(1).toString();
                        lname = cursor.getString(2).toString();
                        email = cursor.getString(3).toString();
                        pass = cursor.getString(4).toString();
                        categoryid = cursor.getString(5).toString();

                        SharedPreferences.Editor editor = session.edit();

                        editor.putString("username", uname);
                        editor.putString("fname", fname);
                        editor.putString("lname", lname);
                        editor.putString("email", email);
                        editor.putString("categoryid", categoryid);

                        editor.commit();

                        Toast.makeText(getApplicationContext(), "You are now logged in.", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainMenu.class);

                        String value = "home";
                        i.putExtra("frgName", value);
                        startActivity(i);
                        finish();
                    }

                    else {
                        Toast.makeText(getApplicationContext(), "Invalid username or password.", Toast.LENGTH_LONG).show();

                    }
                }

            }

        });

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }


        });
    }
}
