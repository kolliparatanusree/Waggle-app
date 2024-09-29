package com.appathon.waggle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success); // Make sure you create activity_details.xml
    }
    public void backToHome(View v){
        Intent intent = new Intent(Success.this, Page1.class);
        startActivity(intent);
    }
}
