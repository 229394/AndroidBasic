package com.autumn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.autumn.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        Button btnToast1 = findViewById(R.id.btn_toast1);
        Button btnToast2 = findViewById(R.id.btn_toast2);
        Button btnToast3 = findViewById(R.id.btn_toast3);
        Button btnToast4 = findViewById(R.id.btn_toast4);
        OnClick onClick = new OnClick();
        btnToast1.setOnClickListener(onClick);
        btnToast2.setOnClickListener(onClick);
        btnToast3.setOnClickListener(onClick);
        btnToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_toast1:
                    Toast.makeText(getApplicationContext(),"Hello,autumn_leaf!",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"居中Toast",Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.icon_simle);
                    textView.setText("自定义Toast");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast4:
                    ToastUtil.showMsg(ToastActivity.this,"包装过的Toast");
                    break;
                default:
                    break;
            }
        }
    }
}
