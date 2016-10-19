package com.slpeez.spleez.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.slpeez.spleez.Activity.ChoiceActivity;
import com.slpeez.spleez.Activity.Creer_Activity_;
import com.slpeez.spleez.Librairy.JSONHandler;
import com.slpeez.spleez.Menu.NavigationDrawer;
import com.slpeez.spleez.Activity.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Creation_Activity extends AppCompatActivity {

    protected JSONHandler _jh;

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

        _jh  = new JSONHandler(getApplicationContext());

        Valider.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {

                DoCreateActivity createActivityProcess = new DoCreateActivity();
                createActivityProcess.execute(new ArrayList<String>());
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

    private class DoCreateActivity extends AsyncTask<ArrayList<String>, Integer, Void> {

        JSONObject userIsValid = null;

        protected Void doInBackground(ArrayList<String>... key) {


            _jh.createNewActivity();
            return null;
        }

        protected void onPostExecute(Void result) {

            Intent i = new Intent(Creation_Activity.this, ChoiceActivity.class);
            startActivity(i);


        }
    }
}
