package com.slpeez.spleez;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.slpeez.spleez.Librairy.JSONHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    protected JSONHandler _jh;

    protected EditText _log,_pass;
    protected String _login, _password;

    // temporaire
    int id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton b = (ImageButton)findViewById(R.id.BoutonConnexion);
        ImageButton SignInButton = (ImageButton)findViewById(R.id.button);


        /* this is for the login and password */
        _log = (EditText)findViewById(R.id.login);
        _pass= (EditText)findViewById(R.id.password);

        _jh  = new JSONHandler(getApplicationContext());

        // temporaire
        int id_user;

         SignInButton.setOnClickListener(new View.OnClickListener()

         {
             //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
             public void onClick (View v){
             Intent openCreer = new Intent(getApplicationContext(), Inscription_Activity.class);
             startActivity(openCreer);
         }
         }

         );


                b.setOnClickListener(new View.OnClickListener() {
                    //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent i = new Intent(getApplicationContext(), CreerParticiper_Activity.class);
                        //startActivity(i);


                        _login = _log.getText().toString();
                        _password = _pass.getText().toString();
                        ArrayList<String> key = new ArrayList<String>();
                        key.add(_login);
                        key.add(_password);
                        DoAuthentification authenticateUser = new DoAuthentification();
                        authenticateUser.execute(key);

                    }
                });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private class DoAuthentification extends AsyncTask<ArrayList<String>, Integer, Void> {

        JSONObject userIsValid = null;

        protected Void doInBackground(ArrayList<String>... key) {

            try {
                userIsValid = _jh.isUserValid(key[0].get(0), key[0].get(1));
            } catch (IOException ioe) {
            }
            return null;
        }

        protected void onPostExecute(Void result) {

            if (userIsValid != null) {
                try {
                    if (userIsValid.getBoolean("valid")) {

                        id_user = userIsValid.getInt("id");
                        Intent i = new Intent(MainActivity.this, CreerParticiper_Activity.class);
                        //i.putExtra("iduser", id_user);
                        startActivity(i);
                    } else {
                        CharSequence text = "Utilisateur invalide";
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException je) {

                }
            } else {
                CharSequence text = "Pb réseau";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
