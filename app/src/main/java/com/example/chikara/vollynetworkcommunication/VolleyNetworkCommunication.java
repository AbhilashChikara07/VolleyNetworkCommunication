package com.example.chikara.vollynetworkcommunication;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by chikara on 1/5/18.
 */

public class VolleyNetworkCommunication extends Application {

    private static VolleyNetworkCommunication appInstance = null;
    private RequestQueue requestQueue = null;

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
                    (this, new VolleyOkHttpStack(new OkHttpClient()));
            return requestQueue;
        } else {
            return requestQueue;
        }
    }

}
