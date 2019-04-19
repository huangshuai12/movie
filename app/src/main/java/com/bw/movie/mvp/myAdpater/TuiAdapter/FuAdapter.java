package com.bw.movie.mvp.myAdpater.TuiAdapter;

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
import com.bw.movie.entity.FuBean;

import java.util.ArrayList;
import java.util.List;

public class FuAdapter extends RecyclerView.Adapter<FuAdapter.ViewHolder> {
    private Context context;
    private List<FuBean.ResultBean> list;

    public FuAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<FuBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.model_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.image_model.setImageURI(Uri.parse(list.get(i).getLogo()));
        viewHolder.title_model.setText(list.get(i).getName()+"");
        viewHolder.name_model.setText(list.get(i).getAddress()+"");
        viewHolder.price_model.setText(list.get(i).getFollowCinema()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickJi.ClickJi(list.get(i).getId()+"");
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_model=itemView.findViewById(R.id.image_model);
            title_model=itemView.findViewById(R.id.title_model);
            name_model=itemView.findViewById(R.id.name_model);
            price_model=itemView.findViewById(R.id.price_model);
        }
    }
    private SetOnClickJi setOnClickJi;

    public void SetOnItemClickJi(SetOnClickJi setOnClickJi) {
        this.setOnClickJi = setOnClickJi;
    }

    public interface SetOnClickJi{
        void ClickJi(String cid);
    }
}
