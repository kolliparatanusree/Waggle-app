package com.appathon.waggle;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private EditText costEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.editTextName);
        phoneEditText = findViewById(R.id.editTextPhone);
        addressEditText = findViewById(R.id.editTextText);
        costEditText = findViewById(R.id.editTextCost);
    }

    public void backToHome(View view) {
        String name = nameEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();
        String cost = costEditText.getText().toString().trim();

        Log.d("ProfileData", "Name: " + name);
        Log.d("ProfileData", "Phone: " + phone);
        Log.d("ProfileData", "Address: " + address);
        Log.d("ProfileData", "Cost: " + cost);

        if (!name.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !cost.isEmpty()) {
            try {
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("phone", phone);
                values.put("address", address);
                values.put("cost", cost);

                long newRowId = database.insert("Profile", null, values);

                if (newRowId != -1) {
                    Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Error adding data", Toast.LENGTH_SHORT).show();
                    Log.e("SQLiteError", "Failed to insert data into the database.");
                }
            } catch (SQLException e) {
                Log.e("SQLiteError", "Exception while inserting data: " + e.getMessage());
                Toast.makeText(this, "Database error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
