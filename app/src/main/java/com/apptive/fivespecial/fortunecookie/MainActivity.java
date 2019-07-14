package com.apptive.fivespecial.fortunecookie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    long now = System.currentTimeMillis();
    Date Ntime = new Date(now);
    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss"); //어떤 형태로 시간을 가져올지 정한다.
    Date d1, d2, d3;
    long Am, Pm, Nm;
    Thread th;
    boolean a;
    Context tcontext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        ImageButton button = null;

        tcontext = getApplicationContext();

        //sound player
        final SoundPool sp = new SoundPool(1, // 최대 음악파일의 개수
                AudioManager.STREAM_MUSIC,  // 스트림 타입
                0);  // 음질

        final int soundID = sp.load(tcontext,
                R.raw.snack,
                1);


        try {
            d1 = f.parse("08:00:00"); // 기준 시간과 현재 시간을 파싱해준다.
            d2 = f.parse("20:00:00");
            d3 = f.parse(f.format(Ntime));
            Am = d1.getTime(); // long 값에 파싱된 값을 넣어준다.
            Pm = d2.getTime();
            Nm = d3.getTime();

            Long reset = pref.getLong("reset", 0); // 리셋 시간 불러오기
            String text = "";

            if(Am<Nm && Nm<Pm) { //8시~20시에 day 화면이 배경으로 뜨도록 한다.
                setContentView(R.layout.day);
                button = findViewById(R.id.Cookie);
                button.setImageResource(R.drawable.imgbtn_day);
                a = true;
                if(now < reset) {
                    button.setImageResource(R.drawable.cracked_cookie_day);
                }
            }
            else { //그 외의 시간에는 night 화면이 배경으로 뜨게 한다.
                setContentView(R.layout.night);
                button = findViewById(R.id.Cookie);
                button.setImageResource(R.drawable.imgbtn_night);
                a = false;
                if(now < reset) {
                    button.setImageResource(R.drawable.cracked_cookie_night);
                }
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

                sp.play(soundID, // 준비한 soundID
                        1,         // 왼쪽 볼륨 float 0.0(작은소리)~1.0(큰소리)
                        1,         // 오른쪽볼륨 float
                        0,         // 우선순위 int
                        0,     // 반복회수 int -1:무한반복, 0:반복안함
                        1.5f);    // 재생속도 float 0.5(절반속도)~2.0(2배속)
                // 음악 재생

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

        th = new Thread(new Runnable() {
            boolean b = true;
            @Override
            public void run() {
                while(b){
                    Calendar c = Calendar.getInstance();
                    if((a && c.get(Calendar.HOUR_OF_DAY) == 20) || !a && c.get(Calendar.HOUR_OF_DAY) == 8) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                b = !b;
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                                MainActivity.this.finish();
                            } });
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        th.start();

    }

}
