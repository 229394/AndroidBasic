package com.autumn.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.autumn.R;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //用于列表视图按钮的页面跳转
        Button btnLinear = findViewById(R.id.btn_linear);
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        //用于水平滚动按钮的页面跳转
        Button btnHor = findViewById(R.id.btn_hor);
        btnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        //用于网格视图按钮的页面跳转
        Button btnGrid = findViewById(R.id.btn_grid);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        //用于瀑布流按钮的页面跳转
        Button btnPu = findViewById(R.id.btn_pu);
        btnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
