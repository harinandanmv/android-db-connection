package com.example.dbconnection;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Update_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);

        Button btn2 = findViewById(R.id.button3);
        EditText editText = findViewById(R.id.editTextText);
        EditText editText1 = findViewById(R.id.editTextText2);
        EditText editText2 = findViewById(R.id.editTextText3);

        SQLiteDatabase sql = openOrCreateDatabase("studentdb", MODE_PRIVATE, null);

        sql.execSQL("CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pw TEXT)");

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().isEmpty() ||
                        editText1.getText().toString().isEmpty() ||
                        editText2.getText().toString().isEmpty()) {
                    Toast.makeText(Update_Page.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int id;
                try {
                    id = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(Update_Page.this, "Invalid ID format", Toast.LENGTH_SHORT).show();
                    return;
                }

                String name = editText1.getText().toString();
                String pw = editText2.getText().toString();

                String query = "UPDATE student SET name='" + name + "', pw='" + pw + "' WHERE id = " + id;
                sql.execSQL(query);

                Toast.makeText(Update_Page.this, "UPDATED!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
