package com.dayeong.gdgssu_fork.data;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dayeong.gdgssu_fork.dao.Timer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class DBManager extends SQLiteOpenHelper {

    private static final String SIMPLE_TIMER_TABLE = "simpleTimers";

    private static final String COL_SIMPLE_TIMER_ID = "id";
    private static final String COL_SIMPLE_TIMER_NAME = "name";
    private static final String COL_SIMPLE_TIMER_TIME = "time";

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + SIMPLE_TIMER_TABLE + "(" +
                COL_SIMPLE_TIMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SIMPLE_TIMER_NAME + " TEXT, " +
                COL_SIMPLE_TIMER_TIME + " INTEGER);");
    }


    public void insertSimpleTimer(Timer timer) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO " + SIMPLE_TIMER_TABLE + " values(null, '" +
                timer.getName() + "', " + timer.getTime() + ");");
    }


    public List<Timer> getAllSimpleTimer() {
        List<Timer> timers = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SIMPLE_TIMER_TABLE + " ORDER BY " + COL_SIMPLE_TIMER_TIME + " DESC", null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            int time = cursor.getInt(2);

            timers.add(new Timer(name, time));
        }
        return timers;
    }


    public boolean isEmptySimpleTimer() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SIMPLE_TIMER_TABLE, null);
        return cursor.getCount() == 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
