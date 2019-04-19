package com.bw.movie.fragment.modelfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.entity.FuBean;
import com.bw.movie.mvp.contract.MiddleContract;
import com.bw.movie.mvp.myAdpater.TuiAdapter.FuAdapter;
import com.bw.movie.mvp.presenter.Middlepresenter;
import com.bw.movie.mvp.view.MovieActivity;
import com.bw.movie.net.SpUtils;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ModelTwo extends Fragment implements MiddleContract.ModdileView,FuAdapter.SetOnClickJi{
    @BindView(R.id.model_rec2)
    RecyclerView modelRec2;
    Unbinder unbinder;
    private Middlepresenter middlepresenter;
    private FuAdapter fuAdapter;
    private SpUtils spUtils;
    private String longitude;
    private String latitude;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.modeltwofragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        middlepresenter = new Middlepresenter(this);
        fuAdapter = new FuAdapter(getActivity());
        modelRec2.setLayoutManager(new LinearLayoutManager(getActivity()));
      /*  longitude = (String)spUtils.getData("longitude", null);
        latitude = (String)spUtils.getData("latitude", null);*/
        HashMap<String,String> map = new HashMap<>();
        map.put("page",1+"");
        map.put("count",10+"");
        map.put("longitude", 116.30551391385724 +"");
        map.put("latitude", 40.04571807462411 +"");
        middlepresenter.getFu(map);
        return view;
    }

    @Override
    public void SuccessTui(Object result) {

    }

    @Override
    public void SuccessFu(Object result) {
        FuBean fuBean=(FuBean) result;
        List<FuBean.ResultBean> result1 = fuBean.getResult();
        modelRec2.setAdapter(fuAdapter);
        fuAdapter.SetOnItemClickJi(this);
        fuAdapter.setList(result1);


    }

    @Override
    public void SuccessGuan(Object result) {

    }

    @Override
    public void SuccessQu(Object result) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ClickJi(String cid) {
        Intent intent = new Intent(getActivity(), MovieActivity.class);
        intent.putExtra("id",cid);
        startActivity(intent);
    }
}
