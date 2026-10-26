
package com.example.smartauth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText edtForgotEmail;
    Button btnSendRecovery, btnForgotBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtForgotEmail = findViewById(R.id.edtForgotEmail);
        btnSendRecovery = findViewById(R.id.btnSendRecovery);
        btnForgotBack = findViewById(R.id.btnForgotBack);

        btnSendRecovery.setOnClickListener(v -> {
            String email = edtForgotEmail.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtForgotEmail.setError("Enter a valid email address");
                edtForgotEmail.requestFocus();
                return;
            }

            Toast.makeText(this,
                    "Password recovery initiated for " + email,
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(
                    ForgotPasswordActivity.this,
                    ResetPasswordActivity.class);

            intent.putExtra("recoveryEmail", email);
            startActivity(intent);
        });

        btnForgotBack.setOnClickListener(v -> finish());
    }
}


