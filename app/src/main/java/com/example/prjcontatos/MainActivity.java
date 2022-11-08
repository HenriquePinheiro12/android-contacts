package com.example.prjcontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button registerBtn, getContactBtn;
    EditText nameInput, phoneInput, dateInput;
    ListView listView;

    ArrayList<HashMap<String, String>> contactList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerBtn = findViewById(R.id.registerBtn);
        getContactBtn = findViewById(R.id.getContactBtn);
        nameInput = findViewById(R.id.nameInput);
        dateInput = findViewById(R.id.dateInput);
        phoneInput = findViewById(R.id.phoneInput);

        listView = findViewById(R.id.listView);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String phone = phoneInput.getText().toString();
                String birthday = dateInput.getText().toString();

                HashMap<String, String> contact = new HashMap<>();
                contact.put("name", name);
                contact.put("phone", phone);
                contact.put("birthday", birthday);
                contactList.add(contact);
            }
        });

        getContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // aniversários no próximo mês apenas

                int layout = android.R.layout.simple_list_item_2;
                String[] from = new String[] { "name", "phone" };
                int[] to = new int[] { android.R.id.text1,  android.R.id.text2 };

                SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), contactList, layout, from, to);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        // mostrar nome, data do próximo aniversário, nova idade, dias restantes
                        Toast.makeText(getBaseContext(), contactList.get(i).get("birthday"), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}