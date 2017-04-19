package com.example.yvtc.my041702;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this); //建立queue
        StringRequest request = new MyUTF8StringRequest("https://udn.com/rssfeed/news/1", new Response.Listener<String>() {  //建立request 內有網址,成功,失敗
            @Override
            public void onResponse(String response) {  //a成功
                Log.d("NEWS",response);
            }
        }, new Response.ErrorListener() {   //b失敗
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NEWS","Error"+error.getMessage());
            }
        });
        queue.add(request);
        queue.start();
    }
}
