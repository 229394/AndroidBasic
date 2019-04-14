package com.autumn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.autumn.util.ToastUtil;
import com.autumn.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        Button btnDialog = findViewById(R.id.btn_custom_dialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this,R.style.CustomDialog);
                customDialog.setTitle("提示:").setMessage("确认删除此项吗?")
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void OnConfirm(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"确认成功");
                            }
                        }).setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void OnCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"已取消");
                            }
                }).show();
            }
        });
    }
}
