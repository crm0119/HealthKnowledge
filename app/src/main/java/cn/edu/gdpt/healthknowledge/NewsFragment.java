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
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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


    //private List<Bean.ResultBean.DataBean> DataBean;
    private TabLayout tabLayout;
    private List<Fragment> fragments;
    private ViewPager viewPager;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_news, container, false);

        //View view = inflater.inflate(R.layout.fragment_news, container, false);

        View rootview=inflater.inflate(R.layout.fragment_news,container,false);
        tabLayout=rootview.findViewById(R.id.news_tab);
        tabLayout.addTab(tabLayout.newTab().setText("头条"));
        tabLayout.addTab(tabLayout.newTab().setText("社会"));
        tabLayout.addTab(tabLayout.newTab().setText("国际"));
        tabLayout.addTab(tabLayout.newTab().setText("娱乐"));
        tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("军事"));
        tabLayout.addTab(tabLayout.newTab().setText("科技"));
        tabLayout.addTab(tabLayout.newTab().setText("财经"));
        tabLayout.addTab(tabLayout.newTab().setText("时尚"));

        fragments=new ArrayList<Fragment>();
        fragments.add(new news1());
        fragments.add(new news2());
        fragments.add(new news3());
        fragments.add(new news4());
        fragments.add(new news5());
        fragments.add(new news6());
        fragments.add(new news7());
        fragments.add(new news8());
        fragments.add(new news9());

        Myadapter myadapter=new Myadapter(getFragmentManager());
        viewPager= rootview.findViewById(R.id.news_vp);
        viewPager.setAdapter(myadapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i <tabLayout.getTabCount() ; i++) {
                    if(tab==tabLayout.getTabAt(i)){
                        viewPager.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return rootview;

    }

    class Myadapter extends FragmentPagerAdapter {

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
