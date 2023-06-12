package com.example.gridviewdemo.tasks.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "my_contacts_db";
    private final String TABLE_NAME = "my_contacts";

    /*
            CREATE TABLE my_contacts_table(
                id INTEGER PRIMARY KEY,
                name VARCHAR(50),
                phone VARCHAR(15)
            );

            INSERT INTO my_contacts_table(id, name, phone)
            VALUES (1, "Ram", "9841123456");

            SELECT * FROM my_contacts_table;

            UPDATE my_contacts_table SET name = "Shyam" WHERE id = 1;

            DELETE FROM my_contacts_table WHERE id=1;
     */
    public SQLiteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "phone TEXT)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTableQuery = "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(dropTableQuery);

        this.onCreate(sqLiteDatabase);
    }

    //Handle CRUD operation - Create | Read | Update | Delete
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", contact.getId());
        contentValues.put("name", contact.getName());
        contentValues.put("phone", contact.getPhone());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        //Parse id from int datatype to String
        String idString = String.valueOf(id);

        //SELECT id, name, phone FROM my_contacts_table WHERE id=?;
        Cursor cursor = db.query(TABLE_NAME, new String[]{"id", "name", "phone"}, "id=?", new String[]{idString}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            return new Contact(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }

        return null;
    }

    public ArrayList<Contact> getContactList() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<Contact> contacts = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                contacts.add(contact);
            } while (cursor.moveToNext());
        }
        return contacts;
    }

    public void updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", contact.getName());
        contentValues.put("phone", contact.getPhone());

        db.update(TABLE_NAME, contentValues, "id=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public void deleteContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{id});
    }

}
