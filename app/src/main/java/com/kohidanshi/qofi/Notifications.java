package com.kohidanshi.qofi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class Notifications extends AppCompatActivity {
    ImageView bacc;
    Switch qono, upno, hono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        bacc = (ImageView) findViewById(R.id.backbtn);
        qono = (Switch) findViewById(R.id.qofi_notif);
        upno = (Switch) findViewById(R.id.update_notif);
        hono = (Switch) findViewById(R.id.home_notif);

        bacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Profilee.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }


        });
    }
}
