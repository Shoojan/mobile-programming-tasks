package com.example.gridviewdemo.tasks.imagegallery;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gridviewdemo.R;

import java.util.ArrayList;

public class ImageGalleryRecyclerAdapter extends RecyclerView.Adapter<ImageGalleryRecyclerAdapter.DogViewHolder> {

    private final Activity context;
    private final ArrayList<Dog> dogList;

    private final FragmentManager manager;

    public ImageGalleryRecyclerAdapter(Activity context, ArrayList<Dog> dogList, FragmentManager manager) {
        this.context = context;
        this.dogList = dogList;
        this.manager = manager;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.image_gallery_single_component, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        Dog myDog = dogList.get(position);
        holder.getImageView().setImageResource(myDog.getImage());

        holder.getImageView().setOnClickListener(view -> {
            ImageGalleryDialog imageGalleryDialog = new ImageGalleryDialog(myDog);
            imageGalleryDialog.show(manager, myDog.getTitle());
        });
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.dogImageView);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }


}