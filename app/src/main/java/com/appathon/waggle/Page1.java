package com.appathon.waggle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1); // Ensure the layout file exists
    }

    public void provideService(View view){
        Intent intent = new Intent(Page1.this, Register.class);
        startActivity(intent);
    }

    public void accessService(View view){
        Intent intent = new Intent(Page1.this, DisplayActivity.class);
        startActivity(intent);
    }
    public void profileDisplay(View view){
        Intent intent = new Intent(Page1.this, ProfileDisplayActivity.class);
        startActivity(intent);
    }

    public void editProfile(View view){
        Intent intent = new Intent(Page1.this, ProfileActivity.class);
        startActivity(intent);
    }
}
