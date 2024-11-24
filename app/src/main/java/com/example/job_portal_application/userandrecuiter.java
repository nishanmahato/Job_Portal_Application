package com.example.job_portal_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class userandrecuiter extends AppCompatActivity {
    CardView userlogin, recruiterlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_userandrecuiter);
        userlogin=findViewById(R.id.userlogin);
        recruiterlogin=findViewById(R.id.recruiterlogin);

        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(getApplicationContext(), Login_Page.class);
                startActivity(signin);
            }
        });
        recruiterlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(getApplicationContext(), Login_Page.class);
                startActivity(signin);
            }
        });

    }
}