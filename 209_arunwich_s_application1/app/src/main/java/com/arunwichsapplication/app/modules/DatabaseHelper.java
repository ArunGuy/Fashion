package com.arunwichsapplication.app.modules;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Databasemain.db";
    private static final String TABLE_NAME = "User";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHONE = "phone";

    private static final String TABLE_USER_PROFILE = "UserProfile";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_WAIST = "waist";
    private static final String COLUMN_BUST = "bust";
    private static final String COLUMN_HIP = "hip";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_PHONE + " TEXT)";
        db.execSQL(createTableQuery);

        String createUserProfileTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_USER_PROFILE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HEIGHT + " REAL, " +
                COLUMN_WEIGHT + " REAL, " +
                COLUMN_WAIST + " REAL, " +
                COLUMN_BUST + " REAL, " +
                COLUMN_HIP + " REAL)";
        db.execSQL(createUserProfileTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_PROFILE);
        onCreate(db);
    }

    public boolean addUser(String email, String password, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_EMAIL + " = ? AND " +
                COLUMN_PASSWORD + " = ? AND " +
                COLUMN_PHONE + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password, phone});
        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            return false; // User with the same email, password, and phone exists
        }
        if (cursor != null) {
            cursor.close();
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_PHONE, phone);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID};
        String selection = COLUMN_EMAIL + " = ? AND " +
                COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, "1");

        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    public boolean addUserWithoutPhone(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_EMAIL + " = ? AND " +
                COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            return false; // User with the same email and password exists
        }
        if (cursor != null) {
            cursor.close();
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
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
        return TABLE_NAME;
    }

    public static String getColumnEmail() {
        return COLUMN_EMAIL;
    }

    public static String getColumnPassword() {
        return COLUMN_PASSWORD;
    }

    public static String getTableNameUserProfile() {
        return TABLE_USER_PROFILE;
    }

    public UserProfile getUserProfileByEmailAndPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] userColumns = {COLUMN_ID};
        String userSelection = COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] userSelectionArgs = {email, password};
        Cursor userCursor = db.query(TABLE_NAME, userColumns, userSelection, userSelectionArgs, null, null, null);

        if (userCursor != null && userCursor.moveToFirst()) {
            int userIdIndex = userCursor.getColumnIndex(COLUMN_ID);
            if (userIdIndex >= 0) { // ตรวจสอบว่า index ไม่เป็นค่าลบ (-1)
                int userId = userCursor.getInt(userIdIndex);
                userCursor.close();

                String[] profileColumns = {COLUMN_HEIGHT, COLUMN_WEIGHT, COLUMN_WAIST, COLUMN_BUST, COLUMN_HIP};
                String profileSelection = COLUMN_ID + " = ?";
                String[] profileSelectionArgs = {String.valueOf(userId)};
                Cursor profileCursor = db.query(TABLE_USER_PROFILE, profileColumns, profileSelection, profileSelectionArgs, null, null, null);

                if (profileCursor != null && profileCursor.moveToFirst()) {
                    int heightIndex = profileCursor.getColumnIndex(COLUMN_HEIGHT);
                    int weightIndex = profileCursor.getColumnIndex(COLUMN_WEIGHT);
                    int waistIndex = profileCursor.getColumnIndex(COLUMN_WAIST);
                    int bustIndex = profileCursor.getColumnIndex(COLUMN_BUST);
                    int hipIndex = profileCursor.getColumnIndex(COLUMN_HIP);

                    if (heightIndex >= 0 && weightIndex >= 0 && waistIndex >= 0 && bustIndex >= 0 && hipIndex >= 0) {
                        double height = profileCursor.getDouble(heightIndex);
                        double weight = profileCursor.getDouble(weightIndex);
                        double waist = profileCursor.getDouble(waistIndex);
                        double bust = profileCursor.getDouble(bustIndex);
                        double hip = profileCursor.getDouble(hipIndex);

                        profileCursor.close();
                        return new UserProfile(userId, height, weight, waist, bust, hip);
                    }
                }
            }
        }

        return null;
    }

    public boolean addUserProfileData(double waist, double chest, double hip, double height, double weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WAIST, waist);
        contentValues.put(COLUMN_BUST, chest);
        contentValues.put(COLUMN_HIP, hip);
        contentValues.put(COLUMN_HEIGHT, height);
        contentValues.put(COLUMN_WEIGHT, weight);

        // เช็คว่ามีข้อมูลอยู่แล้วหรือไม่โดยใช้ query
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(1)}; // ตั้งค่า ID ที่ต้องการเช็ค (ตัวอย่างใช้ ID 1)
        Cursor cursor = db.query(TABLE_USER_PROFILE, null, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            // มีข้อมูลอยู่แล้ว ให้อัพเดทข้อมูล
            int columnIndex = cursor.getColumnIndex(COLUMN_ID);
            if (columnIndex != -1) {
                int id = cursor.getInt(columnIndex);
                long result = db.update(TABLE_USER_PROFILE, contentValues, selection, selectionArgs);
                cursor.close();
                return result != -1;
            } else {
                // Handle case when COLUMN_ID not found
                cursor.close();
                return false;
            }
        } else {
            // ไม่มีข้อมูลอยู่แล้ว ให้เพิ่มข้อมูลใหม่
            long result = db.insert(TABLE_USER_PROFILE, null, contentValues);
            if (cursor != null) {
                cursor.close();
            }
            return result != -1;
        }
    }


    public class UserProfile {
        private int userId;
        private double height;
        private double weight;
        private double waist;
        private double bust;
        private double hip;

        public UserProfile(int userId, double height, double weight, double waist, double bust, double hip) {
            this.userId = userId;
            this.height = height;
            this.weight = weight;
            this.waist = waist;
            this.bust = bust;
            this.hip = hip;
        }

        public int getUserId() {
            return userId;
        }

        public double getHeight() {
            return height;
        }

        public double getWeight() {
            return weight;
        }

        public double getWaist() {
            return waist;
        }

        public double getBust() {
            return bust;
        }

        public double getHip() {
            return hip;
        }
    }
}
