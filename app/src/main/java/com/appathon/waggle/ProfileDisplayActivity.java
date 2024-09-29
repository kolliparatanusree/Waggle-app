package com.appathon.waggle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileDisplayActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "ProfilePrefs";
    private TextView nameTextView;
    private TextView phoneTextView;
    private TextView addressTextView;
    private Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_display); // Ensure this XML layout exists

        nameTextView = findViewById(R.id.textViewName);
        phoneTextView = findViewById(R.id.textViewPhone);
        addressTextView = findViewById(R.id.textViewAddress);
        editButton = findViewById(R.id.buttonEdit);

        // Load saved profile data
        loadProfileData();

        // Set click listener for the edit button
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ProfileActivity for editing
                Intent intent = new Intent(ProfileDisplayActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadProfileData() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String name = preferences.getString("profile_name", "No name available");
        String phone = preferences.getString("profile_phone", "No phone available");
        String address = preferences.getString("profile_address", "No address available");

        nameTextView.setText(name);
        phoneTextView.setText(phone);
        addressTextView.setText(address);
    }
}
