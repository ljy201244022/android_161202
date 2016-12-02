package com.example.a403.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    RadioGroup rbg;
    RadioButton rb1, rb2;
    Button bt1,bt2;
    Chronometer chr1;
    TimePicker tp1;
    CalendarView cv1;
    FrameLayout fl1;
    int year,month,day,hour,minute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView1);
        rbg = (RadioGroup) findViewById(R.id.rbg);
        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        cv1 = (CalendarView) findViewById(R.id.calendarView);
        fl1 = (FrameLayout) findViewById(R.id.fl1);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        chr1 = (Chronometer) findViewById(R.id.chronometer2);
        tp1 = (TimePicker) findViewById(R.id.timePicker);

        year = -1;
        hour = -1;

        cv1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                year = i;
                month = i1;
                day = i2;
            }
        });

        tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour = i;
                minute = i1;
            }
        });


        rbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rb1.isChecked()) {
                    cv1.setVisibility(View.VISIBLE);
                    tp1.setVisibility(View.INVISIBLE);
                } else if (rb2.isChecked()) {
                    tp1.setVisibility(View.VISIBLE);
                    cv1.setVisibility(View.INVISIBLE);
                }
            }
        });

        bt2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr1.setBase(SystemClock.elapsedRealtime());
                chr1.start();
                year = -1;
                hour = -1;
                t1.setText("");
                rbg.check(R.id.radioButton);
            }
        });

        bt1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(year != -1 && hour != -1){
                    chr1.stop();
                    t1.setText(year + "년" + month  + "월" +  day + "일" + hour + "시" + minute + "분" + "예약됨");
                }
            }

        });
    }
}
