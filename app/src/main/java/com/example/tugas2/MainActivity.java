package com.example.tugas2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText name;
    private EditText username;
    private Button submitdata;
    private boolean isImageChanged = false;
    private Uri image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.addimage);
        name = findViewById(R.id.input_name);
        username = findViewById(R.id.input_username);
        submitdata = findViewById(R.id.submit_data);

        imageView.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        submitdata.setOnClickListener(view -> {
            if (!isImageChanged) {
                Toast.makeText(this, "Please pick a profile image first!", Toast.LENGTH_SHORT).show();
                return;
            } if (name.getText().toString().trim().isEmpty()) {
                name.setError("Field ini tidak boleh kosong");
                return;
            } if (username.getText().toString().trim().isEmpty()) {
                username.setError("Field ini tidak boleh kosong");
                return;
            } else {
                String nameText = name.getText().toString();
                String usernameText = username.getText().toString();
                String profile = image.toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", nameText);
                intent.putExtra("username", usernameText);
                intent.putExtra("profile", profile);
                startActivity(intent);
            }
        });



    } ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    image = data.getData();
                    imageView.setImageURI(image);
                    isImageChanged = true;
                }
            }
    );
}