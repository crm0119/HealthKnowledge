package cn.edu.gdpt.healthknowledge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mAppBarMy;
    private ImageButton app_bar_openDrawer;
    private DrawerLayout mDrawerLayout;
    private TextView app_bar_text;
    private ViewPager mainViewPager;
    private RadioGroup radioGroup;
    private List<Fragment> alFragment=new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
        initListener();
    }

    private void initListener() {
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                switch (i){
                    case 0:
                        radioGroup.check(R.id.rb_home);
                        app_bar_text.setText("首页");
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_news);
                        app_bar_text.setText("资讯");
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_knowledge);
                        app_bar_text.setText("健康");
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_me);
                        app_bar_text.setText("我");
                        break;
                }

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rb_home:
                        mainViewPager.setCurrentItem(0,false);break;
                    case R.id.rb_news:
                        mainViewPager.setCurrentItem(1,false);break;
                    case R.id.rb_knowledge:
                        mainViewPager.setCurrentItem(2,false);break;
                    case R.id.rb_me:
                        mainViewPager.setCurrentItem(3,false);break;
                }
            }
        });
    }

    private void initViewPager(){
        alFragment.add(new HomeFragment());
        alFragment.add(new NewsFragment());
        alFragment.add(new KnowledgeFragment());
        alFragment.add(new MeFragment());
        mainViewPager.setOffscreenPageLimit(3);
        mainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return alFragment.get(i);
            }

            @Override
            public int getCount() {
                return alFragment.size();
            }
        });
        mainViewPager.setCurrentItem(0);
    }

    private void initView() {
        mAppBarMy = (ImageButton) findViewById(R.id.app_bar_my);
        mAppBarMy.setOnClickListener(this);
        app_bar_openDrawer = (ImageButton) findViewById(R.id.app_bar_openDrawer);
        app_bar_openDrawer.setOnClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setOnClickListener(this);
        app_bar_text=(TextView)findViewById(R.id.app_bar_text);
        app_bar_text.setOnClickListener(this);
        mainViewPager=(ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setOnClickListener(this);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_bar_my:
                Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_openDrawer:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
