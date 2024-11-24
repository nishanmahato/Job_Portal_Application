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

public class Registration_Page extends AppCompatActivity {
EditText email, password, cpassword;
Button register;
TextView login;
FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_page);

        firebaseAuth= FirebaseAuth.getInstance();
        email=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        cpassword=findViewById(R.id.txt_Cpassword);
        register=findViewById(R.id.btn_register);
        login=findViewById(R.id.txt_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_Page.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String CPassword=cpassword.getText().toString().trim();
                if (Email.isEmpty()){
                    Toast.makeText(Registration_Page.this, "PLease Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()){
                    Toast.makeText(Registration_Page.this, "PLease Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (Password.length()<6){
                    Toast.makeText(Registration_Page.this, "Password too Short", Toast.LENGTH_SHORT).show();
                }
                if (CPassword.equals(Password)){
                    firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Registration_Page.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), Login_Page.class);  
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(Registration_Page.this, "Registration Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }
}