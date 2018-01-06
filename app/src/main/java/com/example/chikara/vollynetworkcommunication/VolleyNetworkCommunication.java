package com.example.chikara.vollynetworkcommunication;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by chikara on 1/5/18.
 */

public class VolleyNetworkCommunication extends Application {

    private static VolleyNetworkCommunication appInstance = null;
    private RequestQueue requestQueue = null;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public synchronized static VolleyNetworkCommunication getIntance() {
        if (appInstance == null) {
            appInstance = new VolleyNetworkCommunication();
            return appInstance;
        } else {
            return appInstance;
        }
    }

    public synchronized RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue
                    (context, new VolleyOkHttpStack(new OkHttpClient()));
            return requestQueue;
        } else {
            return requestQueue;
        }
    }

}
