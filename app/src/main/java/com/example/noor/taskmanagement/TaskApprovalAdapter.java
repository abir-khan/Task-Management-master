package com.example.noor.taskmanagement;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noor.taskmanagement.view.InsertManualTaskApprovalModel;

import java.util.ArrayList;

import static com.example.noor.taskmanagement.CursorRecyclerViewAdapter.TAG;

public class TaskApprovalAdapter extends RecyclerView.Adapter<TaskApprovalAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<TaskApprovalModel> mData = new ArrayList<>();

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView taskTitle,taskStatus;
        ImageView statusTV;
        private int status;

        private String name;
        private String userID;

        private String updateStatus = "0";
        private ArrayList<InsertManualTaskApprovalModel.TaskApproval> taskApprovals;
        private InsertManualTaskApprovalModel.TaskApproval taskApproval;


        //        LinearLayout linearLayout;
        public MyViewHolder(View v) {
            super(v);

//            linearLayout = v.findViewById(R.id.layout);
//

            taskApprovals = new ArrayList<>();
            taskApproval = new InsertManualTaskApprovalModel.TaskApproval();

            taskTitle = v.findViewById(R.id.taskTitle);
            taskStatus = v.findViewById(R.id.progressTV);
            statusTV = v.findViewById(R.id.dateWiseAttendanceStudentStatusTV);

            statusTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ContentResolver resolver = v.getContext().getContentResolver();
//                    Cursor studentCursor =
//                            resolver.query( RequestProvider.urlForAttendanceClassScheduleListItems( 0 ),
//                                    null, AttendanceClassScheduleTableItems.COURSE_ID + " =? ",
//                                    new String[]{SharedPref.getInstance( context ).getCourseId()}, null );
//                    studentCursor.moveToFirst();


//                    String[] totalTime = studentCursor.getString( studentCursor.getColumnIndex( AttendanceClassScheduleTableItems.CLASS_TIME ) ).split("-");
//
//                    presentTime = Functions.convertTimeInHMS( totalTime[0] );

                    //open dialog


                    LayoutInflater li = LayoutInflater.from( v.getContext() );
                    final View promptsView = li.inflate( R.layout.single_task_approval_dialog, null );

                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( v.getContext() );

                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView( promptsView );
                    final AlertDialog alertDialog = alertDialogBuilder.create();

                    final TextView studentName = (TextView) promptsView.findViewById( R.id.insertDialogAttendanceStudentNameTV );
                    final TextView studentRoll = (TextView) promptsView.findViewById( R.id.insertDialogAttendanceStudentRollTV );
                    final TextView cancelTV = (TextView) promptsView.findViewById( R.id.insertDialogAttendanceCancelTV );
                    final Button okBTN = (Button) promptsView.findViewById( R.id.insertDialogAttendanceOkBTN );

                    final CheckBox completeCB = (CheckBox) promptsView.findViewById( R.id.dialogPresentCB );
                    final CheckBox progressCB = (CheckBox) promptsView.findViewById( R.id.dialogAbsentCB );
                    final CheckBox deferredCB = (CheckBox) promptsView.findViewById( R.id.dialogLateCB );

                    studentName.setText( "Name: " + name );
                    studentRoll.setText( "userID: " + userID );



                    if (status==1){
                        completeCB.setChecked( true );
                        progressCB.setChecked( false );
                        deferredCB.setChecked( false );
                    }else  if (status==0){
                        completeCB.setChecked( false );
                        progressCB.setChecked( true );
                        deferredCB.setChecked( false );
                    }else  if (status==2){
                        completeCB.setChecked( false );
                        progressCB.setChecked( false );
                        deferredCB.setChecked( true );
                    }
                    cancelTV.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.cancel();
                        }

                    } );


                    completeCB.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if (isChecked){
                                Log.d( TAG, "onCheckedChanged: present" );
                                progressCB.setChecked( false );
                                deferredCB.setChecked( false );
                                updateStatus = "1";
                                taskApproval.setPresent( updateStatus );
                                taskApprovals.clear();
                                taskApprovals.add(0, taskApproval );
                            }else {
                                Log.d( TAG, "onUnCheckedChanged: present" );

//                            absentCB.setChecked( true );
//                            attendances.remove(0);
                            }

                        }
                    } );

                    progressCB.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if (isChecked){
                                Log.d( TAG, "onCheckedChanged: absent" );

                                completeCB.setChecked( false );
                                deferredCB.setChecked( false );
                                updateStatus = "0";
                                taskApproval.setPresent(updateStatus);
//                                attendance.setUserid(studentID);
                                taskApprovals.clear();
                                taskApprovals.add(0,taskApproval);
                            }else {
                                Log.d( TAG, "onUnCheckedChanged: absent" );

//                            absentCB.setChecked( true );
//                            attendances.remove(0);
                            }

                        }
                    } );

                    deferredCB.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if (isChecked){
                                Log.d( TAG, "onUnCheckedChanged: Late" );

                                progressCB.setChecked( false );
                                completeCB.setChecked( false );
                                updateStatus = "2";
                                taskApproval.setPresent(updateStatus);
//                                attendance.setUserid(studentID);
                                taskApprovals.clear();
                                taskApprovals.add(0,taskApproval);
                            }else {
                                Log.d( TAG, "onUnCheckedChanged: late" );

//                            absentCB.setChecked( true );
//                            attendances.remove(0);
                            }

                        }
                    } );

                    okBTN.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "Clicked", Toast.LENGTH_SHORT).show();

//                            Intent intent = new Intent().setClass(v.getContext(), TaskApprovalFragment.class);
//                            v.getContext().startActivity(intent);
                            
//                        Toast.makeText( context, "Hello", Toast.LENGTH_SHORT ).show();

//                            InsertManualAttendanceModel myModel = new InsertManualAttendanceModel();
//                            myModel.setUsername( SharedPref.getInstance( context ).getUsername() );
//                            myModel.setPassword( SharedPref.getInstance( context ).getPassword() );
//                            myModel.setCourseID( SharedPref.getInstance( context ).getCourseId() );
//                            myModel.setPresentDate( presentDate );
//                            myModel.setPresentTime( presentTime );
//                            myModel.setAttendance( attendances );
//
//                            Log.d( TAG, "onClick: InsertManualAttendanceModel "+myModel.toString() );
//
//                            InsertManualAttendanceThread insertManualAttendanceThread = new InsertManualAttendanceThread( context,myModel );
//                            insertManualAttendanceThread.run();
                            alertDialog.cancel();
                        }
                    } );



                    alertDialog.show();


                }
            } );


        }
    }

    public TaskApprovalAdapter(Context mContext,ArrayList<TaskApprovalModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public TaskApprovalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.single_task_approval_list,viewGroup,false);
        TaskApprovalAdapter.MyViewHolder vh = new TaskApprovalAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TaskApprovalAdapter.MyViewHolder holder, int position) {
        holder.taskTitle.setText(mData.get(position).getTitle());
        holder.taskStatus.setText(mData.get(position).getProgress());


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
