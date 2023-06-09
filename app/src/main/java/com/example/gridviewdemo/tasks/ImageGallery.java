package com.example.gridviewdemo.tasks;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

import java.util.ArrayList;

public class ImageGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);

        ArrayList<Dog> myDogs = new ArrayList<>();
        myDogs.add(new Dog(R.drawable.curious, "Curious one"));
        myDogs.add(new Dog(R.drawable.happy, "Happy one"));
        myDogs.add(new Dog(R.drawable.happy2, "Another Happy one"));
        myDogs.add(new Dog(R.drawable.posy, "Posy one"));
        myDogs.add(new Dog(R.drawable.running, "One that's always running."));

        ImageGalleryAdapter adapter = new ImageGalleryAdapter(this, myDogs, getSupportFragmentManager());
        GridView gridView = findViewById(R.id.dogGalleryView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            int imagePath = myDogs.get(i).getImage();
            Toast.makeText(getApplicationContext(), imagePath, Toast.LENGTH_SHORT).show();
        });
    }
}