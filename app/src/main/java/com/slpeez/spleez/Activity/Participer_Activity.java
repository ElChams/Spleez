package com.slpeez.spleez.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.slpeez.spleez.Menu.NavigationDrawer;

public class Participer_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participer_);

        /* Initialisation menu */
        final DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageButton spleez = (ImageButton) findViewById(R.id.spleez);
        final ImageView photo = (ImageView) findViewById(R.id.icon_image);
        final Bitmap obm = BitmapFactory.decodeResource(getResources(), R.drawable.profile_image);
        NavigationDrawer nd = new NavigationDrawer(this, drawer_layout, spleez, obm, photo).navigationDrawerInitialize();

        ImageButton Sport= (ImageButton)findViewById(R.id.Sport);
        ImageButton Cafe= (ImageButton)findViewById(R.id.Cafe);
        ImageButton Voyage= (ImageButton)findViewById(R.id.Voyage);
        ImageButton Cinema= (ImageButton)findViewById(R.id.Cinema);
        ImageButton Apero= (ImageButton)findViewById(R.id.Apero);
        ImageButton JeuxVideo= (ImageButton)findViewById(R.id.JeuxVideo);
        ImageButton Atable= (ImageButton)findViewById(R.id.Atable);
        ImageButton Jobs= (ImageButton)findViewById(R.id.Jobs);
        ImageButton Culture= (ImageButton)findViewById(R.id.Culture);
        ImageButton Event= (ImageButton)findViewById(R.id.logoevent);

        Event.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent openCreerParticiper = new Intent(getApplicationContext(), ChoiceActivity.class);
                startActivity(openCreerParticiper);
            }
        });

        Apero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Sport.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Cafe.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Voyage.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Cinema.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        JeuxVideo.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Culture.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Atable.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
        Jobs.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {
                Intent openParticipation = new Intent(getApplicationContext(), ListActActivity.class);
                startActivity(openParticipation);
            }
        });
    }
}
