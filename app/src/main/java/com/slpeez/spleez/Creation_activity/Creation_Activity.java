package com.slpeez.spleez.Creation_activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.slpeez.spleez.CreerParticiper_Activity;
import com.slpeez.spleez.Creer_Activity_;
import com.slpeez.spleez.Menu.NavigationDrawer;
import com.slpeez.spleez.R;

public class Creation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_activity);

        /* Initialisation menu */
        final DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageButton spleez = (ImageButton) findViewById(R.id.spleez);
        final ImageView photo = (ImageView) findViewById(R.id.icon_image);
        final Bitmap obm = BitmapFactory.decodeResource(getResources(), R.drawable.profile_image);
        NavigationDrawer nd = new NavigationDrawer(this, drawer_layout, spleez, obm, photo).navigationDrawerInitialize();

        ImageButton Valider = (ImageButton)findViewById(R.id.valider);
        ImageButton Annuler = (ImageButton)findViewById(R.id.annuler);



        Valider.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {

                Intent openCreerParticiper = new Intent(getApplicationContext(), CreerParticiper_Activity.class);
                startActivity(openCreerParticiper);
            }
        });

        Annuler.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {

                Intent openCreer = new Intent(getApplicationContext(), Creer_Activity_.class);
                startActivity(openCreer);
            }
        });
    }
}
