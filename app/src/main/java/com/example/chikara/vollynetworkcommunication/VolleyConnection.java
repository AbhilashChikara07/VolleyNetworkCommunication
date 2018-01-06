package com.example.chikara.vollynetworkcommunication;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by chikara on 1/5/18.
 */

public class VolleyConnection {

    private Context context;
    private String actionId;
    private VolleyResultListener listener;
    private final int TIMEOUT = 60000;

    public VolleyConnection(Context context,String actionId, final VolleyResultListener listener) {
        this.context = context;
        this.actionId = actionId;
        this.listener = listener;

        StringRequest request = new VolleyStringRequest(getActionUrl(actionId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(
                TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        addToRequestQueue(request);
    }

    private void addToRequestQueue(StringRequest req) {
        VolleyNetworkCommunication.getIntance().getRequestQueue().add(req);
    }

    private String getActionUrl(String actionId) {
        String BASE_URL = context.getString(R.string.base_url);
//        return BASE_URL + actionId;
        return "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
    }

    interface VolleyResultListener {
        void onSuccess(String response);

        void onError(String errorMessage);
    }

}
