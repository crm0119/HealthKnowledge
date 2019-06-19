package cn.edu.gdpt.healthknowledge;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    private List<Bean.ResultBean.DataBean> DataBean;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FrameLayout frameLayout;
    private NewsRVadapter adapter;
    private int pageCount = 1;
    private List<data> list = new ArrayList<>();
    private HashMap<String, String> category_ID = new HashMap<String, String>();
    private String currentCategory;
    private View FailView;
    private View view;
    private Activity activity;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_news, container, false);
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        
        initRecyclerView();
        initView(view);

        return view;

    }

    private void initRecyclerView() {
    }


    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.health_recycler_view);
        progressBar = (ProgressBar) view.findViewById(R.id.health_progress_bar);
        frameLayout = (FrameLayout) view.findViewById(R.id.health_framelayout);
        //health_bottom_view = (RelativeLayout) view.findViewById(R.id.health_bottom_view);



    }



}
