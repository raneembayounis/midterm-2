package com.example.raneem_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText id,name,surname,nid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    public void insertPerson(View view){
        id=(EditText)findViewById(R.id.p_id);
        name=(EditText)findViewById(R.id.p_name);
        surname=(EditText)findViewById(R.id.p_sname);
        nid=(EditText)findViewById(R.id.p_nid);
        DBHelper dbHelper=new DBHelper(this);
        String idText=id.getText().toString();
        String nameText=name.getText().toString();
        String surnameText=surname.getText().toString();
        String nidText=nid.getText().toString();
        if(idText.isEmpty()||nameText.isEmpty()||surnameText.isEmpty()||nidText.isEmpty()){
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }
        dbHelper.insertPerson(idText,nameText,surnameText,nidText);
    }
    public void openActivity1(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openActivity3(View view){
        Intent intent=new Intent(this,Activity3.class);
        startActivity(intent);
    }
}