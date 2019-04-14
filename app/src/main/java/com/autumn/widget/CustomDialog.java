package com.autumn.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.autumn.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private String title,message,confirm,cancel;
    private IOnConfirmListener confirmListener;
    private IOnCancelListener cancelListener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener confirmListener) {
        this.confirm = confirm;
        this.confirmListener = confirmListener;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener cancelListener) {
        this.cancel = cancel;
        this.cancelListener = cancelListener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        // 设置宽度
        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        // 宽度为当前屏幕的80%
        params.width = (int)(size.x * 0.8);
        getWindow().setAttributes(params);
        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvMessage = findViewById(R.id.tv_message);
        TextView tvConfirm = findViewById(R.id.tv_confirm);
        TextView tvCancel = findViewById(R.id.tv_cancel);
        if(!TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            tvMessage.setText(message);
        }
        if(!TextUtils.isEmpty(confirm)){
            tvConfirm.setText(confirm);
        }
        if(!TextUtils.isEmpty(cancel)){
            tvCancel.setText(cancel);
        }
        tvConfirm.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_confirm:
                if(confirmListener != null)
                    confirmListener.OnConfirm(this);
                dismiss();
                break;
            case R.id.tv_cancel:
                if (cancelListener != null)
                    cancelListener.OnCancel(this);
                dismiss();
                break;
        }
    }

    public interface IOnConfirmListener {
        public void OnConfirm(CustomDialog dialog);
    }

    public interface IOnCancelListener {
        public void OnCancel(CustomDialog dialog);
    }

}
