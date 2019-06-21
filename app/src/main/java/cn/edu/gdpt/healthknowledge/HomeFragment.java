package cn.edu.gdpt.healthknowledge;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import github.ishaan.buttonprogressbar.ButtonProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Activity activity;
    private ViewGroup viewGroup;
    private EditText edt;
    private TextView jumpTextView;
    private Button btn;

    private RecyclerView recyclerView;
    private List<HomeBean.ResultBean.ListBean> listBeans;
    private Gson gson=new Gson();
    private TextView item_tv_content;
    private Layout itemlist;

    private JumpingBeans jumpingBeans;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);


        initView(viewGroup);

        //jumpTextView = (TextView) viewGroup.findViewById(R.id.tv_jump);
       // jumpingBeans = JumpingBeans
         //       .with(jumpTextView)
         //       .makeTextJump(0, jumpTextView.getText().toString().indexOf(' '))
         //       .setIsWave(true)
          //      .setLoopDuration(800) // ms
           //     .build();


        viewGroup.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "button", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if(!TextUtils.isEmpty(edt.getText().toString().trim())){
                                final String sync_get = HttpUtils.Sync_Get(edt.getText().toString().trim());
                                HomeBean bean=gson.fromJson(sync_get,HomeBean.class);
                                listBeans=bean.getResult().getList();
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Toast.makeText(activity, sync_get, Toast.LENGTH_SHORT).show();
                                        HealthRVadapter healthRVadapter=new HealthRVadapter(getActivity(),listBeans);
                                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                        recyclerView.setLayoutManager(linearLayoutManager);
                                        recyclerView.setAdapter(healthRVadapter);

                                    }
                                });
                            }else {
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(activity, "输入不能为空", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        final ButtonProgressBar bar = (ButtonProgressBar)viewGroup.findViewById(R.id.btn);
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.startLoader();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bar.stopLoader();
                    }
                }, 2000);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(edt.getText().toString().trim())){
                                final String sync_get = HttpUtils.Sync_Get(edt.getText().toString().trim());
                                HomeBean bean=gson.fromJson(sync_get,HomeBean.class);
                                listBeans=bean.getResult().getList();
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Toast.makeText(activity, sync_get, Toast.LENGTH_SHORT).show();
                                        HealthRVadapter healthRVadapter=new HealthRVadapter(getActivity(),listBeans);
                                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                        recyclerView.setLayoutManager(linearLayoutManager);
                                        recyclerView.setAdapter(healthRVadapter);

                                    }
                                });
                            }else {
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(activity, "输入不能为空", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }




                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        return viewGroup;
    }

    private void initView(View viewGroup) {
        edt = (EditText) viewGroup.findViewById(R.id.edt);
        recyclerView=(RecyclerView) viewGroup.findViewById(R.id.health_recycler_view);
        item_tv_content=(TextView)viewGroup.findViewById(R.id.item_tv_content);
        //jumpTextView=(TextView)viewGroup.findViewById(R.id.tv_jump);
    }


}
