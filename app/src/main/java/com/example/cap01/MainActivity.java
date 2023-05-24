package com.example.cap01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_enter = (Button) findViewById(R.id.login_enter);

        //로그인 화면을 띄우기 위해 화면을 옮김
        login_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivityForResult(login,1);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {   //1의 경우 로그인 시도
            case 1 :
                if(resultCode == RESULT_OK)
                { //로그인에 성공했음으로 다음화면을 띄워주는 과정
                    Intent myPage = new Intent(getApplicationContext(), MyPage.class);
                    //아이디 값을 받아옴
                    String ID = data.getStringExtra("result_ID");

                    //서치할 수 있도록 id 값을 넘겨주고 추가적으로 화면을 실행시킴
                    myPage.putExtra("ID",ID);
                    startActivityForResult(myPage,2);

                }
                else if(resultCode == RESULT_CANCELED)
                {
                    //그냥 나갔을시 따로 작동하는것은 없고 특별한 무언가 넣을것 아니면 내용물 비워두셈
                }else
                {
                    //만약 이 기능이 작동환다면 오류가 있어서 로그인도 안된 상태임 (원인은 로그인을 마구 눌렀을 때로 예상됨 이게 아니라면 모름)
                    Toast toast = Toast.makeText(this.getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            case 2 :
                if(resultCode == RESULT_OK) {

                } // 그냥 나왔을때.
                else if (resultCode == RESULT_CANCELED){
                    //앱을 끝냈음으로 그대로 끝냄
                    finish();
                }
                break;

        }
    }
}

