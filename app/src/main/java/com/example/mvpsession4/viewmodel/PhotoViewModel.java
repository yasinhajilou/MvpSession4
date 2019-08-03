package com.example.mvpsession4.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvpsession4.ResponseCallBack;
import com.example.mvpsession4.model.Photo;
import com.example.mvpsession4.model.PhotoRepository;

import java.util.List;

public class PhotoViewModel extends AndroidViewModel {

    private MutableLiveData<List<Photo>> mData;
    private MutableLiveData<String> mErrorData;
    private PhotoRepository mRepository;

    public PhotoViewModel(@NonNull Application application) {
        super(application);
        mData = new MutableLiveData<>();
        mErrorData = new MutableLiveData<>();
        mRepository = PhotoRepository.getInstance();

    }

    public void requestPhotos(){
        mRepository.requestPhotos(new ResponseCallBack<List<Photo>>() {
            @Override
            public void onSuccess(List<Photo> data) {
                mData.setValue(data);
            }

            @Override
            public void onError(String msg) {
                mErrorData.setValue(msg);
            }
        });
    }

    public LiveData<List<Photo>> getPhotos(){
        return mData;
    }

    public LiveData<String> getError(){
        return mErrorData;
    }


}
