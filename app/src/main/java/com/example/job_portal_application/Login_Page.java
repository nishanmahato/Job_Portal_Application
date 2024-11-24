package com.example.job_portal_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button login;
    EditText email, password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        firebaseAuth=FirebaseAuth.getInstance();
        login=findViewById(R.id.btn_login);
        email=findViewById(R.id.txt_Email);
        password=findViewById(R.id.txt_password);
        register=findViewById(R.id.txt_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Registration_Page.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();

                if (Email.isEmpty()){
                    Toast.makeText(Login_Page.this,"Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if (Password.isEmpty()){
                    Toast.makeText(Login_Page.this,"Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Login_Page.this, "Login Complete", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Home_Page.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(Login_Page.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}