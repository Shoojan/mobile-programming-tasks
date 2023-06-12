package com.example.gridviewdemo.tasks.contact;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

import java.util.ArrayList;

public class ContactApp extends AppCompatActivity {

    private SQLiteDbHelper db;

    private EditText idEditText, nameEditText, phoneEditText;
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_app);

        db = new SQLiteDbHelper(this);

        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);

        contactListView = findViewById(R.id.contactListView);
    }

    public void onInsertBtnClicked(View view) {
        //Grab the values from EditTexts
        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        //Validate if any of these values are empty
        if (id.equals("") || name.equals("") || phone.equals("")) {
            Toast.makeText(getApplicationContext(), "All input fields are required", Toast.LENGTH_SHORT).show();
        } else {
            Contact contact = new Contact(Integer.parseInt(id), name, phone);
            db.addContact(contact);
            Toast.makeText(getApplicationContext(), "Contact added successfully.", Toast.LENGTH_SHORT).show();
        }

    }

    public void onSelectBtnClicked(View view) {
        ArrayList<Contact> contacts = db.getContactList();
        ContactListAdapter adapter = new ContactListAdapter(this, contacts, db);
        contactListView.setAdapter(adapter);
    }

    public void onUpdateBtnClicked(View view) {
        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        Contact contact = new Contact(Integer.parseInt(id), name, phone);
        db.updateContact(contact);
        Toast.makeText(this, "Contact updated successfully.", Toast.LENGTH_SHORT).show();
    }
}