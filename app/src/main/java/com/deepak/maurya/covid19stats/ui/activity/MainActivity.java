package com.deepak.maurya.covid19stats.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.deepak.maurya.covid19stats.R;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


TextView textView;
CardView c;
Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView simpleImageView = (ImageView) findViewById(R.id.simpleImageView);
        textView = (TextView) findViewById(R.id.cases);
        btn = (Button) findViewById(R.id.btn);

        c = (CardView) findViewById(R.id.cv);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startAct2();

            }
        });

        fetchdata();


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAct();
            }
        });

    }

            private void fetchdata() {

                String url = "https://corona.lmao.ninja/v2/all";

                StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response.toString());

                            textView.setText(
                                    jsonObject.getString(
                                            "cases"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                        new com.android.volley.Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(
                                        MainActivity.this,
                                        error.getMessage(),
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }

                        });

                RequestQueue requestQueue
                        = Volley.newRequestQueue(this);
                requestQueue.add(request);
            }
            public void startAct()
            {
                Intent intent= new Intent(this,WorldWide.class);
                startActivity(intent);
            }
             public void startAct2()
             {
               Intent intent= new Intent(this,CountryWise.class);
                startActivity(intent);
    }




            }