package com.example.prjcontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button registerBtn, getContactBtn;
    EditText nameInput, phoneInput;
    ListView listView;
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
        listView = findViewById(R.id.listView);

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
                listView.removeAllViews();
                for (int i = 0; i<contactList.size(); i++){
                    TextView t = new TextView(getBaseContext());
                    Contact c = contactList.get(i);
                    t.setText(c.getName()+ ": "+c.getPhone());

                    listView.addView(t);
                }
            }
        });
    }
}