package com.example.chikara.vollynetworkcommunication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by chikara on 1/5/18.
 */

public class VolleyStringRequest extends StringRequest {

    public VolleyStringRequest(String url, Response.Listener<String> listener,
                               Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }
}
