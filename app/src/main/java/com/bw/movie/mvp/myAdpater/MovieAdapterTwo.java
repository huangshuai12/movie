package com.bw.movie.mvp.myAdpater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.MovieBean1;
import com.bw.movie.entity.MovieBean2;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapterTwo extends RecyclerView.Adapter<MovieAdapterTwo.ViewHolder> {
    private Context context;
    private List<MovieBean2.ResultBean> list;

    public MovieAdapterTwo(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<MovieBean2.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapterTwo.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.xiang_item_movie,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapterTwo.ViewHolder viewHolder, final int i) {

        viewHolder.name.setText(list.get(i).getScreeningHall());
        viewHolder.date.setText(list.get(i).getBeginTime()+"");
        viewHolder.date1.setText(list.get(i).getEndTime()+"");
        viewHolder.money.setText(list.get(i).getSeatsTotal()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickTui.ClickTui(list.get(i).getId()+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,title,date,date1,money;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
            date1=itemView.findViewById(R.id.date1);
            money = itemView.findViewById(R.id.money);
        }
    }

    private SetOnClickTui setOnClickTui;

    public void SetMovieAdapterTwo(SetOnClickTui setOnClickTui) {
        this.setOnClickTui = setOnClickTui;
    }

    public interface SetOnClickTui{
        void ClickTui(String cid);
    }
}
