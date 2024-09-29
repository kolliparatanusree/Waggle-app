package com.appathon.waggle;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class TimePlaceSelectionActivity extends AppCompatActivity {

    private TextView dateTextView;
    private EditText fromDestinationEditText, toDestinationEditText;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_place_selection);

        dateTextView = findViewById(R.id.dateTextView);
        fromDestinationEditText = findViewById(R.id.sourceEditText);
        toDestinationEditText = findViewById(R.id.destinationEditText);

        // Set click listener on TextView to show DatePickerDialog
        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        // Get current date as default values for the picker
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(TimePlaceSelectionActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Format the date as you like, e.g., "dd-MM-yyyy"
                        String selectedDate = String.format(Locale.getDefault(), "%02d-%02d-%04d", dayOfMonth, monthOfYear + 1, year);
                        // Display the selected date in the TextView
                        dateTextView.setText(selectedDate);
                    }
                }, year, month, day);

        // Set the minimum selectable date to today
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

        // Show the DatePickerDialog
        datePickerDialog.show();
    }

    // Method to handle button click for booking
    public void success_page(View view) {
        String selectedDate = dateTextView.getText().toString();
        String fromDestination = fromDestinationEditText.getText().toString().trim();
        String toDestination = toDestinationEditText.getText().toString().trim();

        // Validate inputs
        if (selectedDate.equals("Select Date") || fromDestination.isEmpty() || toDestination.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Proceed to Success activity if all fields are valid
            Intent intent = new Intent(TimePlaceSelectionActivity.this, Success.class);
            startActivity(intent);
        }
    }
}
