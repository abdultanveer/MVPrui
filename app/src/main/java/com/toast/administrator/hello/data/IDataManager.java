package com.toast.administrator.hello.data;

import com.toast.administrator.hello.data.db.IDbHelper;
import com.toast.administrator.hello.data.db.model.User;

public interface IDataManager {
    void openDb();

    void createRow(User user);

    public void readRow(IDbHelper.OnDataReceived onDataReceived);

}
