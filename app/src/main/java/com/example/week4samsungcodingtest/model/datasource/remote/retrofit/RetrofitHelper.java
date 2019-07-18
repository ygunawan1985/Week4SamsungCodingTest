package com.example.week4samsungcodingtest.model.datasource.remote.retrofit;

import com.example.week4samsungcodingtest.model.datasource.remote.okhttp3.OkHttpHelper;
import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.week4samsungcodingtest.model.datasource.remote.retrofit.UrlConstants.BASE_URL;

public class RetrofitHelper {

    static List<PhotoResponse> photoResponseList;

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHelper.getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public PhotoService getService() {
        return getRetrofitInstance().create(PhotoService.class);
    }

    public PhotoObservableService getObservableService() {
        return getRetrofitInstance().create(PhotoObservableService.class);
    }

//    public WeatherResponse getSyncWeatherResponse(final int zip, final String APPID) throws Exception {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Response response = getService().getWeatherResponse(String.valueOf(zip), APPID).execute();
//                    weatherResponse = (WeatherResponse) response.body();
//                    Log.d("TAG_RETROFIT", weatherResponse.getName());
//                    Log.d("TAG_RETROFIT", String.valueOf(weatherResponse.getMain().getTemp()));
//                    Log.d("TAG_RETROFIT", String.valueOf(weatherResponse.getMain().getTempMax()));
//                    Log.d("TAG_RETROFIT", String.valueOf(weatherResponse.getMain().getTempMin()));
//                    Log.d("TAG_RETROFIT", String.valueOf(weatherResponse.getMain().getHumidity()));
//                } catch (IOException e) {
//
//                }
//            }
//        });
//        thread.start();
//        return weatherResponse;
//    }
//
//    public void getAsyncWeatherResponse(int zip, String APPID) {
//        RetrofitHelper retrofitHelper = new RetrofitHelper();
//        retrofitHelper.getService().getWeatherResponse(String.valueOf(zip), APPID).enqueue(new Callback<WeatherResponse>() {
//            @Override
//            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
//                String temp = String.valueOf(response.body().getMain().getTemp());
//                Log.d("TAG_ASYNC_RETRO", temp);
//            }
//
//            @Override
//            public void onFailure(Call<WeatherResponse> call, Throwable t) {
//
//            }
//        });
//    }

}
