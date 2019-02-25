package com.kohidanshi.qofi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Profilee extends AppCompatActivity {
    Button changepr, notify, contentpr, managefav, clearfav, qofiprofile, byebye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilee);

        changepr = (Button) findViewById(R.id.changeprofile);
        notify = (Button) findViewById(R.id.notif);
        contentpr = (Button) findViewById(R.id.contentpref);
        managefav = (Button) findViewById(R.id.managefavnote);
        clearfav = (Button) findViewById(R.id.clearfavnotes);
        qofiprofile = (Button) findViewById(R.id.aboutqofi);
        byebye = (Button) findViewById(R.id.logout);

        changepr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ProfileCredentials.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });

        qofiprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), AboutQofi.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        managefav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ManageFavoriteNotes.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });
    }
}
