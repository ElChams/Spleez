package com.slpeez.spleez.Librairy;

import android.content.Context;

import com.slpeez.spleez.Object.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A class used to handle JSON responses from the server.
 * JSON is standard format used to represent datas.
 * @author thibaut chamoux
 * @version 1.0
 */
public class JSONHandler {

    private static Context _context;

    URLHandler _urlHandler;

    /* Just modify the URL to fit the correct address of the server */
    private static String _loginURL = "http://192.168.0.27:8000/user";
    private static String _getActivities = "http://192.168.0.27:8000/activities";
    private static String _createNewActivity = "http://192.168.0.27:8000/activity/";

    public JSONHandler(Context c) {

        _context = c;
        _urlHandler = new URLHandler(_context);
    }


    public JSONObject isUserValid(String login, String password) throws IOException {

        try {
            String response = _urlHandler.makeRequest(_loginURL + "/" + login + "/" + password);
            return new JSONObject(response);

        } catch(JSONException je) {

        }
        return null;
    }

    public ArrayList<Event> getListEvent() throws IOException {
        ArrayList<Event> result = new ArrayList<>();
        try {
            String response = _urlHandler.makeRequest(_getActivities);
            JSONArray ja = new JSONArray(response);

            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                String name = jo.getString("name");
                String desc = jo.getString("description");
                Event e = new Event();
                e.setDesc(desc);
                e.setName(name);
                result.add(e);
            }

        } catch(JSONException je) {

        }
        return result;
    }

    public boolean createNewActivity() {

        JSONObject activity = new JSONObject();

        try {
            activity.put("name","test").put("description","test").put("date","10/10/2010").put("address_id","1").put("creator_id","1");
            String response = _urlHandler.makeRequestWithParams(_createNewActivity, activity.toString());
            return true;
        } catch(JSONException je) {

        } catch (IOException ioe) {

        }
        return false;
    }

}
