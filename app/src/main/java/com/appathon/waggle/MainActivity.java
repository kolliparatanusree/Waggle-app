package com.appathon.waggle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "ProfilePrefs";
    private static final String KEY_PROFILE_NAME = "profile_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Your main XML layout

        // Handler to open the relevant activity after 3 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if profile name is saved
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                String profileName = preferences.getString(KEY_PROFILE_NAME, null);

                Intent intent;
                if (profileName == null) {
                    // Profile name is null, open ProfileActivity
                    intent = new Intent(MainActivity.this, ProfileActivity.class);
                } else {
                    // Profile name exists, open Page1
                    intent = new Intent(MainActivity.this, Page1.class);
                }

                startActivity(intent);
                finish(); // Close MainActivity
            }
        }, 1000); // 3000 milliseconds = 3 seconds delay
    }
}
