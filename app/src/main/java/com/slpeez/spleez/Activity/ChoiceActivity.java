package com.slpeez.spleez.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.slpeez.spleez.Menu.NavigationDrawer;
import com.slpeez.spleez.Activity.R;

public class ChoiceActivity extends AppCompatActivity {


    private GoogleApiClient client;
    private void GoCreerActivity(){
        Intent openCreer = new Intent(getApplicationContext(), Creer_Activity_.class);
        startActivity(openCreer);
    }
    private void GoParticiperActivity(){
        Intent openParticper = new Intent(getApplicationContext(), Participer_Activity.class);
        startActivity(openParticper);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_participer);
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);

        ImageButton BoutonCreer = (ImageButton)findViewById(R.id.button3);
        ImageButton BoutonParticper = (ImageButton)findViewById(R.id.button4);
        ImageButton BoutonProfil = (ImageButton)findViewById(R.id.buttonprofil);
        ImageButton BoutonSpleez = (ImageButton)findViewById(R.id.spleez);

        /* Initialisation menu */
        final DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageButton spleez = (ImageButton) findViewById(R.id.spleez);
        final ImageView photo = (ImageView) findViewById(R.id.icon_image);
        final Bitmap obm = BitmapFactory.decodeResource(getResources(), R.drawable.profile_image);
        NavigationDrawer nd = new NavigationDrawer(this, drawer_layout, spleez, obm, photo).navigationDrawerInitialize();



       int[] ImageActivity = {
                R.drawable.hiking,
                R.drawable.girl,
                R.drawable.horses,
                R.drawable.kart,
                R.drawable.movie,
                R.drawable.paintball,
                R.drawable.parachute,
                R.drawable.paramotor,
                R.drawable.ski,
                R.drawable.camera,
                R.drawable.chess,
                R.drawable.prairie,
                R.drawable.concert,
                R.drawable.cooking,
        };
        int n=ImageActivity.length;
        int nbAleatoire = (int) (Math.random() * n );
        int nbAleatoire2 = (int) (Math.random() * n );


        ViewGroup.LayoutParams imageViewParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView img= (ImageView) findViewById(R.id.imageView);
        ImageView img2= (ImageView) findViewById(R.id.imageView3);

        Drawable d = getResources().getDrawable(ImageActivity[nbAleatoire]);
        Drawable d2 = getResources().getDrawable(ImageActivity[nbAleatoire2]);
        img.setBackground(d);
        img2.setBackground(d2);




        ImageButton boutonCreer = (ImageButton)findViewById(R.id.button3);
        ImageButton boutonParticiper = (ImageButton)findViewById(R.id.button4);
        /*ImageButton Amis = (ImageButton)findViewById(R.id.imageButton6);
        ImageButton Activite = (ImageButton)findViewById(R.id.imageButton7);*/



        BoutonCreer.setOnClickListener(new View.OnClickListener() {
                //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
                public void onClick(View v) {
                    Intent  openCreer= new Intent(getApplicationContext(), Creer_Activity_.class);
                    startActivity(openCreer);
                }
            });

        BoutonParticper.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
                public void onClick(View X) {
                    Intent  openParticiper= new Intent(getApplicationContext(), ListActActivity.class);
                    startActivity(openParticiper);
                }
        });

        BoutonProfil.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                Intent openProfil = new Intent(getApplicationContext(), Profil_Activity.class);
                startActivity(openProfil);
            }
        });
        /*BoutonSpleez.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            @Override
            public void onClick(View z) {


                Intent openSpleez = new Intent(getApplicationContext(), MenuScroll_Activity.class);
                startActivity(openSpleez);
            }
        });*/
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

@Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.slpeez.spleez/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);


    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.slpeez.spleez/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
