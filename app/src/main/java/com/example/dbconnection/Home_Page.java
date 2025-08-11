package com.example.dbconnection;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.textView);
        Button btn1 = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText3);
        Button btn2 = findViewById(R.id.button2);

        SQLiteDatabase sql = openOrCreateDatabase("studentdb", MODE_PRIVATE, null);

        sql.execSQL("CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pw TEXT)");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();

                Cursor cursor = sql.rawQuery("SELECT * FROM student", null);

                if (cursor.getCount() == 0) {
                    textView.setText("EMPTY RECORD");
                    return;
                }

                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String pw = cursor.getString(2);

                    result.append("ID: ").append(id).append("\n")
                            .append("Name: ").append(name).append("\n")
                            .append("Password: ").append(pw).append("\n");
                }

                cursor.close();

                textView.setText(result.toString());
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
                } else {
                    cursor.close();
                    Toast.makeText(Home_Page.this, "DOESN'T EXIST!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
