package com.bw.movie.mvp.myAdpater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.MovieBean1;
import com.bw.movie.entity.TuiBean;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<MovieBean1.ResultBean> list;

    public MovieAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<MovieBean1.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.model_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.image_model.setImageURI(Uri.parse(list.get(i).getLogo()));
        viewHolder.title_model.setText(list.get(i).getName()+"");
        viewHolder.name_model.setText(list.get(i).getAddress()+"");
        viewHolder.price_model.setText(list.get(i).getCommentTotal()+"");

       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickTui.ClickTui(list.get(i).getId()+"",list.get(i).getName(),list.get(i).getAddress());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_model;
        private TextView title_model,name_model,price_model;
        private CheckBox mXiangCheckbox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_model=itemView.findViewById(R.id.image_model);
            title_model=itemView.findViewById(R.id.title_model);
            name_model=itemView.findViewById(R.id.name_model);
            price_model=itemView.findViewById(R.id.price_model);
            mXiangCheckbox = itemView.findViewById(R.id.tuijian_checkbox);
        }
    }
   private SetOnClickTui setOnClickTui;

    public void SetOnItemClickTui(SetOnClickTui setOnClickTui) {
        this.setOnClickTui = setOnClickTui;
    }

    public interface SetOnClickTui{
        void ClickTui(String moived,String name,String title);
    }


}
