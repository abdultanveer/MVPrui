package com.toast.administrator.hello.ui.login;

import android.view.View;

import com.toast.administrator.hello.data.db.model.User;

public interface IPresenter {
   void onButtonClicked(View view, User user);
}
