package com.example.tugas2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private ImageView profile;
    private TextView name;
    private TextView username;
    private TextView title;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        String getprofile = getIntent().getStringExtra("profile");
        String getname = getIntent().getStringExtra("name");
        String getusername = getIntent().getStringExtra("username");
        String gettitle = getIntent().getStringExtra("title");
        String getcontent = getIntent().getStringExtra("content");

        profile = findViewById(R.id.profileimage);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        title = findViewById(R.id.title);
        content = findViewById(R.id.contents);

        profile.setImageURI(Uri.parse(getprofile));
        name.setText(getname);
        username.setText(getusername);
        title.setText(gettitle);
        content.setText(getcontent);


    }
}