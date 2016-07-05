package com.slpeez.spleez;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Profil_Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                // Comportement du bouton "A Propos"
                return true;
            case R.id.menu_help:
                // Comportement du bouton "Aide"
                return true;
            case R.id.menu_refresh:
                // Comportement du bouton "Rafraichir"
                return true;
            case R.id.menu_search:
                // Comportement du bouton "Recherche"
                return true;
            case R.id.menu_settings:
                // Comportement du bouton "Param�tres"
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}