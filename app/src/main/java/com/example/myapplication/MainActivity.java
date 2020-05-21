package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.liferay.mobile.android.auth.basic.BasicAuthentication;
import com.liferay.mobile.android.service.Session;
import com.liferay.mobile.android.service.SessionImpl;
import com.liferay.mobile.screens.auth.login.LoginListener;
import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.context.User;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements LoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginScreenlet loginScreenlet=findViewById(R.id.login);
        loginScreenlet.setListener(this);


    }

    @Override
    public void onLoginSuccess(User user) {
        RequestQueue requestQueue= Volley.newRequestQueue(this);

        startActivity(new Intent(MainActivity.this,ActivityOne.class));
    }

    @Override
    public void onLoginFailure(Exception e) {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onAuthenticationBrowserShown() {

    }
}
