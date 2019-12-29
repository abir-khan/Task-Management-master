package com.example.noor.taskmanagement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TaskListViewHolder extends RecyclerView.ViewHolder {

    String title,priority,status,esestimatedHour,startDate,dueDate;

    TextView titleTV,priorityTV,statusTV,estimateHourTV,startDateTV,dueDateTV;

    Context context;

    public TaskListViewHolder(final View itemView){
        super(itemView);

        context = itemView.getContext();

        titleTV = itemView.findViewById(R.id.tasktitle);
        priorityTV = itemView.findViewById(R.id.taskPriority);
        statusTV = itemView.findViewById(R.id.taskStatus);
        estimateHourTV = itemView.findViewById(R.id.esestimatedHour);
        startDateTV = itemView.findViewById(R.id.taskStartDate);
        dueDateTV = itemView.findViewById(R.id.taskDueDate);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
