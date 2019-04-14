package com.autumn;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.autumn.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Button btnDialog1 = findViewById(R.id.btn_dialog1);
        Button btnDialog2 = findViewById(R.id.btn_dialog2);
        Button btnDialog3 = findViewById(R.id.btn_dialog3);
        Button btnDialog4 = findViewById(R.id.btn_dialog4);
        Button btnDialog5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        btnDialog1.setOnClickListener(onClick);
        btnDialog2.setOnClickListener(onClick);
        btnDialog3.setOnClickListener(onClick);
        btnDialog4.setOnClickListener(onClick);
        btnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    //分别是积极的按钮,中性的按钮和消极的按钮
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答:").setMessage("你对Android感兴趣吗?").setIcon(R.drawable.icon_user).setPositiveButton("感兴趣", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"你很诚实!");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"真的吗?");
                        }
                    }).setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"你再想想!");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array = new String[]{"男","女"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("请选择性别:").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    //默认选中"女",类似RadioButton样式
                    builder2.setTitle("请选择性别:").setSingleChoiceItems(array2,1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array2[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    //类似Checkbox的样式
                    final String[] array3 = new String[]{"吃饭","睡觉","写代码"};
                    final boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("请选择日常活动:").setMultiChoiceItems(array3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array3[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    //自定义View样式
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(DialogActivity.this);
                    View loginView = inflater.inflate(R.layout.layout_dialog,null);
                    EditText etUsername = loginView.findViewById(R.id.et_username);
                    EditText etPassword = loginView.findViewById(R.id.et_password);
                    Button btnLogin = loginView.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    builder4.setTitle("请先登录:").setView(loginView);
                    builder4.show();
                    break;
            }
        }
    }
}
