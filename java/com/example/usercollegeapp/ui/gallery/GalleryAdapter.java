package com.example.usercollegeapp.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usercollegeapp.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.CalleryViewAdapter> {

    private Context context;
    private List<String> images;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public CalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_images,parent,false);
        return new CalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalleryViewAdapter holder, int position) {

        Glide.with(context).load(images.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CalleryViewAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CalleryViewAdapter(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
