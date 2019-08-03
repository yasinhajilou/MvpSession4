package com.example.mvpsession4.model;

import com.example.mvpsession4.ResponseCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {

    private static PhotoRepository sRepository;
    private PhotoApi  mApi;

    public static PhotoRepository getInstance(){
        if (sRepository == null){
            sRepository = new PhotoRepository();
        }
        return sRepository;
    }

    private PhotoRepository() {
      mApi = RetrofitInstance.getRetrofit().create(PhotoApi.class);
    }

    public void requestPhotos(final ResponseCallBack<List<Photo>> callBack){
        Call<List<Photo>> call = mApi.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.body()!=null){
                    callBack.onSuccess(response.body());
                }else {
                    callBack.onError("Body is Null");
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                callBack.onError("In on Failure: "+ t.getMessage());
            }
        });
    }
}
