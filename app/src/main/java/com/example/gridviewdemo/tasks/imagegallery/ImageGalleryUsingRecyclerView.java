package com.example.gridviewdemo.tasks.imagegallery;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gridviewdemo.R;

import java.util.ArrayList;

public class ImageGalleryUsingRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery_using_recycler);

        ArrayList<Dog> myDogs = new ArrayList<>();
        myDogs.add(new Dog(R.drawable.curious, "Curious one"));
        myDogs.add(new Dog(R.drawable.happy, "Happy one"));
        myDogs.add(new Dog(R.drawable.happy2, "Another Happy one"));
        myDogs.add(new Dog(R.drawable.posy, "Posy one"));
        myDogs.add(new Dog(R.drawable.running, "One that's always running."));

        RecyclerView recyclerView = findViewById(R.id.dogGalleryView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ImageGalleryRecyclerAdapter adapter = new ImageGalleryRecyclerAdapter(this, myDogs, getSupportFragmentManager());
        recyclerView.setAdapter(adapter);
    }
}