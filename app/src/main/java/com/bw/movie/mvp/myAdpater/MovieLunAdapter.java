package com.bw.movie.mvp.myAdpater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.CityLunBean;
import com.bw.movie.entity.LunBean;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class MovieLunAdapter extends RecyclerView.Adapter<MovieLunAdapter.ViewHolder> {
    private Context context;
    private List<CityLunBean.ResultBean> list;

    public MovieLunAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<CityLunBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @SuppressLint("HandlerLeak")
    @NonNull
    @Override
    public MovieLunAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.cinema_flow_item,viewGroup,false);
        return new ViewHolder(view);
    }
    @SuppressLint("HandlerLeak")
    @Override
    public void onBindViewHolder(@NonNull final MovieLunAdapter.ViewHolder viewHolder, int postition) {
     viewHolder.simp_cinema_flow.setImageURI(Uri.parse(list.get(postition%list.size()).getImageUrl()));

        viewHolder.text_cinema_flow1.setText(list.get(postition%list.size()).getName());
        viewHolder.text_cinema_flow2.setText(list.get(postition%list.size()).getId()+"分");
    }
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView simp_cinema_flow;
        private TextView text_cinema_flow1;
        private TextView text_cinema_flow2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simp_cinema_flow=itemView.findViewById(R.id.simp_cinema_flow);
            text_cinema_flow1=itemView.findViewById(R.id.text_cinema_flow1);
            text_cinema_flow2=itemView.findViewById(R.id.text_cinema_flow2);

        }
    }
}
