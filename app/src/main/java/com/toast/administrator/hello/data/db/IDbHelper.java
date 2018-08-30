package com.toast.administrator.hello.data.db;

import android.database.Cursor;

import com.toast.administrator.hello.data.db.model.User;

public interface IDbHelper {
    public void openDb();
    public void closeDb();

    void createRow(User user);

    public void readRow(OnDataReceived onDataReceived);
    public void readAllRows();
    public void updateRow();
    public void deleteRow();

    public interface OnDataReceived{
        public void onSuccess(Cursor cursor);
        public void onFailure();
    }
}
