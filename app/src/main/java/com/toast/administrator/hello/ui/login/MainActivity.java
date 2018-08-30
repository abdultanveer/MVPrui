package com.toast.administrator.hello.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.toast.administrator.hello.R;
import com.toast.administrator.hello.data.db.model.User;

public class MainActivity extends AppCompatActivity implements IView{
    IPresenter iPresenter;
    EditText etName, etPwd;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter = new Presenter(this);
        etName = findViewById(R.id.editTextName);
        etPwd = findViewById(R.id.editTextPassword);
        resultTextView = findViewById(R.id.result);
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case R.id.submitButton:
            String name =   etName.getText().toString();
            String pwd = etPwd.getText().toString();
                User user = new User(name,pwd);
                iPresenter.onButtonClicked(view,user);
                break;
            case R.id.getButton:
                break;
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(String data) {
        resultTextView.setText(data);
    }
}
