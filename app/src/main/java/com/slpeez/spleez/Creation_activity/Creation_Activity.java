package com.slpeez.spleez.Creation_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.slpeez.spleez.CreerParticiper_Activity;
import com.slpeez.spleez.Creer_Activity_;
import com.slpeez.spleez.R;

public class Creation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_activity);

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
