package com.autumn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = findViewById(R.id.btn_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"btn3被点击了!",Toast.LENGTH_SHORT).show();
            }
        });

        TextView textView = findViewById(R.id.tv_1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"tv1被点击了!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showToast(View view) {
        Toast.makeText(this,"btn4被点击了!",Toast.LENGTH_SHORT).show();
    }
}
