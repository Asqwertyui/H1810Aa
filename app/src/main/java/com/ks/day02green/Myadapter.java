package com.ks.day02green;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private ArrayList<Bean> mBeans;

    public void setBeans(ArrayList<Bean> beans) {
        mBeans = beans;
    }

    private Context context;

    public Myadapter(ArrayList<Bean> beans, Context context) {
        mBeans = beans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bean bean = mBeans.get(position);
        holder.tv.setText(bean.getName());
        holder.tvv.setText(bean.getSex());
    }

    @Override
    public int getItemCount() {
        return mBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private TextView tvv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tvv=itemView.findViewById(R.id.tvv);
        }
    }
}
