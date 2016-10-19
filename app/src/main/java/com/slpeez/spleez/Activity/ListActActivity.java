package com.slpeez.spleez.Activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.slpeez.spleez.Adapter.ActivityAdapter;
import com.slpeez.spleez.Librairy.JSONHandler;
import com.slpeez.spleez.Object.Event;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by thibaut on 05/04/2016.
 */
public class ListActActivity extends Activity {

    protected ArrayList<Event> _list_activities;
    protected ListView _l_activities;
    protected ActivityAdapter _aa;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivities);



        _list_activities = new ArrayList<>();
        _aa = new ActivityAdapter(ListActActivity.this, _list_activities);
        _l_activities = (ListView)findViewById(R.id.list_activities);
        _l_activities.setAdapter(_aa);

        DownloadList downloader = new DownloadList();
        downloader.execute();

    }
    private class DownloadList extends AsyncTask<Void, Integer, ArrayList<Event>> {
        protected JSONHandler _jh;
        @Override
        protected ArrayList<Event> doInBackground(Void... arg0) {
            try {
                _jh = new JSONHandler(getApplicationContext());
                return _jh.getListEvent();
            } catch(IOException ioe) {
            }
            return null;
        }

        /*
         * (non-Javadoc)
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */
        @Override
        protected void onPostExecute(ArrayList<Event> result) {
            if(result.size() > 0)
                _aa.swapEvent(result);
        }

    }



}
