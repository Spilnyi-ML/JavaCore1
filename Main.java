package homeWorkLesson6;

import okhttp3.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/295212")
                .addQueryParameter("apikey", "E6Ufpt2OrzI6v0BtEnUEx0xGw7RIydZn")
                .addQueryParameter("metric", "true")
                .addQueryParameter("language","ru")
                .build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.isSuccessful());
        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}
