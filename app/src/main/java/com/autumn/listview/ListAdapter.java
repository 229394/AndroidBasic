package com.autumn.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.autumn.R;
import com.bumptech.glide.Glide;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public ListAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static  class ViewHolder {
        public ImageView imageView;
        public TextView tvName,tvGame,tvContent;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvName = convertView.findViewById(R.id.tv_name);
            holder.tvGame = convertView.findViewById(R.id.tv_game);
            holder.tvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
          holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvName.setText("大小姐");
        holder.tvGame.setText("王者农药");
        holder.tvContent.setText("女射手");
        Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554742176602&di=46cebc51f7c64b446c38793329e9b8d2&imgtype=0&src=http%3A%2F%2Fwww.ooqiu.com%2Fuploads%2Fallimg%2F170726%2F262-1FH6142G20-L.jpg").into(holder.imageView);
        return convertView;
    }
}
