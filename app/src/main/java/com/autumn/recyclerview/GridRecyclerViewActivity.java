package com.autumn.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.autumn.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        RecyclerView RvGrid = findViewById(R.id.rv_grid);
        //一行展示3个Item
        RvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        RvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"click..."+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
