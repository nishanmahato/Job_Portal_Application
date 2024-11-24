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

public class Employee_Page extends AppCompatActivity {

    public EditText editname,editphone, editcity,editcountry;
    public DatePickerDialog.OnDateSetListener mDateSetListener;
    public FirebaseFirestore db= FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_page);
        editname=findViewById(R.id.txt_name);
        editphone=findViewById(R.id.txt_phonenumber);
        editcountry=findViewById(R.id.txt_countryname);
        editcity=findViewById(R.id.txt_cityname);
        Button enter=findViewById(R.id.btn_enterdetails);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ename=editname.getText().toString();
                String phonenumber=editphone.getText().toString();
                String country=editcountry.getText().toString();
                String city=editcity.getText().toString();
                Map<String,Object>map=new HashMap<>();
                map.put("Employee Name", ename);
                map.put("Phone Number", phonenumber);
                map.put("Country", country);
                map.put("City", city);

                db.collection("Employees").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Employee_Page.this, "Data has been stored successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Employee_Page.this, "Error! "+e, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}