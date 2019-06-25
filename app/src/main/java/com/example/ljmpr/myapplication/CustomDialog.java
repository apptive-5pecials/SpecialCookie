package com.example.ljmpr.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomDialog extends Dialog {

    String dbName = "saying.db";
    int dbVersion = 3;
    private DBHelper helper;
    private SQLiteDatabase db;
    String tableName = "saying"; //명언 db
    String sql; //명언
    String sql1;
    Cursor cursor;
    TextView tv;
    Context con;

    long now = System.currentTimeMillis(); //현재 시간을 받아온다.
    Date Ntime = new Date(now);

    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss"); // 어떠한 형태로 시간을 받아올건지 정한다.

    public static final String TAG_EVENT_DIALOG = "dialog_event";


    public CustomDialog(Context context, String text) {
        super(context);
        con = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 다이얼로그의 타이틀바를 없애주는 옵션
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 다이얼로그 배경을 투명으로 만드는 옵션
        setContentView(R.layout.dialog); // 다이얼로그에서 사용할 레이아웃

        tv = findViewById(R.id.text); // 텍스트 뷰에 명언이나 질문이 화면에 출력될 수 있도록 한다.

        helper = new DBHelper(getContext(),dbName,null,dbVersion);
        db = helper.getWritableDatabase(); // 데이터를 쓰기 전용으로

        if(text.equals(""))
            select(); // 데이터 조회 메소드
        else {
            tv.setText(text);
        }

    }

    void select() {
        db = helper.getWritableDatabase();

        try {
            Date d1 = f.parse("08:00:00"); // 기준이 되는 시간을 파싱해준다.
            Date d2 = f.parse("20:00:00");
            Date d3 = f.parse(f.format(Ntime)); // 현재 시간도 파싱
            long Am = d1.getTime(); // 파싱된 값을 long값에 넣어준다.
            long Pm = d2.getTime();
            long Nm = d3.getTime();

            if(Am<Nm && Nm<Pm) { // 8시 ~ 20시 사이에 아래 코드가 실행되도록 한다.
                sql = "SELECT*FROM WiseSaying order by random() limit 1 ;"; // 명언 DB에 있는 값을 하나 랜덤으로 불러온다.
                cursor = db.rawQuery(sql,null);
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String saying = cursor.getString(1);

                    tv.append(saying); // 화면에 명언을 출력한다.

                    Calendar calendar=Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, 20);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);
                    Date date=calendar.getTime();
                    long reset = calendar.getTimeInMillis();

                    SharedPreferences pref = con.getSharedPreferences("pref", con.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("text", saying);
                    editor.putLong("reset",reset);
                    Log.d("ddd",String.valueOf(reset));
                    editor.commit();
                }
            }
            else {
                sql1 = "SELECT*FROM QuesTion order by random() limit 1 ;"; // 질문 DB에 있는 값을 하나 랜덤으로 불러온다.
                cursor = db.rawQuery(sql1,null);
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String question = cursor.getString(1);

                    tv.append(question);

                    long now2 = now + 60000 * 60 * 4;

                    Calendar calendar=Calendar.getInstance();
                    calendar.setTimeInMillis(now2);
                    calendar.set(Calendar.HOUR_OF_DAY, 8);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);
                    Date date=calendar.getTime();
                    long reset = calendar.getTimeInMillis();

                    SharedPreferences pref = con.getSharedPreferences("pref", con.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("text", question);
                    editor.putLong("reset",reset);
                    Log.d("ddd",String.valueOf(reset));
                    editor.commit();
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
