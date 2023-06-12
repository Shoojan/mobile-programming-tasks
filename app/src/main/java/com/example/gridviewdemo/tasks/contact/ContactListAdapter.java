package com.example.gridviewdemo.tasks.contact;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gridviewdemo.R;

import java.util.ArrayList;

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private final Activity context;
    private final ArrayList<Contact> contacts;

    private final SQLiteDbHelper db;

    public ContactListAdapter(Activity context, ArrayList<Contact> contacts, SQLiteDbHelper db) {
        super(context, R.layout.activity_contact_item, contacts);
        this.context = context;
        this.contacts = contacts;
        this.db = db;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View contactView = inflater.inflate(R.layout.activity_contact_item, null, true);

        TextView idTextView = contactView.findViewById(R.id.idTextView);
        TextView nameTextView = contactView.findViewById(R.id.nameTextView);
        TextView phoneTextView = contactView.findViewById(R.id.phoneTextView);

        Button editBtn = contactView.findViewById(R.id.editButton);
        Button deleteBtn = contactView.findViewById(R.id.deleteButton);

        Contact contact = contacts.get(position);
        idTextView.setText(String.valueOf(contact.getId()));
        nameTextView.setText(contact.getName());
        phoneTextView.setText(contact.getPhone());

        editBtn.setOnClickListener(view -> {
            EditText idEditText = context.findViewById(R.id.idEditText);
            EditText nameEditText = context.findViewById(R.id.nameEditText);
            EditText phoneEditText = context.findViewById(R.id.phoneEditText);

            idEditText.setText(String.valueOf(contact.getId()));
            nameEditText.setText(contact.getName());
            phoneEditText.setText(contact.getPhone());
        });

        deleteBtn.setOnClickListener(view -> {
            db.deleteContact(String.valueOf(contact.getId()));
            Toast.makeText(context, "Contact deleted successfully", Toast.LENGTH_SHORT).show();
        });

        return contactView;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }
}
