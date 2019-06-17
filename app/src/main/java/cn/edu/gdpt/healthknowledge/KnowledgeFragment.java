package cn.edu.gdpt.healthknowledge;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;


/**
 * A simple {@link Fragment} subclass.
 */
public class KnowledgeFragment extends Fragment {
    private BoomMenuButton bmb;
    private WebView webView;
    private Context context;


    public KnowledgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_knowledge, container, false);
        View view = inflater.inflate(R.layout.fragment_knowledge, container, false);
        bmb = (BoomMenuButton) view.findViewById(R.id.bmb);
        assert bmb != null;

        bmb.setButtonEnum(ButtonEnum.TextInsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);

        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            addBuilder();
        }
        webView = (WebView) view.findViewById(R.id.webview);
        //HealthRVadapter healthRVadapter=new HealthRVadapter(getActivity(),KnowledgeBean);
        // webView.setAdapter(healthRVadapter);
        return view;

    }

    private void addBuilder() {


        bmb.addBuilder(new TextInsideCircleButton.Builder()

                .normalImageRes(BuilderManager.getImageResource())
                .normalTextRes(BuilderManager.getTextResource())
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        switch (index) {
                            case 0:
                                Intent intent1 = new Intent(getActivity(), ShowActivity.class);
                                intent1.putExtra("URL", "https://baike.baidu.com/item/%E8%90%A5%E5%85%BB%E7%B4%A0");
                                startActivity(intent1);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 1:
                                Intent intent2 = new Intent(getActivity(), ShowActivity.class);
                                intent2.putExtra("URL", "https://jingyan.baidu.com/article/0bc808fc884fe11bd485b90e.html");
                                startActivity(intent2);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 2:
                                Intent intent3 = new Intent(getActivity(), ShowActivity.class);
                                intent3.putExtra("URL", "https://baike.baidu.com/item/%E5%BF%83%E7%90%86%E5%81%A5%E5%BA%B7/5593?fr=aladdin");
                                startActivity(intent3);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 3:
                                Intent intent4 = new Intent(getActivity(), ShowActivity.class);
                                intent4.putExtra("URL", "https://baijiahao.baidu.com/s?id=1571337126264904&wfr=spider&for=pc");
                                startActivity(intent4);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 4:
                                Intent intent5 = new Intent(getActivity(), ShowActivity.class);
                                intent5.putExtra("URL", "http://www.360doc.com/content/18/0603/01/40501103_759213919.shtml");
                                startActivity(intent5);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 5:
                                Intent intent6 = new Intent(getActivity(), ShowActivity.class);
                                intent6.putExtra("URL", "https://baike.baidu.com/item/%E9%A3%9F%E5%93%81%E5%AE%89%E5%85%A8/6173?fr=aladdin");
                                startActivity(intent6);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 6:
                                Intent intent7 = new Intent(getActivity(), ShowActivity.class);
                                intent7.putExtra("URL", "https://baike.baidu.com/item/%E5%81%A5%E5%BA%B7%E9%A5%AE%E9%A3%9F%E4%B9%A0%E6%83%AF/2314752?fr=aladdin");
                                startActivity(intent7);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 7:
                                Intent intent8 = new Intent(getActivity(), ShowActivity.class);
                                intent8.putExtra("URL", "https://baike.baidu.com/item/%E4%BF%9D%E5%81%A5/991482?fr=aladdin");
                                startActivity(intent8);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;
                            case 8:
                                Intent intent9 = new Intent(getActivity(), ShowActivity.class);
                                intent9.putExtra("URL", "https://baike.baidu.com/item/%E8%BF%90%E5%8A%A8/2134938#viewPageContent");
                                startActivity(intent9);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;



                        }
                    }
                }));
    }


}
