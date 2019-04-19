package com.bw.movie.mvp.myAdpater.ShouAdapter;

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
import com.bw.movie.entity.ZhengBean;

import java.util.ArrayList;
import java.util.List;

public class ZhegAdapter extends RecyclerView.Adapter<ZhegAdapter.ViewHolder> {
    private Context context;
    private List<ZhengBean.ResultBean> list;

    public ZhegAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<ZhengBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ZhegAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.ren_activity,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZhegAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.image_fe.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.name1.setText(list.get(i).getName()+"");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick1.SetClick1(list.get(i).getId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_fe;
        private TextView name1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_fe=itemView.findViewById(R.id.image_fe);
            name1=itemView.findViewById(R.id.name1);

        }
    }

    public SetOnClick1 setOnClick1;

    public void SetOnItemClick1(SetOnClick1 setOnClick1) {
        this.setOnClick1 = setOnClick1;
    }

    public interface SetOnClick1{
        void SetClick1(String cid);
    }
}
