package com.toast.administrator.hello.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.toast.administrator.hello.data.db.model.User;
import com.toast.administrator.hello.data.db.model.UserContract.UserEntry;


import com.toast.administrator.hello.data.db.IDbHelper;

public class DbHelper implements IDbHelper {
    public static final String TAG = DbHelper.class.getSimpleName();

    SQLiteDatabase database;
    DbOpenHelper openHelper;
    public DbHelper(Context context){
        openHelper = new DbOpenHelper(context);
    }

    @Override
    public void openDb() {
        database = openHelper.getWritableDatabase();
    }

    @Override
    public void closeDb() {
        database.close();
    }

    @Override
    public void createRow(User user) {
        ContentValues values = new ContentValues();
        values.put(UserEntry.COLUMN_NAME_TITLE, user.getName() );
        values.put(UserEntry.COLUMN_NAME_PASSWORD, user.getPassword() );

        database.insert(UserEntry.TABLE_NAME,null,values);
        Log.i(TAG,"insert db row");

    }

    @Override
    public void readRow(OnDataReceived onDataReceived) {
        Cursor cursor;
        cursor =
                database.query(UserEntry.TABLE_NAME,null,null,
                        null,null,null,null);
        onDataReceived.onSuccess(cursor);//from here presenters line no 37 is called
    }

    @Override
    public void readAllRows() {

    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}