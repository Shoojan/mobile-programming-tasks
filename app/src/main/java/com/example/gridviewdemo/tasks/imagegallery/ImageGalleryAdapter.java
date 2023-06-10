package com.example.gridviewdemo.tasks.imagegallery;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.gridviewdemo.R;

import java.util.ArrayList;

public class ImageGalleryAdapter extends ArrayAdapter<Dog> {

    private final Activity context;
    private final ArrayList<Dog> dogList;

    private final FragmentManager manager;

    public ImageGalleryAdapter(Activity context, ArrayList<Dog> dogList, FragmentManager manager) {
        super(context, R.layout.image_gallery_single_component, dogList);
        this.context = context;
        this.dogList = dogList;
        this.manager = manager;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View gridView = inflater.inflate(R.layout.image_gallery_single_component, null, true);

        //Wiring widgets
        ImageView imageView = gridView.findViewById(R.id.dogImageView);
        Dog myDog = dogList.get(position);
        imageView.setImageResource(myDog.getImage());

        imageView.setOnClickListener(view -> {
            ImageGalleryDialog imageGalleryDialog = new ImageGalleryDialog(myDog);
            imageGalleryDialog.show(manager, myDog.getTitle());
        });

        return gridView;
    }
}