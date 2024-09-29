package com.appathon.waggle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "waggle.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("SQLite", "Database path: " + context.getDatabasePath(DATABASE_NAME).getAbsolutePath());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d("SQLite", "Attempting to create Profile table.");
            String CREATE_PROFILE_TABLE = "CREATE TABLE IF NOT EXISTS Profile (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "phone TEXT, " +
                    "address TEXT, " +
                    "cost TEXT)";
            db.execSQL(CREATE_PROFILE_TABLE);
            Log.d("SQLite", "Profile table created successfully.");
        } catch (Exception e) {
            Log.e("SQLiteError", "Error creating table: " + e.getMessage());
        }
    }
    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Profile", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Profile");
        onCreate(db);
    }

}
