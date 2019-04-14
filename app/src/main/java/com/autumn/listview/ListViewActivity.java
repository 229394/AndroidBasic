package com.autumn.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.autumn.R;

public class ListViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //加载适配器
        ListView listView = findViewById(R.id.lv_1);
        listView.setAdapter(new ListAdapter(ListViewActivity.this));
        //设置点击事件,position代表item的下标,默认从0开始
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"当前pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        //设置长按item事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"长按pos:"+position,Toast.LENGTH_SHORT).show();
                return false;
                //return false会继续上面的点击事件,如果return true则不执行上面的点击事件
            }
        });
    }
}
