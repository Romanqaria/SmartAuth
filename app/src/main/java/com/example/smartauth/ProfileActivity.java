
package com.example.smartauth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView txtProfileName, txtProfileEmail;
    Button btnProfileLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtProfileName = findViewById(R.id.txtProfileName);
        txtProfileEmail = findViewById(R.id.txtProfileEmail);
        btnProfileLogout = findViewById(R.id.btnProfileLogout);

        String email = getIntent().getStringExtra("userEmail");

        txtProfileName.setText("Name: SmartAuth User");
        txtProfileEmail.setText(
                "Email: " + (email == null ? "Not available" : email));

        btnProfileLogout.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ProfileActivity.this, LoginActivity.class);
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
