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
import com.bw.movie.entity.LunBean;
import com.bw.movie.mvp.contract.LunContract;
import com.bw.movie.mvp.myAdpater.Shou.Ren1Adapter;
import com.bw.movie.mvp.presenter.Lunpresenter;
import com.bw.movie.mvp.view.XiangtActivity;

import java.util.HashMap;
import java.util.List;

public class TopOneFragment extends Fragment implements LunContract.LlunView,Ren1Adapter.SetOnClick4{
    private RecyclerView xrecTop1;
    private Lunpresenter lunpresenter;
    private Ren1Adapter ren1Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_one, container, false);
        xrecTop1 =view.findViewById(R.id.xrec_top1);
        lunpresenter = new Lunpresenter(this);
        xrecTop1.setLayoutManager(new LinearLayoutManager(getActivity()));
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("page", 1 + "");
        map2.put("count", 10 + "");
       lunpresenter.getRen(map2);
        return view;
    }

    @Override
    public void SuccessLun(Object result) {

    }

    @Override
    public void SuccessRen(Object result) {
        LunBean lunBean = (LunBean) result;
        List<LunBean.ResultBean> result1 = lunBean.getResult();
        ren1Adapter = new Ren1Adapter(getActivity());
        ren1Adapter.setList(result1);
        ren1Adapter.SetOnItemClick4(this);
        xrecTop1.setAdapter(ren1Adapter);
    }

    @Override
    public void SuccessZheng(Object result) {

    }

    @Override
    public void SuccessJi(Object result) {

    }

    @Override
    public void SetClick4(String cid) {

       Intent intent = new Intent(getActivity(), XiangtActivity.class);
        intent.putExtra("id",cid);
        startActivity(intent);
    }
}
