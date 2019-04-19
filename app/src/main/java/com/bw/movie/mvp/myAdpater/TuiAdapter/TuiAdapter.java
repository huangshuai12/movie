package com.bw.movie.mvp.myAdpater.TuiAdapter;

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
import com.bw.movie.entity.TuiBean;

import java.util.ArrayList;
import java.util.List;

public class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.ViewHolder> {
    private Context context;
    private List<TuiBean.ResultBean> list;

    public TuiAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<TuiBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TuiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.model_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TuiAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.image_model.setImageURI(Uri.parse(list.get(i).getLogo()));
        viewHolder.title_model.setText(list.get(i).getName()+"");
        viewHolder.name_model.setText(list.get(i).getAddress()+"");
        viewHolder.price_model.setText(list.get(i).getFollowCinema()+"");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickTui.ClickTui(list.get(i).getId()+"");
            }
        });



        final int followCinema = list.get(i).getFollowCinema();
        Log.e("followCinema",followCinema+"");
        if (followCinema==1){
            viewHolder.mXiangCheckbox.setChecked(true);
        }else{
            viewHolder.mXiangCheckbox.setChecked(false);
        }
        viewHolder.mXiangCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    viewHolder.mXiangCheckbox.setChecked(true);
                    onclicklisnter.click(list.get(i).getId()+"",1);
                }else {
                    viewHolder.mXiangCheckbox.setChecked(false);
                    onclicklisnter.click(list.get(i).getId()+"",2);
                }
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
        void ClickTui(String cid);
    }



    private onclicklisnter onclicklisnter;

    public void setOnclicklisnter(TuiAdapter.onclicklisnter onclicklisnter) {
        this.onclicklisnter = onclicklisnter;
    }

    public interface onclicklisnter{
        void click(String cid,int bb);
    }


/*
    public TuiAdapter.OnListener onListener;

    public interface OnListener {
        void nnn(Map<String,String> map);
    }

    public void getonLis(OnListener onListener) {
        this.onListener = onListener;
    }*/
}
