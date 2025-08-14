package com.example.dbconnection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import android.database.sqlite.SQLiteDatabase;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editText1=(EditText) findViewById(R.id.editText1);
        EditText editText2=(EditText) findViewById(R.id.editText2);
        Button btn =findViewById(R.id.button);
        SQLiteDatabase sql = openOrCreateDatabase("studentdb",MODE_PRIVATE,null);
        sql.execSQL("CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password TEXT)");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();
                String query = "INSERT INTO student(name,password) VALUES ('"+username+"','"+password+"')";
                sql.execSQL(query);
                Toast.makeText(MainActivity.this,"SUCCESS!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Home_Page.class);
                startActivity(intent);
                finish();
            }
        });

    }
}