package com.example.raneem_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
    public void deletePerson(View view){
        EditText query=(EditText)findViewById(R.id.editTextTextPersonName);
        DBHelper dbHelper=new DBHelper(this);
        if(query.getText().toString().isEmpty()){
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }
        dbHelper.deletePerson(query.getText().toString());
    }
    public void openActivity2(View view){
        Intent intent=new Intent(this,Activity2.class);
        startActivity(intent);
    }
}