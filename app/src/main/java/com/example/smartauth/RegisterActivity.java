
package com.example.smartauth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtRegEmail, edtRegPassword, edtConfirmPassword;
    Button btnCreateAccount, btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegPassword = findViewById(R.id.edtRegPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnBackToLogin = findViewById(R.id.btnBackToLogin);

        btnCreateAccount.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String email = edtRegEmail.getText().toString().trim();
            String password = edtRegPassword.getText().toString();
            String confirmPassword =
                    edtConfirmPassword.getText().toString();

            if (name.isEmpty()) {
                edtName.setError("Name is required");
                edtName.requestFocus();
                return;
            }

            if (email.isEmpty() ||
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtRegEmail.setError("Enter a valid email address");
                edtRegEmail.requestFocus();
                return;
            }

            if (password.length() < 6) {
                edtRegPassword.setError(
                        "Password must contain at least 6 characters");
                edtRegPassword.requestFocus();
                return;
            }

            if (!password.equals(confirmPassword)) {
                edtConfirmPassword.setError("Passwords do not match");
                edtConfirmPassword.requestFocus();
                return;
            }

            Toast.makeText(this,
                    "Registration successful! Please log in.",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(
                    RegisterActivity.this, LoginActivity.class);
            intent.putExtra("registeredEmail", email);
            startActivity(intent);
            finish();
        });

        btnBackToLogin.setOnClickListener(v -> finish());
    }
}
