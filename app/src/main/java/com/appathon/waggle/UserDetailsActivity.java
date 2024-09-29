package com.appathon.waggle;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView contactTextView;
    private EditText sourceEditText, destinationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        contactTextView = findViewById(R.id.contactTextView);
        sourceEditText = findViewById(R.id.sourceEditText);
        destinationEditText = findViewById(R.id.destinationEditText);

        // Get the user data passed through the intent
        String userName = getIntent().getStringExtra("user_name");
        String userPhone = getIntent().getStringExtra("user_phone");

        // Set the user's contact info in the TextView
        contactTextView.setText("Contact: " + userName + " - " + userPhone);
    }
}
