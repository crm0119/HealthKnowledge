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
        View view=inflater.inflate(R.layout.fragment_knowledge,container,false);
        bmb=(BoomMenuButton)view.findViewById(R.id.bmb);
        assert bmb != null;

        bmb.setButtonEnum(ButtonEnum.TextInsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);

        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
        for (int i=0;i<bmb.getPiecePlaceEnum().pieceNumber();i++){
            addBuilder();
        }
        webView = (WebView)view.findViewById(R.id.webview);
        //HealthRVadapter healthRVadapter=new HealthRVadapter(getActivity(),KnowledgeBean);
        // webView.setAdapter(healthRVadapter);
        return view;

    }
    private void addBuilder(){


        bmb.addBuilder(new TextInsideCircleButton.Builder()

                .normalImageRes(BuilderManager.getImageResource())
                .normalTextRes(BuilderManager.getTextResource())
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        switch (index){
                            case 0:
                                Uri uri = Uri.parse("http://www.baidu.com");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                //webView = (WebView) findViewById(R.id.webView);
                                //webView.loadUrl("http://baidu.com");
                                break;


                        }
                    }
                }));
    }


}
