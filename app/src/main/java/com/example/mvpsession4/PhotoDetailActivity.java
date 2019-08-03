package com.example.mvpsession4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PhotoDetailActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        mImageView = findViewById(R.id.imgBigPhoto);
        mTextView = findViewById(R.id.tvPhotoTitle);
        final TextView tvMore = findViewById(R.id.tvMore);


        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity.KEY_URL);
        String title = intent.getStringExtra(MainActivity.KEY_TITLE);

        Glide.with(this).load(url).into(mImageView);
        mTextView.setText(title);

        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setEllipsize(null);
                mTextView.setMaxLines(Integer.MAX_VALUE);
                tvMore.setVisibility(View.GONE);
            }
        });
    }
}
