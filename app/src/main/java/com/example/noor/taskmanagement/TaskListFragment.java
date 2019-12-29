package com.example.noor.taskmanagement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class TaskListFragment extends Fragment {

    private ArrayList<TaskModel> taskModelList;
    private TaskModel taskModel;

    RecyclerView recyclerView;

    public final int offset = 30;
    private int page = 0;

    private NewTaskListAdapter newTaskListAdapter;



    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView = rootView.findViewById(R.id.newTaskListRV);
        NewTaskListAdapter newTaskListAdapter = new NewTaskListAdapter(getContext(),taskModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newTaskListAdapter);
        return rootView;

//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        newTaskListAdapter = new NewTaskListAdapter(getContext(),null);
//        listView = rootView.findViewById(R.id.newTaskListRV);
//        listView.setLayoutManager(mLayoutManager);
//        listView.setAdapter(newTaskListAdapter);
//        listView.setHasFixedSize(true);
//
//
//        listView.setAdapter(newTaskListAdapter);
//
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        listView.setLayoutManager(llm);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        taskModelList = new ArrayList<>();
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));
        taskModelList.add(new TaskModel("Software Development","High","In Progress","15-Oct-18","15-Oct-18","50"));


    }



}
