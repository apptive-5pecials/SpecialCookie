package com.at5pecial.specialcookie;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // 두가지 DB를 만들어준다. 하나는 명언, 하나는 질문
        String sql = "Create table WiseSaying" +
                "(id INTEGER,"+
                "saying TEXT);";
        db.execSQL(sql);

        db.execSQL("INSERT INTO WISESAYING VALUES(1, '너 자신을 알라');");
        db.execSQL("INSERT INTO WISESAYING VALUES(2, '실패는 성공의 어머니');");
        db.execSQL("INSERT INTO WISESAYING VALUES(3, '남을 탓하기전에 자신을 뒤돌아 보라');");
        db.execSQL("INSERT INTO WISESAYING VALUES(4, '늦었다고 생각할때가 가장 빠를때다');");
        db.execSQL("INSERT INTO WISESAYING VALUES(5, '너 자신을 알라');");
        db.execSQL("INSERT INTO WISESAYING VALUES(7, '뒤돌아 보지마라');");
        db.execSQL("INSERT INTO WISESAYING VALUES(8, '천천히 묵묵히 그길을 가라');");
        db.execSQL("INSERT INTO WISESAYING VALUES(9, '만약에 내가 너였다면');");

        String sql1="Create table QusTion"+
                "(id INTEGER,"+
                "qustion TEXT);";
        db.execSQL(sql1);

        db.execSQL("INSERT INTO QUSTION VALUES(1,'당신은 행복한가요?');");
        db.execSQL("INSERT INTO QUSTION VALUES(2,'당신이 가장 사랑하는 사람은?');");
        db.execSQL("INSERT INTO QUSTION VALUES(3,'오늘이 후회되지는 않나요?');");
        db.execSQL("INSERT INTO QUSTION VALUES(4,'사랑이란 뭘까요?');");
        db.execSQL("INSERT INTO QUSTION VALUES(5,'당신이 가장 좋아하는 노래는?');");





    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql="drop table if exists WiseSaying;";
        db.execSQL(sql);
        onCreate(db);
        //DB 버젼이 업데이트 될때 테이블을 갱신해준다.

    }


}
