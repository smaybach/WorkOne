package com.example.videodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.videodemo.R;
import com.example.videodemo.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by lenovo on 2017/12/20.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    UserBean bean;

    public MyAdapter(Context context, UserBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rlv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        bean.getData().getImages().split("\\|")

        holder.sss.setImageURI(bean.getRet().getList().get(position).getChildList().get(0).getAngleIcon());
        holder.tv.setText(bean.getRet().getList().get(position).getChildList().get(0).getTitle());
//        holder.price.setText(bean.getTuijian().getList().get(position).getPid());
    }

    @Override
    public int getItemCount() {
        return bean==null ? 0:bean.getRet().getList().size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sss;
        private final TextView tv;
        private final TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            sss = itemView.findViewById(R.id.sss);
            tv = itemView.findViewById(R.id.tv);
            price = itemView.findViewById(R.id.price);

        }
    }
}
