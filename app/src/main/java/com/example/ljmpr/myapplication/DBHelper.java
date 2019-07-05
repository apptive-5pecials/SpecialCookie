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
        db.execSQL("INSERT INTO WISESAYING VALUES (4, '시작할 때 위대할 필요는 없다. 그러나 시작하면 위대해 진다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (5, '좋았다면 추억이고 나빳다면 경험이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (6, '노력을 이기는 재능은 없고 노력을 외면하는 결과도 없다');");
        db.execSQL("INSERT INTO WISESAYING VALUES (7, '삶의 지혜는 종종 듣는 데서 비롯되고 삶의 후회는 대게 말하는데서 비롯된다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (8, '길을 아는 것과 그 길을 걷는 것은 다르다');");
        db.execSQL("INSERT INTO WISESAYING VALUES (9, '남의 불행 위에 내 행복을 쌓지 마라');");
        db.execSQL("INSERT INTO WISESAYING VALUES (10, '승리하면 조금 배울 수 있고 실패하면 모든 것을 배울 수 있다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (11, '자기 자신을 정복하지 못한 사람은 결코 자유로울 수가 없다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (12, '당신의 감정은 때로 당신의 약점에서 태어난다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (13, '진실은 보통 모함에 맞서는 최선의 해명이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (14, '오늘의 책임을 피함으로써 내일의 책임을 피할 수는 없다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (15, '내 자신에 대한 자신감을 잃으면, 온 세상이 나의 적이 된다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (16, '성공은 친구를 만들고, 역경은 친구를 시험한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (17, '게으름은 즐겁지만 괴로운 상태다, 우리는 행복해지기 위해서 무엇인가 하고 있어야 한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (18, '나의 기분은 나의 태도가 되어선 안된다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (19, '운은 계획에서 비롯된다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (20, '내가 맞을 땐 아무도 기억 못하는데, 내가 틀렸을 땐 다 기억한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (21, '전달되지 않는 진심으로 오해가 싹트고 그 잠깐의 엇갈림은 관계의 무너짐을 예고한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (22, '다른 누군가가 되어서 사랑받기보다는 있는 그래로의 나로서 미움받는 것이 낫다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (23, '네가 말을 할 때에는 그 말이 침묵보다 나은 것이어야 한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (24, '누군가를 신뢰할만한 사람이 되게 하는 유일한 방법은 그를 신뢰하는 것뿐이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (25, '내 언어의 한계는 내 세계의 한계이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (26, '사람이 친구를 사귀는 데는 분명한 과정이 하나 있는데, 매번 몇 시간에 걸쳐 이야기를 하고 이야기를 들어 주는 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (27, '인생은 멀리서 보면 희곡이고 가까이서 보면 비극이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (28, '내 언어의 한계는 내 세계의 한계이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (29, '만남은 인연이고 관계는 노력이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (30, '서로에 대해서 아는 것을 사랑하고 모르는 것을 신뢰하라.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (31, '당신이 저지를 수 있는 가장 큰 실수는, 실수를 할까 두려워 하는 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (32, '내가 나를 사랑하기 시작하면 세상도 나를 사랑하기 시작합니다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (33, '가장 큰  위험은 위험없는 삶이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (34, '잘 살아라. 그게 최고의 복수다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (35, '사랑의 반대는 미움이 아니고, 예술의 반대는 추함이 아니며, 삶의 반대 역시 죽음이 아니다. 이 모든 것들의 반대는 무관심이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (36, '인연은 매번 처음에 영원할 것 처럼 다가와 가슴에 잊을수 없는 자국을 남기고 사라진다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (37, '장미같이 아름다운 꽃이 가시가 있다고 생각하지 말고 가시 많은 나무에 장미같이 아름다운 꽃이 피었다고 생각하라.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (38, '별은 바라보는 자에게 빛을 준다');");
        db.execSQL("INSERT INTO WISESAYING VALUES (39, '편견은 내가 다른 사람을 사랑하지 못하게 하고, 오만은 다른 사람이 나를 사랑할수 없게 만든다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (40, '용서는 남을 보고 하는 것이 아니라, 내 마음을 보고 하는 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (41, '일을 벌여놓고 끝을 맺지 않는 것만큼 큰 죄는 없다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (42, '오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아간다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (43, '아마추어는 문제를 복잡하게 만들고 프로는 문제를 단순화 시킨다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (44, '상대방이 만만하게 보인다면, 그 사람은 당신을 배려하고 있는 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (45, '후회하기 싫으면 그렇게 살지 말고 그렇게 살 거면 후회하지 마라.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (46, '죽는 날까지 하늘을 우러러 한점 부끄럼이 없기를');");
        db.execSQL("INSERT INTO WISESAYING VALUES (47, '젊은이만이 범할 수 있는 가장 큰 죄악은 평범해지는 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (48, '매일 행복하지 않지만 행복한 일은 매일 있어');");
        db.execSQL("INSERT INTO WISESAYING VALUES (49, '병이 없는 것이 가장 큰 재산이며, 만족을 아는 자가 가장 넉넉한 자이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (50, '서두르지 마라 걱정하지마라 이 세상에 당신은 짧은 여행을 온 것이다. 잠시만이라도 멈춰 서서 장미꽃 향기를 맡아 보라.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (51, '편안하면서 존경받는 삶은 없다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (52, '우리는 나이가 들면서 변하는 것이 아니다. 보다 자기다워지는 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (53, '누군가 당신의 뒷담화를 하는 이유는 그들이 당신보다 뒤에 있기 때문이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (54, '풍요 속에서는 친구들이 나를 알게 되고 역경 속에서는 내가 친구를 알게 된다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (55, '기쁨을 감추면, 그 만큼 기쁨이 감소한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (56, '귀는 친구를 만들고 입은 적을 만든다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (57, '부끄러움을 아는 것은 부끄러운 것이 아니다. 부끄러움을 모르는 것이 부끄러운 일이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (58, '좋은 책을 읽는 것은 과거의 가장 뛰어난 사람들과 대화를 나누는 것과 같다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (59, '걱정거리를 두고 웃는 법을 배우지 못하면 나이가 들었을 때 웃을 일이 전혀 없을 것이다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (60, '술은 머리에 들어가면 비밀이 밖으로 밀려나간다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (61, '병을 숨기는 자에게 약은 없다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (62, '인격을 시험해보고 싶다면 권력을 갖게 해봐야 한다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (63, '지킬 수 없는 약속보다는 당장의 거절이 낫다.');");
        db.execSQL("INSERT INTO WISESAYING VALUES (64, '남이 나를 알아주지 않는다고 불평치 말고 내가 남을 알지 못함을 걱정하라.');");



        String sql1 = "CREATE TABLE QuesTion" +
                "(id INTEGER," +
                "question TEXT);";
        db.execSQL(sql1);

        db.execSQL("INSERT INTO QUESTION VALUES (1, '당신은 행복한가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (2, '당신이 가장 사랑하는 사람은?');");
        db.execSQL("INSERT INTO QUESTION VALUES (3, '오늘이 후회되지는 않나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (4, '오늘 가장 고마웠던 사람은 누군가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (5, '오늘 가장 행복했던 순간은 언제 였나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (6, '오늘 당신이 다른 사람에게 베푼 친절,혹은 다른 사람이 베푼 친절이 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (7, '오늘 점심은 누구랑 먹었나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (8, '오늘 가장 기억에 남는 게 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (9, '오늘 새로 알게된 것이 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (10, '요즘 읽고 있는 책이 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (11, '나는 어떤 색인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (12, '당신은 당신의 어떤 점이 마음에 드시나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (13, '1년뒤 나에게 질문 1가지를 해주세요.');");
        db.execSQL("INSERT INTO QUESTION VALUES (14, '내가 어떤 모습으로 살아가길 바라나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (15, '당신의 현재 꿈은 무엇 인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (16, '당신이 정말 불행한 사람일까요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (17, '오늘 하루는 즐거웠나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (18, '당신은 언제 행복함을 느끼나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (19, '당신은 지금 사랑받고 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (20, '오늘 가장 많이 쓴 단어는 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (21, '내일 하루 중 가장 기다려지는 순간은?');");
        db.execSQL("INSERT INTO QUESTION VALUES (22, '지금 더나고 싶은 여행지는?');");
        db.execSQL("INSERT INTO QUESTION VALUES (23, '내일 꼭 하고 싶은 일이 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (24, '결혼하고 싶은 마음은 언제 생길까요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (25, '포기가 정말 답일까요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (26, '내가 사랑받고 있구나라는 것을 느끼는 순간은 언제인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (27, '최근 새롭게 좋아하게 된 것이 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (28, '오늘 하루, 하고 싶은 일을 했나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (29, '내일 하루만 산다면 뭘 하고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (30, '최근에 산 것 중 정말 잘 샀다고 생각되는 것은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (31, '나에게 1억이 생긴다면?');");
        db.execSQL("INSERT INTO QUESTION VALUES (32, '내가 정말 화날 때 어떻게 행동하나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (33, '나만의 소확행이 있나요? 어떤 것인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (34, '요즘 가장 하기 싫은 일은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (35, '당신이 가장 좋아하는 명언은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (36, '당신이 가장 듣기 싫어하는 말은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (37, '오늘 하루 가장 후회했던 것이 뭔가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (38, '오늘 하루 가장 뿌듯했던 것은 뭔가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (39, '기억에 남는 생일선물은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (40, '어떤 사람과 함께 있을 때 행복한가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (41, '사랑이란 뭘까요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (42, '당신이 유투버가 된다면 어떤 컨텐츠를 하고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (43, '가장 재미있게 봤던 영화는?');");
        db.execSQL("INSERT INTO QUESTION VALUES (44, '오늘 하늘을 몇 번이나 올려 보았나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (45, '당신이 살면서 가장 소중하게 여기는 가치관은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (46, '요즘 당신이 바라보는 자신의 모습은 어떤가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (47, '당신의 오늘을 5글자로 표현한다면?');");
        db.execSQL("INSERT INTO QUESTION VALUES (48, '다른 사람에게 어떤 사람으로 보이는게 가장 싫은가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (49, '당신은 스트레스를 풀 때 어떤 방식으로 푸나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (50, '당신의 이상형은 어떤 사람인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (51, '요즘 자꾸 생각나고 마음에 드는 사람이 있나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (52, '과거, 미래 둘중 하나로 시간여행을 할 수 있다면 어디로 가고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (53, '과거로 돌아간다면 어떤 일을 하고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (54, '무슨 날씨 좋아해요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (55, '무슨 계절 좋아해요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (56, '무슨 색을 좋아해요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (57, '요즘 가장 듣고싶은 말은 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (58, '가장 최근에 울어본 적은 언제인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (60, '좋아하는 노래가사 한 줄만 말해주세요');");
        db.execSQL("INSERT INTO QUESTION VALUES (61, '가장 좋아하는 노래는 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (62, '당신은 사랑받고 싶나요 사랑해주고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (63, '오늘 부모님은 당신을 몇번 생각 하셨을까요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (64, '진심으로 웃어 본 적이 언제인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (65, '위로 받을 때 어떤 말을 가장 듣고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (66, '마음 편히 웃고 싶나요, 울고 싶나요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (67, '행복 VS 돈 당신의 선택은?');");
        db.execSQL("INSERT INTO QUESTION VALUES (68, '요즘 가장 힘이 되는 것이 있다면 무엇인가요?');");
        db.execSQL("INSERT INTO QUESTION VALUES (69, '100억이 생긴다면 가장 먼저 사고 싶은것은?');");
        db.execSQL("INSERT INTO QUESTION VALUES (70, '요새 가장 갖고 싶은 것은?');");



    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS WiseSaying;";
        db.execSQL(sql);
        onCreate(db);
        // DB 버젼이 업데이트 될 때 테이블을 갱신해준다.
    }

}
