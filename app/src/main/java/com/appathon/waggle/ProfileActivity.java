package com.appathon.waggle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "ProfilePrefs";
    private static final String KEY_PROFILE_NAME = "profile_name";
    private static final String KEY_PROFILE_PHONE = "profile_phone";
    private static final String KEY_PROFILE_ADDRESS = "profile_address";

    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); // Ensure this XML layout exists

        nameEditText = findViewById(R.id.editTextname);
        phoneEditText = findViewById(R.id.editTextPhone);
        addressEditText = findViewById(R.id.editTextAddress);
        saveButton = findViewById(R.id.button);

        loadProfileData(); // Load existing profile data if available

        saveButton.setOnClickListener(v -> saveProfileData());
    }

    private void loadProfileData() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String name = preferences.getString(KEY_PROFILE_NAME, "");
        String phone = preferences.getString(KEY_PROFILE_PHONE, "");
        String address = preferences.getString(KEY_PROFILE_ADDRESS, "");

        nameEditText.setText(name);
        phoneEditText.setText(phone);
        addressEditText.setText(address);
    }

    private void saveProfileData() {
        String name = nameEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();

        if (!name.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
            // Save profile data in SharedPreferences
            SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(KEY_PROFILE_NAME, name);
            editor.putString(KEY_PROFILE_PHONE, phone);
            editor.putString(KEY_PROFILE_ADDRESS, address);
            editor.apply();

            // Navigate to Page1 after saving the profile
            Intent intent = new Intent(ProfileActivity.this, Page1.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
