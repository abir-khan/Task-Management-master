package com.example.noor.taskmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.callback.OnPieSelectListener;
import com.razerdp.widget.animatedpieview.data.IPieInfo;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {

    private static final String TAG = UserProfile.class.getSimpleName();
//    private FloatingActionButton addNewTaskBTN;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button workDoneBtn;

    private ImageView headerBackgroundIV;
    Integer[] image = {R.drawable.ic_add_white_24dp,R.drawable.ic_exit_to_app_white_24dp};
    String[] name = {"Add Task","Logout"};

    BoomMenuButton addNewTaskBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        addNewTaskBTN = findViewById(R.id.btnCreateTask);

        addNewTaskBTN.setPiecePlaceEnum(PiecePlaceEnum.DOT_2_1);
        addNewTaskBTN.setButtonPlaceEnum(ButtonPlaceEnum.SC_2_1);
        addNewTaskBTN.setButtonEnum(ButtonEnum.TextOutsideCircle);

        for (int i = 0; i < addNewTaskBTN.getPiecePlaceEnum().pieceNumber(); i++) {
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                    .normalImageRes(image[i])
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if (index == 0){
                                Toast.makeText(UserProfile.this, "Insert New Task", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(UserProfile.this,InsertNewTaskActivity.class));
                            }else{
                                Toast.makeText(UserProfile.this, "Logout", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(UserProfile.this,MainActivity.class));
                            }
                        }
                    })
                    .shadowEffect(true)
                    .typeface(Typeface.DEFAULT_BOLD)
                    .textSize(15)
                    .rippleEffect(true)
                    .normalText(name[i]);
            addNewTaskBTN.addBuilder(builder);
        }


        workDoneBtn = findViewById(R.id.workDoneBtn);

        workDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from( v.getContext() );
                final View promptsView = li.inflate( R.layout.single_pie_chart_dialog, null );

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( v.getContext() );

                alertDialogBuilder.setView( promptsView );
                final AlertDialog alertDialog = alertDialogBuilder.create();

                final AnimatedPieView pieView = promptsView.findViewById(R.id.pieChart);
                final Button okBtn = promptsView.findViewById(R.id.OkBTN);


                AnimatedPieViewConfig config = new AnimatedPieViewConfig();
                config.addData(new SimplePieInfo(2500,Color.parseColor("#01bcd5"),"Complete"));
                config.addData(new SimplePieInfo(800,Color.parseColor("#8bdbe6"),"Process"));
                config.addData(new SimplePieInfo(200,Color.parseColor("#AAFF0000"),"Deferred"));

                config.duration(1500);
                config.drawText(true);
                config.strokeMode(false);
                config.textSize(26);
                config.selectListener(new OnPieSelectListener<IPieInfo>() {
                    @Override
                    public void onSelectPie(@NonNull IPieInfo pieInfo, boolean isFloatUp) {
                        Toast.makeText(UserProfile.this, pieInfo.getDesc() + " - " + pieInfo.getValue(), Toast.LENGTH_SHORT).show();
                    }
                });
                config.startAngle(-180);
                config.autoSize(true);
                config.textMargin(8);
//                config.pieRadius(100);
                config.textGravity(AnimatedPieViewConfig.ABOVE);
                config.canTouch(true);
                config.splitAngle(1);

                config.focusAlphaType(AnimatedPieViewConfig.FOCUS_WITH_ALPHA_REV);

                pieView.applyConfig(config);
                pieView.start();

                okBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });

                alertDialog.show();

            }
        });


        headerBackgroundIV =  findViewById(R.id.headerBackgroundLL);
        Drawable dPage_header= getResources().getDrawable(R.drawable.image);
        dPage_header.setAlpha(25);

//        addNewTaskBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity( new Intent( UserProfile.this,InsertNewTaskActivity.class ) );
//            }
//        });



        addNewTaskBTN.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float startRawX;
            float distanceX;
            int lastAction;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = view.getX() - event.getRawX();
                        startRawX = event.getRawX();
                        lastAction = MotionEvent.ACTION_DOWN;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.setX(event.getRawX() + startX);
                        view.setY(event.getRawY() + startX);

                        lastAction = MotionEvent.ACTION_MOVE;
                        break;

                    case MotionEvent.ACTION_UP:
                        distanceX = event.getRawX()-startRawX;
                        if (Math.abs(distanceX)< 10){
                            startActivity( new Intent( UserProfile.this,InsertNewTaskActivity.class ) );
                        }
                        break;
                    case MotionEvent.ACTION_BUTTON_PRESS:

                    default:
                        return false;
                }
                return true;
            }

        });
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TaskListFragment(), "Task List");
        adapter.addFragment(new TaskApprovalFragment(), "Task Approval");
        adapter.addFragment(new DashboardFragment(), "Dashboard");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
