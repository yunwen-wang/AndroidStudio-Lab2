package com.example.wangyunwen.newproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
//        final TextInputLayout username = (TextInputLayout) findViewById(R.id.username_);
//        final TextInputLayout password = (TextInputLayout) findViewById(R.id.password_);
//        username.setErrorEnabled(true);
//        username.setError("");

        final RadioGroup radio_group = (RadioGroup) findViewById(R.id.radio_group);
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);

        final TextView tv = (TextView) this.findViewById(R.id.tv);

        final Dialog login_suc = new AlertDialog.Builder(this).
                setTitle("提示").
                setMessage("登陆成功").
                setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "对话框“取消”按钮被点击",Toast.LENGTH_SHORT).show();
//                        Snackbar.make(tv,"对话框“取消”按钮被点击",Snackbar.LENGTH_SHORT)
//                                .setDuration(5000)
//                                .show();
                    }
                }).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "对话框“确定”按钮被点击",Toast.LENGTH_SHORT).show();
                    }
                }).
                create();
        final Dialog login_fail = new AlertDialog.Builder(this).
                setTitle("提示").
                setMessage("登陆失败").
                setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "对话框“取消”按钮被点击",Toast.LENGTH_SHORT).show();
//                        Snackbar.make(tv,"对话框“取消”按钮被点击",Snackbar.LENGTH_SHORT)
//                                .setAction("取消", new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//
//                                    }
//                                })
//                                .setDuration(5000)
//                                .setActionTextColor(getResources().getColor(R.color.white))
//                                .show();
                    }
                }).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "对话框“确定”按钮被点击",Toast.LENGTH_SHORT).show();
                    }
                }).
                create();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString())) {
                    Toast.makeText(MainActivity.this, "用户名不能为空",Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.equals("Android", username.getText().toString()) &&
                        TextUtils.equals("123456", password.getText().toString())) {
                    // show the login successfully message in dialog
                    login_suc.show();
                } else {
                    // the circumstance when enter the wrong username and password
                    login_fail.show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rd = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
                Toast.makeText(MainActivity.this, rd.getText()+"身份注册功能尚未开启",Toast.LENGTH_SHORT).show();
            }
        });

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
                Toast.makeText(MainActivity.this, rd.getText()+"身份被选中", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
