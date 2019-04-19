package com.bw.movie.mvp.myAdpater.Shou;

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

public class Zheg1Adapter extends RecyclerView.Adapter<Zheg1Adapter.ViewHolder> {
    private Context context;
    private List<ZhengBean.ResultBean> list;

    public Zheg1Adapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<ZhengBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Zheg1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_more_movies,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Zheg1Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.img.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.name.setText(list.get(i).getName()+"");
        viewHolder.title.setText(list.get(i).getSummary()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick5.SetClick5(list.get(i).getId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name,title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            title=itemView.findViewById(R.id.title);
        }
    }

    public SetOnClick5 setOnClick5;

    public void SetOnItemClick5(SetOnClick5 setOnClick5) {
        this.setOnClick5 = setOnClick5;
    }

    public interface SetOnClick5{
        void SetClick5(String cid);
    }
}
