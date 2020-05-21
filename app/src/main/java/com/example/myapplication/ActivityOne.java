package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.liferay.mobile.android.auth.basic.BasicAuthentication;
import com.liferay.mobile.android.service.Session;
import com.liferay.mobile.android.service.SessionImpl;
import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.liferay.mobile.screens.context.SessionContext;
import com.liferay.mobile.screens.context.storage.CredentialsStorageBuilder;

import org.json.JSONArray;


public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        LiferayScreensContext.init(this);
        SessionContext.loadStoredCredentials(CredentialsStorageBuilder.StorageType.SHARED_PREFERENCES);
        Session session = new SessionImpl("http://teccovina.vnitt.ac.vn/api/jsonws/dms-portlet.documentincoming/get-list-my-document-in-coming/user-id/1146",
                new BasicAuthentication("leminhtai@baclieu.gov.vn", "123456"));
        long userId=SessionContext.getCurrentUser().getId();

        // get value user Toast.makeText(this, SessionContext.getCurrentUser().getId()+"", Toast.LENGTH_SHORT).show();
      if(SessionContext.isLoggedIn()){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
            //String url= "https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json";
           String url="http://teccovina.vnitt.ac.vn/api/jsonws/dms-portlet.documentincoming/get-list-my-document-in-coming/user-id/"+userId;
           JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null,
                   new Response.Listener<JSONArray>() {
                       @Override
                        public void onResponse(JSONArray response) {
                            Toast.makeText(ActivityOne.this, response.toString(), Toast.LENGTH_SHORT).show();

                       }
                   }
                   , new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   Toast.makeText(ActivityOne.this, "Erroro", Toast.LENGTH_SHORT).show();
                }
           });
           requestQueue.add(jsonArrayRequest);
    }
    }


}
