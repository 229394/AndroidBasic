package com.autumn;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;


public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        TextView textView = findViewById(R.id.tv_4);
        //添加中划线
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        textView.getPaint().setAntiAlias(true);//去除锯齿

        TextView textView2 = findViewById(R.id.tv_5);
        //添加下划线
        textView2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        TextView textView3 = findViewById(R.id.tv_6);
        //用HTML添加下划线
        textView3.setText(Html.fromHtml("<u>lsq,How are you?</u>"));

    }
}
