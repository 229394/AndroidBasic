package com.autumn.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.autumn.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private OnItemClickListener listener;

    public LinearAdapter(Context context,OnItemClickListener listener){
        this.context = context;
        this.listener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //返回的是RecyclerView单项item的布局
        if(i == 0)
            return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item,viewGroup,false));
        else
            return new LinearViewHolder2(LayoutInflater.from(context).inflate(R.layout.layout_linear_item2,viewGroup,false));
    }

    //给viewHolder中控件进行赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        //不同的viewHolder呈现出来的效果
        if(getItemViewType(position) ==0){
            ((LinearViewHolder)viewHolder).textView.setText("以梦为马,不负韶华");
        }else{
            ((LinearViewHolder2)viewHolder).imageView.setImageResource(R.drawable.beauty_girl);
            ((LinearViewHolder2)viewHolder).textView.setText("面朝大海,春暖花开");
        }
        //设置点击监听事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(position);
                //Toast.makeText(context,"click..."+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public int getItemViewType(int pos) {
        if(pos %2 == 0)
            return 0;
        else
            return 1;
    }

    //自定义内部类LinearViewHolder
    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
