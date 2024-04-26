package com.arunwichsapplication.app.modules;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Databasemain5.db";
    private static final String TABLE_USER_PROFILE = "UserProfile";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_WAIST = "waist";
    private static final String COLUMN_CHEST = "chest";
    private static final String COLUMN_HIP = "hip";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_USER_PROFILE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_HEIGHT + " DOUBLE, " +
                COLUMN_WEIGHT + " DOUBLE, " +
                COLUMN_WAIST + " DOUBLE, " +
                COLUMN_CHEST + " DOUBLE, " +
                COLUMN_HIP + " DOUBLE)";
        db.execSQL(createUserTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_PROFILE);
        onCreate(db);
    }

    public boolean addUserProfileData(double waist, double chest, double hip, double height, double weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WAIST, waist);
        contentValues.put(COLUMN_CHEST, chest);
        contentValues.put(COLUMN_HIP, hip);
        contentValues.put(COLUMN_HEIGHT, height);
        contentValues.put(COLUMN_WEIGHT, weight);

        // Check if the user profile data already exists
        String query = "SELECT * FROM " + TABLE_USER_PROFILE +
                " WHERE " + COLUMN_WAIST + " = ? AND " +
                COLUMN_CHEST + " = ? AND " +
                COLUMN_HIP + " = ? AND " +
                COLUMN_HEIGHT + " = ? AND " +
                COLUMN_WEIGHT + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(waist), String.valueOf(chest),
                String.valueOf(hip), String.valueOf(height), String.valueOf(weight)});
        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            return false; // User profile data already exists
        }
        if (cursor != null) {
            cursor.close();
        }

        // Insert or replace the user profile data
        long result = db.insertWithOnConflict(TABLE_USER_PROFILE, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        return result != -1;
    }


    public boolean addUser(String email, String password, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_USER_PROFILE + " WHERE " +
                COLUMN_EMAIL + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email});
        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            return false; // User with the same email exists
        }
        if (cursor != null) {
            cursor.close();
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_PHONE, phone);
        long result = db.insert(TABLE_USER_PROFILE, null, contentValues);
        return result != -1;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID};
        String selection = COLUMN_EMAIL + " = ? AND " +
                COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USER_PROFILE, projection, selection, selectionArgs, null, null, null, "1");

        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    public boolean isDatabaseConnected() {
        SQLiteDatabase db = null;
        try {
            db = getWritableDatabase();
            return db != null; // Return true if connected successfully
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }

    public static String getTableName() {
        return TABLE_USER_PROFILE;
    }

    public static String getColumnEmail() {
        return COLUMN_EMAIL;
    }

    public static String getColumnPassword() {
        return COLUMN_PASSWORD;
    }

    public static String getColumnPhone() {
        return COLUMN_PHONE;
    }

    public static String getColumnHeight() {
        return COLUMN_HEIGHT;
    }

    public static String getColumnWeight() {
        return COLUMN_WEIGHT;
    }

    public static String getColumnWaist() {
        return COLUMN_WAIST;
    }

    public static String getColumnChest() {
        return COLUMN_CHEST;
    }

    public static String getColumnHip() {
        return COLUMN_HIP;
    }
}
