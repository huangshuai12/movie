package com.bw.movie.mvp.myAdpater.popwindow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.XiangBean;


public class Deatails_Boss_Adapter extends RecyclerView.Adapter<Deatails_Boss_Adapter.ViewHodler> {
    Context context;
    XiangBean.ResultBean list;

    public Deatails_Boss_Adapter(Context context, XiangBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.ofing,null);
        ViewHodler hodler=new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        String[] split = list.getStarring().split(",");
        viewHodler.textView1.setText(split[i]);
    }

    @Override
    public int getItemCount() {
        return list.getStarring().split(",").length;
    }
    public class ViewHodler extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.yan);
            textView2=itemView.findViewById(R.id.shi);
        }
    }
}
