package com.example.undergradcareerguide.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {


    // Database Version
    public static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "TestData.db";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +  entries.FeedEntry.TableName + " (" +
                    entries.FeedEntry._ID + " INTEGER ," +
                    entries.FeedEntry.COL1 + " TEXT ," +
                    entries.FeedEntry.COL2 + " TEXT ," +
                    entries.FeedEntry.COL3 + " TEXT ," +
                    entries.FeedEntry.COL4 + " TEXT ," +
                    entries.FeedEntry.COL5 + " TEXT)";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " +  entries.FeedEntry.TableName;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean AddUserData(String Name, String TestName, String CorrectAns, String WrongAns, String Percentage){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( entries.FeedEntry.COL1 , Name );
        contentValues.put( entries.FeedEntry.COL2 , TestName);
        contentValues.put( entries.FeedEntry.COL3 , CorrectAns);
        contentValues.put( entries.FeedEntry.COL4 , WrongAns);
        contentValues.put( entries.FeedEntry.COL5 , Percentage);
        long newRowID= db.insert( entries.FeedEntry.TableName,null,contentValues);
        Log.d("DataBaseInsertss",newRowID+"");
        db.close();
        if(newRowID==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


}
