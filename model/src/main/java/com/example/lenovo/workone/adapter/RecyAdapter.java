package com.example.lenovo.workone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.workone.R;
import com.example.lenovo.workone.bean.UserBean;

/**
 * Created by lenovo on 2017/12/16.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    Context context;
    UserBean bean;

    public RecyAdapter(Context context, UserBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recyclerview_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_title.setText(bean.getTuijian().getList().get(position).getTitle());
        holder.tv_author.setText(bean.getTuijian().getList().get(position).getSubhead());
        Glide.with(context).load(bean.getTuijian().getList().get(position).getImages()).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return bean==null?0:bean.getTuijian().getList().size();
    }
    class  ViewHolder extends RecyclerView.ViewHolder{
          ImageView imageView;
          TextView tv_title;
          TextView tv_author;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_author = itemView.findViewById(R.id.tv_author);

        }
    }
}
