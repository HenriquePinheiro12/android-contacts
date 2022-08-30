package com.example.prjcontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button registerBtn, getContactBtn;
    EditText nameInput, phoneInput;
    ArrayList<Contact> contactList = new ArrayList<Contact>();
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerBtn = findViewById(R.id.registerBtn);
        getContactBtn = findViewById(R.id.getContactBtn);
        nameInput = findViewById(R.id.nameInput);
        phoneInput = findViewById(R.id.phoneInput);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String phone = phoneInput.getText().toString();

                Contact c = new Contact(name, phone);
                contactList.add(c);
            }
        });

        getContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact current = contactList.get(counter);
                Toast.makeText(getBaseContext(),  current.getName()+ ": " +current.getPhone(), Toast.LENGTH_LONG).show();
                if(counter + 1 < contactList.size()) counter++;
            }
        });
    }
}