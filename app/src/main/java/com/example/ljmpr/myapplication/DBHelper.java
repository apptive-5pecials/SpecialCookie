package com.example.ljmpr.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 두가지 DB를 만들어준다. 하나는 명언, 하나는 질문
        String sql = "CREATE TABLE WISESAYING" +
                "(id INTEGER," +
                "saying TEXT);";
        db.execSQL(sql);

        db.execSQL("INSERT INTO WISESAYING VALUES (1, '너 자신을 알라');");
        db.execSQL("INSERT INTO WISESAYING VALUES (2, '실패는 성공의 어머니');");
        db.execSQL("INSERT INTO WISESAYING VALUES (3, '남을 탓하기 전에 자신을 뒤돌아 보라');");

        String sql1 = "CREATE TABLE QuesTion" +
                "(id INTEGER," +
                "question TEXT);";
        db.execSQL(sql1);

        db.execSQL("INSERT INTO QUESTION VALUES (1, '당신은 행복한가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (2, '당신이 가장 사랑하는 사람은?');");
        db.execSQL("INSERT INTO QUESTION VALUES (3, '오늘이 후회되지는 않나요?');");
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS WiseSaying;";
        db.execSQL(sql);
        onCreate(db);
        // DB 버젼이 업데이트 될 때 테이블을 갱신해준다.
    }

}
