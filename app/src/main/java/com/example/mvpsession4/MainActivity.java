package com.example.mvpsession4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpsession4.Adapter.PhotoRecyclerAdapter;
import com.example.mvpsession4.model.Photo;
import com.example.mvpsession4.viewmodel.PhotoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerOnItemClick {

    public static String KEY_URL = "key_my_url";
    public static String KEY_TITLE = "key_my_title";

    RecyclerView mRecyclerView;
    PhotoViewModel mViewModel;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(PhotoViewModel.class);
        mRecyclerView = findViewById(R.id.rvPhotoMain);
        mProgressBar = findViewById(R.id.pg);
        FloatingActionButton button = findViewById(R.id.fab);
        final TextView textView = findViewById(R.id.tvErrorMain);
        final LinearLayout layout = findViewById(R.id.myLinear);

        final PhotoRecyclerAdapter adapter = new PhotoRecyclerAdapter(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mViewModel.requestPhotos();


        mViewModel.getPhotos().observe(this, new Observer<List<Photo>>() {

            @Override
            public void onChanged(List<Photo> photos) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                adapter.setData(photos);
            }
        });

        mViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                layout.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                textView.setText(s);
            }
        });
    }

    @Override
    public void clicked(Photo photo) {
        Intent intent = new Intent(MainActivity.this , PhotoDetailActivity.class);
        intent.putExtra(KEY_TITLE , photo.getTitle());
        intent.putExtra(KEY_URL , photo.getUrl());
        startActivity(intent);
    }
}
