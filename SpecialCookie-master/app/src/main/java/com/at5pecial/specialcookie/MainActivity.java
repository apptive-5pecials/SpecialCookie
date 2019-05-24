package com.at5pecial.specialcookie;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    long now= System.currentTimeMillis(); // 현재 시간을 가져온다.
    Date Ntime= new Date(now);
    SimpleDateFormat f= new SimpleDateFormat("HH:mm:ss"); // 어떤 형태로 시간을 가져올지 정한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Date d1=f.parse("08:00:00"); // 기준 시간과, 현재 시간을 파싱해준다.
            Date d2=f.parse("20:00:00");
            Date d3=f.parse(f.format(Ntime));
            long Am=d1.getTime(); // long 값에 파싱된 값을 넣어준다.
            long Pm=d2.getTime();
            long Nm=d3.getTime();

            if(Am<Nm && Nm<Pm){ // 8시~20시 에는 day화면이 배경으로 뜨도록 한다.
                layout=(LinearLayout)findViewById(R.id.layout);
                layout.setBackgroundResource(R.drawable.day);

            }else{ //그외 시간에는 night화면이 배경으로 뜨게 한다.
                layout=(LinearLayout)findViewById(R.id.layout);
                layout.setBackgroundResource(R.drawable.night);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        ImageButton button = findViewById(R.id.Cookie);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDialogFragment e = EventDialogFragment.getInstance();
                e.show(getSupportFragmentManager(), EventDialogFragment.TAG_EVENT_DIALOG);
            }
        });



    }



}
