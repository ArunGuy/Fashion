package com.arunwichsapplication.app.modules;

import static android.app.DownloadManager.COLUMN_STATUS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Databasemain12.db";
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
    private Context context;
    private String loggedInUserEmail;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
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
                COLUMN_HIP + " DOUBLE, " +
                COLUMN_STATUS + " INTEGER DEFAULT 0)"; // New column for status with default value 0
        db.execSQL(createUserTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_PROFILE);
        onCreate(db);
    }

    public boolean updateUserStatus(String email, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STATUS, status);
        String selection = COLUMN_EMAIL + " = ?";
        String[] selectionArgs = { email };
        int rowsUpdated = db.update(TABLE_USER_PROFILE, values, selection, selectionArgs);
        return rowsUpdated > 0;
    }


    public int getUserStatus(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_STATUS};
        String selection = COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_USER_PROFILE, projection, selection, selectionArgs, null, null, null);
        int status = -1; // Default value if not found
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                status = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STATUS));
            }
            cursor.close();
        }
        db.close(); // Close the database to prevent resource leaks
        return status;
    }



    private boolean checkUserLoggedIn() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID};
        Cursor cursor = db.query(TABLE_USER_PROFILE, projection, null, null, null, null, null);
        boolean isLoggedIn = cursor.getCount() > 0;
        cursor.close();
        return isLoggedIn;
    }

    public String getUserLoggedInEmail() {
        SQLiteDatabase db = this.getReadableDatabase();
        String email = null;
        Cursor cursor = db.query(TABLE_USER_PROFILE, new String[]{COLUMN_EMAIL}, COLUMN_STATUS + " = ?", new String[]{"1"}, null, null, null);
        if (cursor.moveToFirst()) {
            email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));
        }
        cursor.close();
        return email;
    }

    public int getStatusForLoggedInUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        int status = -1; // Default value if not found
        String email = getUserLoggedInEmail();
        if (email != null) {
            Cursor cursor = db.query(TABLE_USER_PROFILE, new String[]{COLUMN_STATUS}, COLUMN_EMAIL + " = ?", new String[]{email}, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    status = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STATUS));
                }
                cursor.close();
            }
        }
        db.close(); // Close the database to prevent resource leaks
        return status;
    }

    public int getStatusForLoggedInUser1() {
        String email = getUserLoggedInEmail();
        return getUserStatus(email);
    }


    // ฟังก์ชันเรียก email ของผู้ใช้อยู่โดยตรวจสอบการล็อกอิน
    public String getUserEmail() {
        return getUserLoggedInEmail();
    }



    public boolean isUserLoggedIn() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID};
        Cursor cursor = db.query(TABLE_USER_PROFILE, projection, null, null, null, null, null);
        boolean isLoggedIn = cursor.getCount() > 0;
        cursor.close();
        return isLoggedIn;
    }




    // เมื่อผู้ใช้ล็อกอินสำเร็จ
    public void setLoggedInUserEmail(String email) {
        loggedInUserEmail = email;
    }


    public boolean addUserProfileData(String email, double waist, double chest, double hip, double height, double weight) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_WAIST, waist);
        contentValues.put(COLUMN_CHEST, chest);
        contentValues.put(COLUMN_HIP, hip);
        contentValues.put(COLUMN_HEIGHT, height);
        contentValues.put(COLUMN_WEIGHT, weight);

        // Check if the user profile data already exists
        String selection = COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(
                TABLE_USER_PROFILE,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            // Update the user profile data
            int rowsUpdated = db.update(TABLE_USER_PROFILE, contentValues, selection, selectionArgs);
            if (rowsUpdated > 0) {
                String updatedData = "Updated data: ";
                if (waist != 0.0) updatedData += "Waist: " + waist + ", ";
                if (chest != 0.0) updatedData += "Chest: " + chest + ", ";
                if (hip != 0.0) updatedData += "Hip: " + hip + ", ";
                if (height != 0.0) updatedData += "Height: " + height + ", ";
                if (weight != 0.0) updatedData += "Weight: " + weight + ", ";
                Toast.makeText(context, updatedData.substring(0, updatedData.length() - 2), Toast.LENGTH_SHORT).show();
                return true;
            } else {
                Toast.makeText(context, "Failed to update data", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        // Insert the user profile data if it doesn't exist
        long result = db.insert(TABLE_USER_PROFILE, null, contentValues);
        if (result != -1) {
            String savedData = "Saved data: ";
            if (waist != 0.0) savedData += "Waist: " + waist + ", ";
            if (chest != 0.0) savedData += "Chest: " + chest + ", ";
            if (hip != 0.0) savedData += "Hip: " + hip + ", ";
            if (height != 0.0) savedData += "Height: " + height + ", ";
            if (weight != 0.0) savedData += "Weight: " + weight + ", ";
            Toast.makeText(context, savedData.substring(0, savedData.length() - 2), Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(context, "Failed to save data", Toast.LENGTH_SHORT).show();
            return false;
        }
    }



    public boolean checkUserProfileExists() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            // Query to check if any data exists in the user profile table
            String query = "SELECT * FROM " + TABLE_USER_PROFILE;
            cursor = db.rawQuery(query, null);
            return cursor != null && cursor.getCount() > 0;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
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
        String selection = COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?";
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

    public int getUserStatus() {
        return 0;
    }

    public boolean updateUserStatus(int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STATUS, status);
        int result = db.update(TABLE_USER_PROFILE, contentValues, null, null);
        db.close();
        return result != 0; // ถ้าการอัปเดตสำเร็จจะส่งค่าคืน true, ถ้าไม่สำเร็จจะส่งค่าคืน false
    }

    public Map<String, Double> getUserData(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_HEIGHT, COLUMN_WEIGHT, COLUMN_WAIST, COLUMN_CHEST, COLUMN_HIP};
        String selection = COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_USER_PROFILE, projection, selection, selectionArgs, null, null, null);
        Map<String, Double> userData = new HashMap<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                double height = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_HEIGHT));
                double weight = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_WEIGHT));
                double waist = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_WAIST));
                double chest = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_CHEST));
                double hip = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_HIP));

                userData.put(COLUMN_HEIGHT, height);
                userData.put(COLUMN_WEIGHT, weight);
                userData.put(COLUMN_WAIST, waist);
                userData.put(COLUMN_CHEST, chest);
                userData.put(COLUMN_HIP, hip);
            } while (cursor.moveToNext());

            // Build a string to display all values
            StringBuilder message = new StringBuilder("User data: ");
            for (Map.Entry<String, Double> entry : userData.entrySet()) {
                message.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
            message.setLength(message.length() - 2); // Remove the last comma and space

            // Show the Toast message
            Toast.makeText(context, message.toString(), Toast.LENGTH_SHORT).show();

            cursor.close();
        }
        return userData;
    }







}