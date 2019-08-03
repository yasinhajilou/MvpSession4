package com.example.mvpsession4.Adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvpsession4.R;
import com.example.mvpsession4.RecyclerOnItemClick;
import com.example.mvpsession4.model.Photo;

import java.util.List;

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.PhotoViewHolder> {

    List<Photo> mPhotos;
    RecyclerOnItemClick mOnItemClick;

    public PhotoRecyclerAdapter(RecyclerOnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public void setData(List<Photo> photos){
        mPhotos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photos , parent , false);
        return new PhotoViewHolder(view , mOnItemClick , mPhotos);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.onBind(mPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotos != null ? mPhotos.size() : 0;
    }

     class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;
        ImageView mImageView;
        RecyclerOnItemClick mOnItemClick;
        List<Photo> mPhotos;
         PhotoViewHolder(@NonNull View itemView , RecyclerOnItemClick itemClick , List<Photo> photos) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.txtRvTitle);
            mImageView = itemView.findViewById(R.id.imgRvPhoto);
            mOnItemClick = itemClick;
            itemView.setOnClickListener(this);
            mPhotos = photos;

        }

        void onBind(Photo photo){
             mTextView.setText(photo.getTitle());
            Glide.with(mImageView.getContext()).load(photo.getThumbnailUrl()).into(mImageView);
        }

         @Override
         public void onClick(View view) {
             mOnItemClick.clicked(mPhotos.get(getAdapterPosition()));
         }
     }
}
