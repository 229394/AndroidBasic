package com.autumn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        //给checkbox设置点击事件
        CheckBox checkBox = findViewById(R.id.cb_5);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"cb5被选中":"cb5未被选中",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox1 = findViewById(R.id.cb_6);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"cb6被选中":"cb6未被选中",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox2 = findViewById(R.id.cb_7);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"cb7被选中":"cb7未被选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
