package com.example.firebaseassigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddContactActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText editTextName ;
    EditText editTextNumber ;
    EditText editTextAddress ;
    Button buttonSave ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        editTextName =findViewById(R.id.phonName);
        editTextNumber =findViewById(R.id.phonNamber);
        editTextAddress =findViewById(R.id.phonAddres);
        buttonSave = findViewById(R.id.btn_save_contact);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();
            }
        });
    }
    public void SaveData() {
        String name = editTextName.getText().toString();
        String number = editTextNumber.getText().toString();
        String address = editTextAddress.getText().toString();

        Map<String , Object> contact = new HashMap<>();
        contact.put("name" , name);
        contact.put("number" , number);
        contact.put("address" , address);
        db.collection("contact").add(contact).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.e("hind" , "Add Contact Success " + documentReference.getId());
                Toast.makeText(getApplicationContext() ,"Add Contact Success" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("hind" , "Add Contact Failure " );

            }
        });
    }
}