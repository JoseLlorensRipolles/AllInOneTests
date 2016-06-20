package com.example.josemanuel.centralicedtests.adressBook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.josemanuel.centralicedtests.R;
import com.example.josemanuel.centralicedtests.adressBook.model.AdapterContacts;
import com.example.josemanuel.centralicedtests.adressBook.model.Contact;
import com.example.josemanuel.centralicedtests.adressBook.model.DividerItemDecoration;

import java.util.ArrayList;

public class AdressBook extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Contact> contacts;
    Button buttonAdd;
    EditText editTextName;
    EditText editTextPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_book);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);

        Contact test1 = new Contact("Jose",123456789);
        Contact test2 = new Contact("Pepe",987654321);

        contacts = new ArrayList<>();
        contacts.add(test1);
        contacts.add(test2);


        final AdapterContacts adapterContacts = new AdapterContacts(contacts);

        adapterContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts.remove(recyclerView.getChildPosition(v));
                adapterContacts.notifyDataSetChanged();
                //Log.i("DemoRecView","pulsado el elemento"+recyclerView.getChildPosition(v));
            }
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        recyclerView.setAdapter(adapterContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int phone = Integer.parseInt(editTextPhone.getText().toString());

                Contact newContact = new Contact(name,phone);
                contacts.add(newContact);

                adapterContacts.notifyItemInserted(contacts.size()-1);
            }
        });


    }



}
