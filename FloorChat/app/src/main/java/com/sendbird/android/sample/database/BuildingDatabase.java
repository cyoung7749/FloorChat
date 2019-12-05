package com.sendbird.android.sample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BuildingDatabase extends SQLiteOpenHelper {

    //Building name, number of floors, langitude and longitude, and floor plan

    private static String DBNAME = "buildingsqlite";
    private static int VERSION = 1;
    private static final String DATABASE_TABLE = "buildings";
    private SQLiteDatabase myDB;
    public static final String FIELD_ROW_ID = "_id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_LAT = "lat";
    public static final String FIELD_LNG = "lng";
    public static final String FIELD_IMG = "img";

    public BuildingDatabase(Context context) {
        super(context, DBNAME, null, VERSION);
        this.myDB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + DATABASE_TABLE + " ( " +
                FIELD_ROW_ID + " integer primary key autoincrement , " +
                FIELD_NAME + " text , " +
                FIELD_LAT + " double , " +
                FIELD_LNG + " double , " +
                FIELD_IMG + " blob " +
                " ) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        myDB.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(myDB);
    }
}
