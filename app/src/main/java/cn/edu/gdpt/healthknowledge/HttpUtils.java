package cn.edu.gdpt.healthknowledge;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class HttpUtils {
    private static String Json;

    private static String Home_URL = "http://apicloud.mob.com/appstore/health/search?key=2b609650fe21a&name=";
    private static OkHttpClient okHttpClient = new OkHttpClient();

   public static String Async_Get(String name) {
       Request request = new Request.Builder().url(Home_URL + name).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Json = "Failure";
            }

           @Override
            public void onResponse(Response response) throws IOException {
                Json = response.body().string();
            }
        });

        return Json;
    }

    public static String Sync_Get(String name) throws IOException {
        Request request = new Request.Builder().url(Home_URL + name).build();
        Response response = okHttpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            Json = response.body().string();
        } else {
            Json = "Failure";
        }

        return Json;
    }
}
