package com.example.noor.taskmanagement;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertNewTaskActivity extends AppCompatActivity {

    private Toolbar toolbar;

    TextView taskTitleTV, taskScoreTV, estimatedHourTV,completionDateTV;
    EditText taskTitleET, taskScoreET, estimatedHourET, completionDateET;
    MaterialSpinner kra, kpi, priority,status,taskType,project;

    private Calendar calendar;
    private Long deadLineDateMillSecond;
    private  final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MMM/yyyy");
    private boolean samsung;
    private TextView startDateTV,dueDateTV;

    private String homeWorkdeadLine;

    private static final String TAG = InsertNewTaskActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_new_task);


        toolbar = findViewById( R.id.taskEntryToolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        kra = findViewById(R.id.kraSP);

        kra.setItems("Select KRA","Software Development","Administration","Application","Application Development And Support");

        kpi = findViewById(R.id.kpiSP);

        kpi.setItems("Select KAI","Coding,Testing,Debuging");

        priority = findViewById(R.id.prioritySP);
        priority.setItems("Urgent","High","Normal","Low","Wish List");
        status = findViewById(R.id.statusSP);
//        status.setItems("Started","In Progress","Deferred","Waiting on Someone else","Ready To complete");
        status.setItems("Started","In Progress","Deferred","Someone else","Complete");
        taskType = findViewById(R.id.taskTypeSP);
        taskType.setItems("Service","Support");
        project = findViewById(R.id.prioritySP);

        project.setItems("Aayat Properties","Accounts","Accounts Only Desktop","Android Application");

        startDateTV = findViewById(R.id.startDateTV);

        dueDateTV = findViewById(R.id.dueDateTV);

        calendar = Calendar.getInstance();

        final Calendar setCalender = Calendar.getInstance();
        final int year = setCalender.get( Calendar.YEAR);
        final int month = setCalender.get(Calendar.MONTH);
        final int date = setCalender.get(Calendar.DAY_OF_MONTH);

        startDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(InsertNewTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.YEAR,year);
//                        String dateString = sdf.format(calendar.getTimeInMillis());
                        deadLineDateMillSecond =calendar.getTimeInMillis();
                        startDateTV.setText(simpleDateFormat.format(calendar.getTimeInMillis()));
                        Toast.makeText(getApplicationContext(),String.valueOf(calendar.getTime()),Toast.LENGTH_LONG).show();
                        Log.d("Month",String.valueOf(calendar.getTime()));
                    }
                },year,month,date);
//                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.getDatePicker().setMinDate(setCalender.getTimeInMillis());
                datePickerDialog.show();

            }
        });

        dueDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(InsertNewTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.YEAR,year);
//                        String dateString = sdf.format(calendar.getTimeInMillis());
                        deadLineDateMillSecond =calendar.getTimeInMillis();
                        dueDateTV.setText(simpleDateFormat.format(calendar.getTimeInMillis()));
                        Toast.makeText(getApplicationContext(),String.valueOf(calendar.getTime()),Toast.LENGTH_LONG).show();
                        Log.d("Month",String.valueOf(calendar.getTime()));
                    }
                },year,month,date);
//                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.getDatePicker().setMinDate(setCalender.getTimeInMillis());
                datePickerDialog.show();

            }
        });


//        samsung = Functions.isSamsung() ;
//        Log.d( TAG,String.valueOf( Functions.isSamsung() ) );


    }







    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
