package com.example.noor.taskmanagement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TaskApprovalFragment extends Fragment {

    private ArrayList<TaskApprovalModel> taskApprovalList;
    private TaskApprovalModel taskApprovalModel;

    RecyclerView recyclerView;

    TaskApprovalAdapter taskApprovalAdapter;


    public TaskApprovalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = rootView.findViewById(R.id.TaskListApprovalRV);
        TaskApprovalAdapter newTaskListAdapter = new TaskApprovalAdapter(getContext(), taskApprovalList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newTaskListAdapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        taskApprovalList = new ArrayList<>();
        taskApprovalList.add(new TaskApprovalModel("Software Development","Completed"));
        taskApprovalList.add(new TaskApprovalModel("Software Development","In Progress"));
        taskApprovalList.add(new TaskApprovalModel("Software Development","Deferred"));
    }
}
