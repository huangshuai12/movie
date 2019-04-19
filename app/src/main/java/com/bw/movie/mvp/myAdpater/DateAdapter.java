package com.bw.movie.mvp.myAdpater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.CityZhanBean;


import java.util.ArrayList;
import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {
    private Context context;
    private List<CityZhanBean.ResultBean> list;

    public DateAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<CityZhanBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.movie_item_three,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.movie_item_three_name.setText(list.get(i).getDuration());
        viewHolder.movie_item_three_price.setText(list.get(i).getBeginTime());
        viewHolder.movie_item_three_price1.setText(list.get(i).getEndTime());
        viewHolder.movie_item_three_title.setText(list.get(i).getSeatsUseCount()+"");

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView movie_item_three_name,movie_item_three_price,movie_item_three_price1,movie_item_three_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_item_three_name=itemView.findViewById(R.id.movie_item_three_name);
            movie_item_three_price=itemView.findViewById(R.id.movie_item_three_price);
            movie_item_three_price1=itemView.findViewById(R.id.movie_item_three_price1);
            movie_item_three_title=itemView.findViewById(R.id.movie_item_three_title);
        }
    }
}
