package com.example.gridviewdemo.tasks.imagegallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.gridviewdemo.R;

public class ImageGalleryDialog extends DialogFragment {

    private final Dog dog;

    public ImageGalleryDialog(Dog dog) {
        this.dog = dog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_gallery_dialog, container, false);

        TextView title = view.findViewById(R.id.dialogTextView);
        ImageView imageView = view.findViewById(R.id.dialogImageView);

        title.setText(dog.getTitle());
        imageView.setImageResource(dog.getImage());
        return view;
    }
}
