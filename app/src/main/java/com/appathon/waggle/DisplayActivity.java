package com.appathon.waggle;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity implements UserAdapter.OnUserClickListener {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private DatabaseHelper databaseHelper;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new DatabaseHelper(this);
        userList = new ArrayList<>();

        loadUsersFromDatabase();

        // Pass the activity context and listener to the adapter
        userAdapter = new UserAdapter(this, userList, this);
        recyclerView.setAdapter(userAdapter);
    }

    private void loadUsersFromDatabase() {
        Cursor cursor = databaseHelper.getAllUsers(); // Assumes your DatabaseHelper has a method to get all users
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                String cost = cursor.getString(cursor.getColumnIndexOrThrow("cost"));
                User user = new User(name, phone, address, cost);
                userList.add(user);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
    }

    @Override
    public void onUserClick(User user) {
        // Handle the user click event here
        Intent intent = new Intent(DisplayActivity.this, Success.class);
        startActivity(intent);
        // You can also navigate to another activity if needed
    }
}
