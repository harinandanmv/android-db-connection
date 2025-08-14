package com.example.dbconnection;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Update_Page extends AppCompatActivity {
    SQLiteDatabase db;
    private EditText edit4;
    private EditText edit5;
    private EditText edit6;
    private Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        edit4=findViewById(R.id.editTextText);
        edit5=findViewById(R.id.editTextText2);
        edit6=findViewById(R.id.editTextText3);
        btn5=findViewById(R.id.button3);
        db =openOrCreateDatabase("studentdb", MODE_PRIVATE, null);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edit4.getText().toString();
                String username = edit5.getText().toString();
                String password = edit6.getText().toString();

                if (!id.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
                    String query = "UPDATE student SET name = '" + username + "', password = '" + password + "' WHERE id = " + id;
                    db.execSQL(query);
                }
                Toast.makeText(Update_Page.this, "UPDATED!!!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Update_Page.this, Home_Page.class);
                startActivity(intent);

            }
        });
    }
}