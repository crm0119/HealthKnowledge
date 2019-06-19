package cn.edu.gdpt.healthknowledge;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class NewsviewActivity extends AppCompatActivity {
    private WebView webView;
    private NewsBean bean;
    private String url;
    private Toolbar toolbar;
    private String title,name,img;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsview);

        webView=findViewById(R.id.webview);
        bean=(NewsBean) getIntent().getSerializableExtra("bean");
        url=bean.url;
        title=bean.title;
        name=bean.name;
        img=bean.image;
        toolbar=findViewById(R.id.news_toobar);
        toolbar.setTitle(name);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initWeb();

    }

    private void initWeb() {
        webView.loadUrl(url);
        WebSettings mWebSettings = webView.getSettings();
        mWebSettings.setSupportZoom(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("GBK");//设置解码格式
        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setJavaScriptEnabled(true);//支持js 特效
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }

}
