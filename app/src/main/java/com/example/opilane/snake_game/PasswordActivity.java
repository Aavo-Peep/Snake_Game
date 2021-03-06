package com.example.opilane.snake_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {

    EditText salasõnaEmail;
    Button lähtestaParool;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        salasõnaEmail = findViewById(R.id.email);
        lähtestaParool = findViewById(R.id.lähtesta);
        firebaseAuth = FirebaseAuth.getInstance();

        lähtestaParool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kasutajaEmail =salasõnaEmail.getText().toString().trim();
                if (kasutajaEmail.equals("")) {
                    teade("Palun sisestage oma eposti aadress!");
                } else {
                    firebaseAuth.sendPasswordResetEmail(kasutajaEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                finish();
                                startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
                            }
                            else {
                                teade("Emaili saatmine ebaõnnestus!");
                            }
                        }
                    });

            }
        }});}


        public void teade(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}