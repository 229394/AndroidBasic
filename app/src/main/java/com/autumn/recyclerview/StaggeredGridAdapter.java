package com.autumn.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.autumn.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context context;
    private OnItemClickListener clickListener;


    public StaggeredGridAdapter(Context context, OnItemClickListener listener){
        this.context = context;
        this.clickListener = listener;

    }
    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //返回的是GridRecyclerView单项item的布局
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_staggered_grid_recycler_item,viewGroup,false));
    }

    //给viewHolder中控件textView进行赋值
    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder viewHolder, final int position) {
        if(position % 2 != 0){
            viewHolder.imageView.setImageResource(R.drawable.image1);
        }else {
            viewHolder.imageView.setImageResource(R.drawable.image2);
        }
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
        return 30;
    }

    //自定义内部类LinearViewHolder
    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener {
        void OnClick(int pos);
    }
}
