package com.example.raneem_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView humidityText;
    TextView tempText;
    String url="https://api.openweathermap.org/data/2.5/weather?q=London&appid=a57eb3160c6b2374e3ea81c66c9f3b0a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        humidityText=(TextView)findViewById(R.id.humidity_text);
        tempText=(TextView)findViewById(R.id.temp_text);
        getTemp();
    }
    void getTemp(){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Raneem","Successfully  retrieved temperature and humidity");
                Log.d("Raneem",response.toString());
                try {
                    JSONObject jsonObject = response.getJSONObject("main");
                    double temp = jsonObject.getDouble("temp");
                    double humidity = jsonObject.getDouble("humidity");
                    humidityText.setText("London Humidity : "+humidity);
                    tempText.setText("London Temperature : "+temp);

                }catch(Exception e){
                    Log.d("Raneem","Error retrieving temperature and humidity");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Raneem","Error retrieving temperature and humidity response");
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);


    }
    public void setDate(View view){
        TextView showDate=(TextView)findViewById(R.id.show_date);
        Calendar c=Calendar.getInstance();
        DateFormat dateFormat=DateFormat.getDateInstance();
        DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                c.set(Calendar.YEAR,year);
                c.set(Calendar.MONTH,month);
                c.set(Calendar.DAY_OF_MONTH,day);
                showDate.setText("Selected : "+dateFormat.format(c.getTime()));
            }
        };
        new DatePickerDialog(MainActivity.this,d,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void openActivity2(View view){
        Intent intent=new Intent(this,Activity2.class);
        startActivity(intent);
    }
}