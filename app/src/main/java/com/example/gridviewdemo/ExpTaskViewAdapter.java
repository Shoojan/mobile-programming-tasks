package com.example.gridviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gridviewdemo.tasks.LoginForm;
import com.example.gridviewdemo.tasks.PhoneDialer;
import com.example.gridviewdemo.tasks.SecretMessageReceiver;
import com.example.gridviewdemo.tasks.SimpleCalculator;
import com.example.gridviewdemo.tasks.SimpleInterest;
import com.example.gridviewdemo.tasks.StudentInfo;
import com.example.gridviewdemo.tasks.StudentTable;
import com.example.gridviewdemo.tasks.VisitingCard;
import com.example.gridviewdemo.tasks.area.AreaCalculator;
import com.example.gridviewdemo.tasks.contact.ContactApp;
import com.example.gridviewdemo.tasks.fragments.NewsPortalDesign;
import com.example.gridviewdemo.tasks.imagegallery.ImageGallery;
import com.example.gridviewdemo.tasks.imagegallery.ImageGalleryUsingRecyclerView;

public class ExpTaskViewAdapter extends RecyclerView.Adapter<ExpTaskViewAdapter.MyViewHolder> {

    private final TaskConstants[] tasks;
    private final Activity context;

    public ExpTaskViewAdapter(Activity context, TaskConstants[] tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ExpTaskViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View recyclerItemView = layoutInflater.inflate(R.layout.recycler_item, parent, false);

        return new MyViewHolder(recyclerItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpTaskViewAdapter.MyViewHolder holder, int position) {
        TaskConstants currentTask = tasks[position];
        holder.getSerialNumber().setText(String.format("%d.", position + 1));
        holder.getTaskItem().setText(currentTask.label);

        holder.getRecyclerListLayout().setOnClickListener(view -> {
            switch (currentTask) {
                case LOGIN_FORM:
                    this.startActivity(context, LoginForm.class);
                    break;
                case VISITING_CARD:
                    this.startActivity(context, VisitingCard.class);
                    break;
                case STUDENT_TABLE:
                    this.startActivity(context, StudentTable.class);
                    break;
                case CALCULATOR:
                    this.startActivity(context, SimpleCalculator.class);
                    break;
                case STUDENT_INFO:
                    this.startActivity(context, StudentInfo.class);
                    break;
                case SIMPLE_INTEREST:
                    this.startActivity(context, SimpleInterest.class);
                    break;
                case PHONE_DIALER:
                    this.startActivity(context, PhoneDialer.class);
                    break;
                case SECRET_MESSAGE:
                    this.startActivity(context, SecretMessageReceiver.class);
                    break;
                case NEWS_PORTAL:
                    this.startActivity(context, NewsPortalDesign.class);
                    break;
                case AREA_CALCULATOR:
                    this.startActivity(context, AreaCalculator.class);
                    break;
                case IMAGE_GALLERY:
                    this.startActivity(context, ImageGallery.class);
                    break;
                case IMAGE_GALLERY_RECYCLER:
                    this.startActivity(context, ImageGalleryUsingRecyclerView.class);
                    break;
                case CONTACT_APP:
                    this.startActivity(context, ContactApp.class);
                    break;
            }
        });
    }

    private void startActivity(Activity context, Class<?> className) {
        context.startActivity(new Intent(context, className));
    }

    @Override
    public int getItemCount() {
        return this.tasks.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ConstraintLayout recyclerListLayout;
        private final TextView serialNumber, taskItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.recyclerListLayout = itemView.findViewById(R.id.recyclerListLayout);
            this.serialNumber = itemView.findViewById(R.id.serialNumber);
            this.taskItem = itemView.findViewById(R.id.taskItem);
        }

        public ConstraintLayout getRecyclerListLayout() {
            return recyclerListLayout;
        }

        public TextView getSerialNumber() {
            return serialNumber;
        }

        public TextView getTaskItem() {
            return taskItem;
        }
    }

}
