package com.example.cap01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyPage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        Intent getID = getIntent();
        String ID = getID.getStringExtra("ID");
        String Name;

        TextView user_name = (TextView) findViewById(R.id.user_name);
        ImageButton back_2 = (ImageButton) findViewById(R.id.back_2);
        ImageButton setting = (ImageButton) findViewById(R.id.setting_1);
        Button check_locker = (Button) findViewById(R.id.check_locker);
        Button OC_log = (Button) findViewById(R.id.OC_log);
        Button logout = (Button) findViewById(R.id.logout);
        Button Del_account = (Button) findViewById(R.id.Del_account);

        /*
        //아이디 값을 통해 데이터베이스로 이름 찾는 과정
        ID 를 통해 해당 ID 위치를 서치
         아이디 위치를 통해 규정된 DB 값으로 이름을 찾아서 name 에다가 집어넣음
        */

        //임시로 name 에 id 값 그대로 집어넣음 바로 아래꺼는 실제로 구현시 주석처리 혹은 삭제
        Name = ID;
        //이름을 찾앗을때 누구라고 적음
        user_name.setText(Name+"님");


        //돌아가기 버튼 눌렀을때 아무것도 안하고 돌아감
        back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        //톱니바퀴 모양(설정버튼) 눌렀을때
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting_I = new Intent(getApplicationContext(), Setting.class);
                startActivity(setting_I);
            }
        });


        check_locker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locker_I = new Intent(getApplicationContext(), CheckLocker.class);
                startActivity(locker_I);
            }
        });



    }
}
