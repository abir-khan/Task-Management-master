package com.example.noor.taskmanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewTaskListAdapter extends RecyclerView.Adapter<NewTaskListAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<TaskModel> mData = new ArrayList<>();

    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView taskTitle,taskPriority,taskStatus,esestimatedHour,taskStartDate,taskDueDate;
//        LinearLayout linearLayout;
        public MyViewHolder(View v) {
            super(v);

//            linearLayout = v.findViewById(R.id.layout);
//
            taskTitle = v.findViewById(R.id.tasktitle);
            taskPriority = v.findViewById(R.id.taskPriority);
            taskStatus = v.findViewById(R.id.taskStatus);
            esestimatedHour = v.findViewById(R.id.esestimatedHour);
            taskStartDate = v.findViewById(R.id.taskStartDate);
            taskDueDate = v.findViewById(R.id.taskDueDate);

        }
    }

    public NewTaskListAdapter(Context mContext,ArrayList<TaskModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.single_new_task_list,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {
        holder.taskTitle.setText(mData.get(position).getTaskTitle());
        holder.taskPriority.setText(mData.get(position).getPriority());
        holder.taskStatus.setText(mData.get(position).getStatus());
        holder.esestimatedHour.setText(String.valueOf(mData.get(position).estimatedHour));
//        holder.esestimatedHour.setText(mData.get(position).getEstimatedHour());
        holder.taskStartDate.setText(mData.get(position).getStartDate());
        holder.taskDueDate.setText(mData.get(position).getDueDate());

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentValue = mDataset[position];
//                Log.d("LinearLayout", "Layout Clicked: " + currentValue);
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
