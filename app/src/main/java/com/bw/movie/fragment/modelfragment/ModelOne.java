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
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.entity.TuiBean;

import com.bw.movie.mvp.contract.MiddleContract;
import com.bw.movie.mvp.myAdpater.TuiAdapter.TuiAdapter;
import com.bw.movie.mvp.presenter.Middlepresenter;
import com.bw.movie.mvp.view.MovieActivity;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ModelOne extends Fragment implements MiddleContract.ModdileView,TuiAdapter.SetOnClickTui,TuiAdapter.onclicklisnter{

    @BindView(R.id.model_rec1)
    RecyclerView modelRec1;
    Unbinder unbinder;
    private Middlepresenter middlepresenter;
    private TuiAdapter tuiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.modelonefragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        middlepresenter = new Middlepresenter(this);
        tuiAdapter = new TuiAdapter(getActivity());
        modelRec1.setLayoutManager(new LinearLayoutManager(getActivity()));
        HashMap<String,String> map = new HashMap<>();
        map.put("page",1+"");
        map.put("count",10+"");
        tuiAdapter.setOnclicklisnter(this);
        middlepresenter.getTui(map);
        return view;
    }

    @Override
    public void SuccessTui(Object result) {
        TuiBean tuiBean=(TuiBean) result;
        List<TuiBean.ResultBean> result1 = tuiBean.getResult();
        modelRec1.setAdapter(tuiAdapter);
        tuiAdapter.setList(result1);
        tuiAdapter.SetOnItemClickTui(this);
    }

    @Override
    public void SuccessFu(Object result) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ClickTui(String cid) {
        Intent intent = new Intent(getActivity(), MovieActivity.class);
        intent.putExtra("id",cid);
        startActivity(intent);
    }

    @Override
    public void SuccessGuan(Object result) {
        TuiBean tuiBean=(TuiBean) result;
        if (tuiBean.getStatus().equals("0000")){
            Toast.makeText(getActivity(), ""+tuiBean.getMessage(), Toast.LENGTH_SHORT).show();
//            tuijianPresenter.getKeyorNum(1+"",10+"");
//            不能重复关注返回1001
        }else if (tuiBean.getStatus().equals("1001")){
            Toast.makeText(getActivity(), ""+tuiBean.getMessage(), Toast.LENGTH_SHORT).show();
//            tuijianPresenter.getKeyorNum(1+"",10+"");
        }
    }

    @Override
    public void SuccessQu(Object result) {
        TuiBean tuiBean=(TuiBean) result;
        if (tuiBean.getStatus().equals("0000")){
            Toast.makeText(getActivity(), ""+tuiBean.getMessage(), Toast.LENGTH_SHORT).show();
//            tuijianPresenter.getKeyorNum(1+"",10+"");
//            不能重复取消返回1001
        }else if (tuiBean.getStatus().equals("1001")){
            Toast.makeText(getActivity(), ""+tuiBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void click(String cid, int bb) {
        if (bb==1) {
            HashMap<String,String> map =new HashMap<>();
            map.put("movieId",cid+"");
            middlepresenter.getGuan(map);
        }else {
            HashMap<String,String> map =new HashMap<>();
            map.put("movieId",cid+"");
            middlepresenter.getQu(map);

        }
    }
}
