package cn.edu.gdpt.healthknowledge;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class news5 extends Fragment {
    private OkHttpClient okHttpClient;
    private RecyclerView recyclerView;
    private MyRvadapter myRvadapter;
    private List<NewsBean> newsBeans=new ArrayList<>();


    public news5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_news5, container, false);
        okHttpClient = new OkHttpClient();
        getData();
        recyclerView=view.findViewById(R.id.news5_vp);
        return view;
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Constans constans=new Constans();
                Request request = new Request.Builder().url(constans.WEB_TOP+constans.WEB_tiyu).build();
                Call call = okHttpClient.newCall(request);
                //开启异步线程访问网络
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Response response) throws IOException {
                        final String res = response.body().string();

                        NewsBean bean = new Gson().fromJson(res, NewsBean.class);
                        try {
                            JSONObject jsonObject = new JSONObject(res);
                            JSONObject jsonObject1 = jsonObject.optJSONObject("result");
                            JSONArray data = jsonObject1.optJSONArray("data");
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject2 = data.optJSONObject(i);
                                String title = jsonObject2.optString("title");
                                String author_name = jsonObject2.optString("author_name");
                                String thumbnail_pic_s = jsonObject2.optString("thumbnail_pic_s");
                                String url = jsonObject2.optString("url");
                                newsBeans.add(new NewsBean(title,author_name,thumbnail_pic_s,url));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        newsBeans.add(bean);

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myRvadapter = new MyRvadapter(getActivity(),newsBeans);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(myRvadapter);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Request arg0, IOException arg1) {
                    }
                });
            }
        }).start();
    }

}
