package com.toast.administrator.hello.data;

import android.content.Context;

import com.toast.administrator.hello.data.db.DbHelper;
import com.toast.administrator.hello.data.db.IDbHelper;
import com.toast.administrator.hello.data.db.IDbManager;
import com.toast.administrator.hello.data.db.model.User;

/**
 * this datamanager will decide whether to get data from local db or remoted db
 * based on condition like internet connectivity
 */
public class DataManager implements IDataManager {

    IDbHelper iDbHelper;

   public DataManager(Context context){
       iDbHelper = new DbHelper(context);
   }

    @Override
    public void openDb() {
    iDbHelper.openDb();
    }

    @Override
    public void createRow(User user) {
    iDbHelper.createRow(user);
    }

    @Override
    public void readRow(IDbHelper.OnDataReceived onDataReceived) {
        iDbHelper.readRow(onDataReceived);
    }
}
