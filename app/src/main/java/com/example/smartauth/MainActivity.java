
package com.example.smartauth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtWelcome;
    Button btnOpenProfile, btnDashboardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWelcome = findViewById(R.id.txtWelcome);
        btnOpenProfile = findViewById(R.id.btnOpenProfile);
        btnDashboardLogout = findViewById(R.id.btnDashboardLogout);

        String email = getIntent().getStringExtra("userEmail");

        if (email != null && !email.isEmpty()) {
            txtWelcome.setText("Welcome, " + email + "!");
        }

        btnOpenProfile.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this, ProfileActivity.class);
            intent.putExtra("userEmail", email);
            startActivity(intent);
        });

        btnDashboardLogout.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this, LoginActivity.class);
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
