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
import com.bw.movie.entity.ZhengBean;
import com.bw.movie.mvp.contract.LunContract;
import com.bw.movie.mvp.myAdpater.Shou.Zheg1Adapter;
import com.bw.movie.mvp.presenter.Lunpresenter;
import com.bw.movie.mvp.view.XiangtActivity;

import java.util.HashMap;
import java.util.List;

public class TopTwoFragment extends Fragment implements LunContract.LlunView,Zheg1Adapter.SetOnClick5 {
    private RecyclerView xrecTop2;
    private Lunpresenter lunpresenter;
    private Zheg1Adapter zheg1Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_two, container, false);
        xrecTop2 = view.findViewById(R.id.xrec_top2);
        lunpresenter = new Lunpresenter(this);
        xrecTop2.setLayoutManager(new LinearLayoutManager(getActivity()));
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("page", 1 + "");
        map2.put("count", 10 + "");
        lunpresenter.getLZheng(map2);
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
        ZhengBean zhengBean = (ZhengBean) result;
        List<ZhengBean.ResultBean> result1 = zhengBean.getResult();
        zheg1Adapter = new Zheg1Adapter(getActivity());
        zheg1Adapter.setList(result1);
        zheg1Adapter.SetOnItemClick5(this);
        xrecTop2.setAdapter(zheg1Adapter);
    }

    @Override
    public void SuccessJi(Object result) {

    }

    @Override
    public void SetClick5(String cid) {
        Intent intent = new Intent(getActivity(), XiangtActivity.class);
        intent.putExtra("id",cid);
        startActivity(intent);
    }
}
