package com.slpeez.spleez.Creation_activity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slpeez.spleez.CreerParticiper_Activity;
import com.slpeez.spleez.Creer_Activity_;
import com.slpeez.spleez.Librairy.JSONHandler;
import com.slpeez.spleez.R;

public class Creation_Activity_Voyage extends FragmentActivity implements OnMapReadyCallback {

    private MapView mapView = null;
    private LocationManager lm = null;
    private double lat = 0;
    private double lng = 0;
    //private MapController mc = null;

    private GoogleApiClient client;
    protected JSONHandler _jh;

    private GoogleMap mMap;

    protected String _login, _password;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_activity_voyage);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //mapView.setBuiltInZoomControls(true);

        /*lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, (LocationListener) this);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, (LocationListener) this);*/

        //mc = mapView.getController();
        //mc.setZoom(12);

        _jh = new JSONHandler(getApplicationContext());
        //ImageButton Profil = (ImageButton)findViewById(R.id.buttonprofil);
        ImageButton Valider = (ImageButton) findViewById(R.id.valider);
        ImageButton Annuler = (ImageButton) findViewById(R.id.annuler);



        /*Profil.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {

                Intent openProfil = new Intent(getApplicationContext(), Profil_Activity.class);
                startActivity(openProfil);
            }
        });*/

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


        EditText ActivityName = (EditText) findViewById(R.id.activityname);
        final EditText Ou = (EditText) findViewById(R.id.editText2);
        EditText Quand = (EditText) findViewById(R.id.editText3);
        EditText Commentaire = (EditText) findViewById(R.id.editText6);
        EditText Nombre = (EditText) findViewById(R.id.editText5);
        EditText heure = (EditText) findViewById(R.id.editText4);
        /*Ou.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        actionId == EditorInfo.IME_ACTION_GO ||
                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    // hide virtual keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(Ou.getWindowToken(), 0);

                    //new SearchClicked(Ou.getText().toString()).execute();
                    Ou.setText("", TextView.BufferType.EDITABLE);
                    return true;
                }
                return false;
            }
        });*/

        /*Address address = (Address) gotAddresses.get(0);

        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());

        String properAddress = String.format("%s, %s",
                address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                address.getCountryName());

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(address.getLatitude(), address.getLongitude())).draggable(true)
                .title(properAddress));
        /*Ou.setOnClickListener(new View.OnClickListener() {
            //b.setOnClickListener(View.OnClickListener t)  = new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent();

                //Froyo or greater (mind you I just tested this on CM7 and the less than froyo one worked so it depends on the phone...)
                //ComponentName cn = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");

                //less than Froyo
                ComponentName cn = new ComponentName("com.android.calendar", "com.android.calendar.LaunchActivity");

                i.setComponent(cn);
                startActivity(i);
            }
        });
    }
    private MyLocationOverlay myLocation = null;

        protected void MyLocation(){

        myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
            mapView.getOverlays().add(myLocation);
            myLocation.enableMyLocation();
            myLocation.disableMyLocation();

*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        MarkerOptions mp = new MarkerOptions();

        Location object = new Location("service Provider");
        double lat = object.getLatitude();
        double lng = object.getLongitude();


    }


   /* @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Creation_Activity_Voyage Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.slpeez.spleez.Creation_activity/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Creation_Activity_Voyage Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.slpeez.spleez.Creation_activity/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }*/
}

