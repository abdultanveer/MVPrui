package com.toast.administrator.hello.ui.login;

import android.database.Cursor;
import android.view.View;

import com.toast.administrator.hello.R;
import com.toast.administrator.hello.data.DataManager;
import com.toast.administrator.hello.data.IDataManager;
import com.toast.administrator.hello.data.db.IDbHelper;
import com.toast.administrator.hello.data.db.model.User;
import com.toast.administrator.hello.data.db.model.UserContract;

public class Presenter implements IPresenter,IDbHelper.OnDataReceived{
    IView iView;
    IDataManager iDataManager;
   public Presenter(MainActivity mainActivity){
       iView = mainActivity;
       iDataManager = new DataManager(mainActivity);
   }
    @Override
    public void onButtonClicked(View view, User user) {
        iDataManager.openDb();
        switch (view.getId()){
           case R.id.submitButton:
               iView.showToast("submitting data");
               iDataManager.createRow(user);


               break;
           case R.id.getButton:
               iView.showToast("getting data");
               iDataManager.readRow(this);
               //i am passing this ondatareceived i/f to datamanager which further passing to dbhelper
               //in dbhelpers onreadrow method, the data is put into this interface,
               //runtime will call its implementation, its implementation is in this presenter class
               //so after reading the row we'll get the data in onSuccess callback in this class

               break;
       }
    }

    @Override
    public void onSuccess(Cursor cursor) {
    // tell the view to paint the data
        cursor.moveToFirst();
        int nameColIndex = cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_NAME_TITLE);
        int pwdColIndex = cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_NAME_PASSWORD);
        String data = cursor.getString(nameColIndex)+"\n"+cursor.getString(pwdColIndex);
        iView.showData(data);
    }

    @Override
    public void onFailure() {

    }
}
