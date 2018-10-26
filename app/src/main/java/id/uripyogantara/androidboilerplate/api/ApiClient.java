package id.uripyogantara.androidboilerplate.api;

import android.content.Context;

import java.io.IOException;

import id.uripyogantara.androidboilerplate.utils.Constant;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static ApiService getService(Context context){

        OkHttpClient client=new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request=chain.request()
                        .newBuilder()
                        .addHeader("Content-Type","application/json")
                        .addHeader("Authorization","Bearer ")
                        .build();

                    return chain.proceed(request);
                }
            }).build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constant.URL.api())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(ApiService.class);
    }
}
