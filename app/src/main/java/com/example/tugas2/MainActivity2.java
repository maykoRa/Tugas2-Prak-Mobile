package com.example.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText title;
    private EditText content;
    private Button savenote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.input_title);
        content = findViewById(R.id.input_content);
        savenote = findViewById(R.id.save_note);

        String getprofile = getIntent().getStringExtra("profile");
        String getname = getIntent().getStringExtra("name");
        String getusername = getIntent().getStringExtra("username");

        savenote.setOnClickListener(view -> {
            if (title.getText().toString().trim().isEmpty()) {
                title.setError("Field ini tidak boleh kosong");
                return;
            } if (content.getText().toString().trim().isEmpty()) {
                content.setError("Field ini tidak boleh kosong");
                return;
            } else {
                String titleText = title.getText().toString();
                String contentText = content.getText().toString();

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("profile", getprofile);
                intent.putExtra("name", getname);
                intent.putExtra("username", getusername);
                intent.putExtra("title", titleText);
                intent.putExtra("content", contentText);
                startActivity(intent);
            }

        });

    }
}