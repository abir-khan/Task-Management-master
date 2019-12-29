package com.example.noor.taskmanagement.staticclasses;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.example.noor.taskmanagement.R;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 9/30/2017.
 */

public class Functions {

//    public static final String DEVELOPER_KEY = "AIzaSyAEDWZUfRgWp9s6mBy_MRZ5WNHudJneEn8";
//    public static String BASE_IMAGE_URL = "http://smartstudy.com.bd/demo/uploads/notice/";

    //public static String BASE_URL = "http://127.0.0.1:14745";
//    public static String NOTICE_IMAGE_URL = "http://smartstudy.com.bd/demo/uploads/notice/";
//    public static String BASE_URL = "http://bandarban-ghs.com.bd/school/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit==null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.MINUTES)
                    .readTimeout(30, TimeUnit.MINUTES)
                    .build();


            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:14745")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static boolean isSamsung() {
        String manufacturer = android.os.Build.MANUFACTURER;
        if (manufacturer.toLowerCase( Locale.ENGLISH ).contains( "samsung" ))
            return true;
        else
            return false;
    }


    public static String convertTimeStamp(String inputDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );

        Date date = null;
        try {
            date = simpleDateFormat.parse( inputDate );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (date == null) {
            return "";
        }

        SimpleDateFormat convetDateFormat = new SimpleDateFormat( "dd MMM, yyyy hh:mm a" );

        return convetDateFormat.format( date );
    }

    public static String convertTimeDDMY(String inputDate) {  ///output is :  Tue 24 Apr 2018
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );

        Date date = null;
        try {
            date = simpleDateFormat.parse( inputDate );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (date == null) {
            return "";
        }

        SimpleDateFormat convetDateFormat = new SimpleDateFormat( "EE dd MMM yyyy" );

        return convetDateFormat.format( date );
    }

    public static String convertTimeStampAmPm(String inputDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );

        Date date = null;
        try {
            date = simpleDateFormat.parse( inputDate );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (date == null) {
            return "";
        }

        SimpleDateFormat convertDateFormat = new SimpleDateFormat( "hh:mm a" );

        return convertDateFormat.format( date );
    }

    public static String convertDay(String inputDate) { // input Output 23 Oct, 2018
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

        Date date = null;
        try {
            date = simpleDateFormat.parse( inputDate );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (date == null) {
            return "";
        }

        SimpleDateFormat convertDateFormat = new SimpleDateFormat( "dd MMM, yyyy" );

        return convertDateFormat.format( date );
    }

    public static String convertTime(Date inputTime) {


        SimpleDateFormat convetDateFormat = new SimpleDateFormat( "hh:mm:ss" );

        return convetDateFormat.format( inputTime );
    }

    public static String convertTimeInHMS(String inputTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "hh:mm a" );

        Date date = null;
        try {
            date = simpleDateFormat.parse( inputTime );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (date == null) {
            return "";
        }

        SimpleDateFormat convetDateFormat = new SimpleDateFormat( "hh:mm:ss" );

        return convetDateFormat.format( date );
    }

    public static int timeDifference(long datetime) throws ParseException {
        long differenceInMillis = Calendar.getInstance().getTimeInMillis() - datetime;
        long differenceInHours = (differenceInMillis) / 1000L / 60L / 60L; // Divide by millis/sec, secs/min, mins/hr
        return (int) differenceInHours;
    }

    public static String convertDateFromDMY(String inputDate) { // DMY= Day Month Year
        String[] parts = inputDate.split( "-" );
        String year = parts[0]; // 004
        String month = parts[1];
        String date = parts[2];
        return date;
    }

    public static String convertYearFromDMY(String inputDate) { // DMY= Day Month Year
        String[] parts = inputDate.split( "-" );
        String year = parts[0]; // 004
        String month = parts[1];
        String date = parts[2];
        return year;
    }

    public static String convertMonthFromDMY(String inputDate) { // DMY= Day Month Year
        String[] parts = inputDate.split( "-" );
        String year = parts[0]; // 004
        int monthNo = 0;
        String month = new String();
        String date = parts[2];
        try {
            monthNo = Integer.parseInt( parts[1] ) - 1;

        } catch (Exception e) {

            return "error";
        }


        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (monthNo >= 0 && monthNo <= 11) {
            month = months[monthNo];
            return month;
        } else {
            return "error";
        }

    }

    public static String convertDayFromDMY(String inputDate) { // DMY= Day Month Year   2018-04-14
        String[] parts = inputDate.split( "-" );
        Calendar cal = Calendar.getInstance();
        int year = 0; // 004
        int date = 0;
        String day = new String();
        int month = 0;
        try {
            date = Integer.parseInt( parts[2] );  // 17
            month = Integer.parseInt( parts[1] ) - 1;  // 05
            year = Integer.parseInt( parts[0] );  // 05
            cal.set( year, month, date );

        } catch (Exception e) {

        }

        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getWeekdays();
        int dayOfWeek = cal.get( cal.DAY_OF_WEEK );
        if (dayOfWeek >= 1 && dayOfWeek <= 7) {

            return months[dayOfWeek];

        } else {
            return "error";
        }


    }

    public static String upperCaseFirst(String value) {

        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }



    public static AlertDialog.Builder alertDialogBuilder;
    public static CircleProgressBar progressBar;
    public static AlertDialog alertDialog;


    public static void ProgressDialog(Context context) {


        LayoutInflater li = LayoutInflater.from( context );
        final View promptsView = li.inflate( R.layout.custom_progress_dialog, null );
        alertDialogBuilder = new AlertDialog.Builder( context );
        // set prompts.xml to alertDialog builder
        alertDialogBuilder.setView( promptsView );
        alertDialog = alertDialogBuilder.create();

        progressBar = (CircleProgressBar) promptsView.findViewById( R.id.custom_progress );

    }

    public static void showDialog() {
        if (!alertDialog.isShowing())
        {
            simulateProgress();
        }

    }

    public static void hideDialog() {
        if (alertDialog.isShowing())
        {
            alertDialog.dismiss();
        }
    }

    public static void simulateProgress() {
        Log.d( "Static_Function", "simulateProgress: " );
        alertDialog.show();
        progressBar.setVisibility( View.VISIBLE );
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int progress = (int) animation.getAnimatedValue();

                progressBar.setProgress(progress);
//                progressBar.sett

            }
        });
        animator.setRepeatCount( ValueAnimator.INFINITE );
        animator.setDuration(1500);
        animator.start();
    }



}
