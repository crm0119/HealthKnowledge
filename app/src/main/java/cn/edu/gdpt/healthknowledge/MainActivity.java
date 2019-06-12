package cn.edu.gdpt.healthknowledge;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mAppBarMy;
    private ImageButton app_bar_openDrawer;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mAppBarMy = (ImageButton) findViewById(R.id.app_bar_my);
        mAppBarMy.setOnClickListener(this);
        app_bar_openDrawer = (ImageButton) findViewById(R.id.app_bar_openDrawer);
        app_bar_openDrawer.setOnClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setOnClickListener(this);
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
