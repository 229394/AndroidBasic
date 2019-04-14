package com.autumn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ImageView imageView = findViewById(R.id.iv_4);
        //加载孙尚香大小姐的网络图片
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554742176602&di=46cebc51f7c64b446c38793329e9b8d2&imgtype=0&src=http%3A%2F%2Fwww.ooqiu.com%2Fuploads%2Fallimg%2F170726%2F262-1FH6142G20-L.jpg").into(imageView);
    }
}
