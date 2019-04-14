package com.autumn.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.autumn.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {

    private Context context;
    private OnItemClickListener clickListener;


    public GridAdapter(Context context, OnItemClickListener listener){
        this.context = context;
        this.clickListener = listener;

    }
    @NonNull
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //返回的是GridRecyclerView单项item的布局
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_grid_recycler_item,viewGroup,false));
    }

    //给viewHolder中控件textView进行赋值
    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder viewHolder, final int position) {
        viewHolder.textView.setText("Hello");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnClick(position);
                //Toast.makeText(context,"click..."+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 60;
    }

    //自定义内部类LinearViewHolder
    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void OnClick(int pos);
    }
}
