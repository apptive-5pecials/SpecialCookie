package com.example.ljmpr.myapplication;

import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    long now = System.currentTimeMillis();
    Date Ntime = new Date(now);
    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss"); //어떤 형태로 시간을 가져올지 정한다.
    Date d1, d2, d3;
    long Am, Pm, Nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        ImageButton button = null;

        try {
            d1 = f.parse("08:00:00"); // 기준 시간과 현재 시간을 파싱해준다.
            d2 = f.parse("20:00:00");
            d3 = f.parse(f.format(Ntime));
            Am = d1.getTime(); // long 값에 파싱된 값을 넣어준다.
            Pm = d2.getTime();
            Nm = d3.getTime();

            if(Am<Nm && Nm<Pm) { //8시~20시에 day 화면이 배경으로 뜨도록 한다.
                setContentView(R.layout.day);
                button = findViewById(R.id.Cookie);
                button.setImageResource(R.drawable.imgbtn_day);
            }
            else { //그 외의 시간에는 night 화면이 배경으로 뜨게 한다.
                setContentView(R.layout.night);
                button = findViewById(R.id.Cookie);
                button.setImageResource(R.drawable.imgbtn_night);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        final ImageButton buttons = button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Long reset = pref.getLong("reset", 0); // 리셋 시간 불러오기
                String text = "";

                Log.d("ddd",String.valueOf(reset));

                if(now < reset) {
                    text = pref.getString("text", "");
                    if(Am<Nm && Nm<Pm) {
                        buttons.setImageResource(R.drawable.cracked_cookie_day);
                    }
                    else {
                        buttons.setImageResource(R.drawable.cracked_cookie_night);
                    }
                }

                CustomDialog cd = new CustomDialog(MainActivity.this, text);

                cd.show();
            }
        });

    }

}
