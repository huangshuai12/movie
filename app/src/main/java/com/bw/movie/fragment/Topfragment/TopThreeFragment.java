package com.bw.movie.fragment.Topfragment;

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
import com.bw.movie.entity.JiBean;
import com.bw.movie.mvp.contract.LunContract;
import com.bw.movie.mvp.myAdpater.Shou.Ji1Adapter;
import com.bw.movie.mvp.presenter.Lunpresenter;
import com.bw.movie.mvp.view.XiangtActivity;

import java.util.HashMap;
import java.util.List;

public class TopThreeFragment extends Fragment implements LunContract.LlunView,Ji1Adapter.SetOnClick3{
    private RecyclerView xrecTop3;
    private Lunpresenter lunpresenter;
    private Ji1Adapter ji1Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_three, container, false);
        xrecTop3 =view.findViewById(R.id.xrec_top3);
        lunpresenter = new Lunpresenter(this);
        xrecTop3.setLayoutManager(new LinearLayoutManager(getActivity()));
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("page", 1 + "");
        map2.put("count", 10 + "");
        lunpresenter.getJi(map2);
        return view;
    }

    @Override
    public void SuccessLun(Object result) {

    }

    @Override
    public void SuccessRen(Object result) {

    }

    @Override
    public void SuccessZheng(Object result) {

    }

    @Override
    public void SuccessJi(Object result) {
        JiBean jiBean = (JiBean) result;
        List<JiBean.ResultBean> result1 = jiBean.getResult();
        ji1Adapter = new Ji1Adapter(getActivity());
        ji1Adapter.setList(result1);
        ji1Adapter.SetOnItemClick3(this);
        xrecTop3.setAdapter(ji1Adapter);
    }

    @Override
    public void SetClick3(String cid) {
        Intent intent = new Intent(getActivity(), XiangtActivity.class);
        intent.putExtra("id",cid);
        startActivity(intent);
    }
}
