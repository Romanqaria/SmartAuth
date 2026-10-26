
package com.example.smartauth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText edtNewPassword, edtNewConfirmPassword;
    Button btnResetPassword, btnResetBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtNewConfirmPassword = findViewById(R.id.edtNewConfirmPassword);
        btnResetPassword = findViewById(R.id.btnResetPassword);
        btnResetBack = findViewById(R.id.btnResetBack);

        btnResetPassword.setOnClickListener(v -> {
            String password = edtNewPassword.getText().toString();
            String confirmPassword =
                    edtNewConfirmPassword.getText().toString();

            if (password.length() < 6) {
                edtNewPassword.setError(
                        "Password must contain at least 6 characters");
                edtNewPassword.requestFocus();
                return;
            }

            if (!password.equals(confirmPassword)) {
                edtNewConfirmPassword.setError("Passwords do not match");
                edtNewConfirmPassword.requestFocus();
                return;
            }

            Toast.makeText(this,
                    "Password reset simulated successfully",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(
                    ResetPasswordActivity.this,
                    LoginActivity.class);

            startActivity(intent);
            finish();
        });

        btnResetBack.setOnClickListener(v -> finish());
    }
}


