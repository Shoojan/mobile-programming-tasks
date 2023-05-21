package com.example.gridviewdemo.tasks.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gridviewdemo.R;

public class NewsDetailFragment extends Fragment {

    private TextView newsTitleTextView, newsDetailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsTitleTextView = (TextView) view.findViewById(R.id.newsTitleTextView);
        newsDetailTextView = (TextView) view.findViewById(R.id.newsDetailsTextView);
    }

    protected void displayReceivedData(String message) {
        if (newsTitleTextView != null) newsTitleTextView.setText(message);
        if (newsDetailTextView != null) newsDetailTextView.setText(message);
    }
}