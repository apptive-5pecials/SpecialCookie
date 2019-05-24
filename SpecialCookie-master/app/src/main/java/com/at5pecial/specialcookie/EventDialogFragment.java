package com.at5pecial.specialcookie;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDialogFragment extends DialogFragment implements View.OnClickListener {
    String dbName = "saying.db";
    int dbVersion=3;
    private DBHelper helper;
    private SQLiteDatabase db;
    String tableName= "saying"; // 명언 db
    String sql; //명언 sql
    String sql1;
    Cursor cursor;
    TextView tv;

    long now= System.currentTimeMillis(); //현재 시간을 받아온다.
    Date Ntime= new Date(now); //

    SimpleDateFormat f= new SimpleDateFormat("HH:mm:ss"); // 어떠한 형태로 시간을 받아올건지 정한다.



    public static final String TAG_EVENT_DIALOG = "dialog_event";

    public EventDialogFragment(){}

    public static EventDialogFragment getInstance(){

        EventDialogFragment e = new EventDialogFragment();
        return e;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dialog, container);
        tv= v.findViewById(R.id.text); // 텍스트 뷰에 명언이나, 질문이 화면에 출력 할수 있도록 한다.



        helper = new DBHelper(getContext(),dbName,null,dbVersion);

        db= helper.getWritableDatabase(); //데이터를 쓰기 전용으로

        select(); // 데이터 조회 메소드



        // fragment 밖의 영역을 터치 시 화면이 dismiss되는 놈.
        //setCancelable(false);
        return v;
    }

    void select(){
        db=helper.getWritableDatabase();

        try{
            Date d1=f.parse("08:00:00"); //기준이 되는 시간을 파싱해준다.
            Date d2=f.parse("20:00:00");
            Date d3=f.parse(f.format(Ntime)); // 현재 시간도 파싱
            long Am=d1.getTime(); // 파싱된 값을 long값에 넣어준다.
            long Pm=d2.getTime();
            long Nm=d3.getTime();

            if(Am<Nm && Nm<Pm){ //오전 8시 ~ 20시 사이에 아래 코드가 실행되도록 한다.
                sql= "SELECT * FROM WIseSaying order by random() limit 1 ;"; // 명언 DB에 있는 값을 하나 랜덤으로 불러온다.
                cursor= db.rawQuery(sql,null);
                while(cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String saying = cursor.getString(1);

                    tv.append(saying); // 화면에 명언을 출력한다.
                }
            }else{
                sql1= "SELECT * FROM QusTion order by random() limit 1 ;";// 질문 DB에 있는 값을 하나 랜덤으로 불러온다.
                cursor= db.rawQuery(sql1,null);
                while(cursor.moveToNext()){
                    int id=cursor.getInt(0);
                    String qustion=cursor.getString(1);

                    tv.append(qustion);
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
