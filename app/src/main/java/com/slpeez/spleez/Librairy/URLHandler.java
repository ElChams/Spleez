package com.slpeez.spleez.Librairy;

import android.content.Context;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * This class handles all the request from the app to the server.
 * @author dell
 *
 */
public class URLHandler {

    private Context _context;
    private OkHttpClient _client;


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public URLHandler(Context c) {
        _context = c;
        _client = new OkHttpClient();
    }

    public String makeRequestWithParams(String url, String json) throws IOException {
        RequestBody body =  RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = _client.newCall(request).execute();
        return response.body().string();
    }

    public String makeRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = _client.newCall(request).execute();
        return response.body().string();
    }

}
