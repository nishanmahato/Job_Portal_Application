package com.example.job_portal_application;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Employer_Page extends AppCompatActivity {

    public EditText editname,editcname, editphone, editcity,editcountry, editvacancy;
    public DatePickerDialog.OnDateSetListener mDateSetListener;
    public FirebaseFirestore db= FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employer_page);
        editname=findViewById(R.id.txt_employername);
        editcname=findViewById(R.id.txt_companyname);
        editphone=findViewById(R.id.txt_phonenumber2);
        editcountry=findViewById(R.id.txt_countryname2);
        editcity=findViewById(R.id.txt_cityname2);
        editvacancy=findViewById(R.id.txt_vacantposition);
        Button enter=findViewById(R.id.btn_enterdetails2);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ename=editname.getText().toString();
                String cname=editname.getText().toString();
                String phonenumber2=editphone.getText().toString();
                String country2=editcountry.getText().toString();
                String city2=editcity.getText().toString();
                String vacancy=editvacancy.getText().toString();
                Map<String,Object> map=new HashMap<>();
                map.put("Employer Name", ename);
                map.put("Company Name", cname);
                map.put("Phone Number", phonenumber2);
                map.put("Country", country2);
                map.put("City", city2);
                map.put("Vacancy",vacancy);

                db.collection("Employers").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Employer_Page.this, "Data has been stored successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Employer_Page.this, "Error! "+e, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}