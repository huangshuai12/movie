package com.bw.movie.mvp.myAdpater.popwindow;

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
import com.bw.movie.entity.LunBean;
import com.bw.movie.entity.PingBean;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class PingAdapter extends RecyclerView.Adapter<PingAdapter.ViewHolder> {
    private Context context;
    private List<PingBean.ResultBean> list;

    public PingAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<PingBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @SuppressLint("HandlerLeak")
    @NonNull
    @Override
    public PingAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.pop_film_ietm_ping,viewGroup,false);
        return new ViewHolder(view);
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onBindViewHolder(@NonNull final PingAdapter.ViewHolder viewHolder, int postition) {
        viewHolder.review_sdv_image.setImageURI(Uri.parse(list.get(postition).getCommentHeadPic()));
        viewHolder.review_txt_name.setText(list.get(postition).getCommentUserName());
        viewHolder.review_txt_content.setText(list.get(postition).getCommentContent());
        viewHolder.review_txt_date.setText(list.get(postition).getCommentTime()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView review_sdv_image;
        private TextView review_txt_name;
        private TextView review_txt_content;
        private TextView review_txt_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            review_sdv_image=itemView.findViewById(R.id.review_sdv_image);
            review_txt_name=itemView.findViewById(R.id.review_txt_name);
            review_txt_content=itemView.findViewById(R.id.review_txt_content);
            review_txt_date=itemView.findViewById(R.id.review_txt_date);
        }
    }
}
