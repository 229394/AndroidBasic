package com.autumn.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.autumn.R;

public class HorRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);
        RecyclerView RvHor = findViewById(R.id.rv_hor);
        LinearLayoutManager manager = new LinearLayoutManager(HorRecyclerViewActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RvHor.setLayoutManager(manager);
        RvHor.addItemDecoration(new MyDecoration());
        RvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(HorRecyclerViewActivity.this,"click..."+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    //内部装饰类(用于加上分隔线)
    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
