package com.example.mysqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, ageEditText, genderEditText;
    private Button addButton;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            myDatabaseHelper = new MyDatabaseHelper(this);
            SQLiteDatabase sqLiteOpenHelper = myDatabaseHelper.getWritableDatabase();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Exception :" + e, Toast.LENGTH_SHORT).show();
            Log.v("err", e.toString());
        }

        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditText = findViewById(R.id.ageEditTextId);
        genderEditText = findViewById(R.id.genderEditTextId);
        addButton = findViewById(R.id.addButtonID);

        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();


        if (v.getId() == R.id.addButtonID) {
           long rowId = myDatabaseHelper.insertData(name, age, gender);
        if(rowId >0){
            Toast.makeText(MainActivity.this,"Row "+rowId+" successfully insert",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"notR successfully insert",Toast.LENGTH_SHORT).show();

        }
        }


    }
}