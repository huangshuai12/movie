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

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.entity.SelectMovie;

import java.util.ArrayList;
import java.util.List;

public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {
    private Context context;
    public List<SelectMovie.ResultBean> list1;
    public MyMovieAdapter(Context context) {
        this.context = context;
        list1=new ArrayList<>();
    }
    public void setList(List<SelectMovie.ResultBean> list) {
        if (list != null){
            this.list1 = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.model_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMovieAdapter.ViewHolder viewHolder, int i) {
        viewHolder.image_model.setImageURI(Uri.parse(list1.get(i).getLogo()));
        viewHolder.name_model.setText(list1.get(i).getName());
        viewHolder.title_model.setText(list1.get(i).getAddress());
      viewHolder.price_model.setText(list1.get(i).getId()+"");
    }

    @Override
    public int getItemCount() {
        return list1 == null ? 0 : list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_model;
        private TextView title_model,name_model,price_model;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_model=itemView.findViewById(R.id.image_model);
            title_model=itemView.findViewById(R.id.title_model);
            name_model=itemView.findViewById(R.id.name_model);
            price_model=image_model.findViewById(R.id.price_model);
        }
    }
}
