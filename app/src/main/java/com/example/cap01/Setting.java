package com.example.cap01;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class Setting extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settinglayout);


        //이 방법 말고 현재 셋팅 화면 말고 다른화면도 쓸수 있어서 화면전환 플래그먼트 사용하게 만듬
        //설정화면 화면전환에 도움줄 플래그먼트 매니저
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        SettingFragment settingFragment = new SettingFragment();
        //셋팅 입장시 초기화면 설정
        fragmentTransaction.add(R.id.Setting_FrameLayout,settingFragment).commit();

        ImageButton back_3 = (ImageButton) findViewById(R.id.back_3);

        //나가기 누르면 화면을 바로 끝내고 이전에 켜져있던 화면으로 돌아감ㅇ
        back_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
