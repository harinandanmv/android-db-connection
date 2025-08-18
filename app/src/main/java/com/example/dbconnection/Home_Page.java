package com.example.dbconnection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity {

    private SQLiteDatabase sql;

    TextView textView;
    Button btn1;
    EditText editText;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);
        editText = findViewById(R.id.editText3);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button4);

        sql = openOrCreateDatabase("studentdb", MODE_PRIVATE, null);

        sql.execSQL("CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password TEXT)");

        refresh();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                Cursor cursor = sql.rawQuery("SELECT * FROM student WHERE name = '" + name + "'", null);

                if (cursor.getCount() > 0) {
                    cursor.close();
                    String query = "DELETE FROM student WHERE name = '" + name + "'";
                    sql.execSQL(query);
                    Toast.makeText(Home_Page.this, "DELETED!!!", Toast.LENGTH_SHORT).show();
                    refresh();
                } else {
                    cursor.close();
                    Toast.makeText(Home_Page.this, "DOESN'T EXIST!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, Update_Page.class);
                startActivity(intent);
            }
        });

    }
    @SuppressLint("SetTextI18n")
    public void refresh(){
        StringBuilder result = new StringBuilder();

        Cursor cursor = sql.rawQuery("SELECT * FROM student", null);

        if (cursor.getCount() == 0) {
            textView.setText("EMPTY RECORD");
            return;
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = cursor.getString(2);

            result.append("ID: ").append(id).append("\n")
                    .append("Name: ").append(name).append("\n")
                    .append("Password: ").append(password).append("\n");
        }

        cursor.close();

        textView.setText(result.toString());
    }
}
