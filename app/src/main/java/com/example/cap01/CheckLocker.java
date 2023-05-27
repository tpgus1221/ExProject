package com.example.cap01;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheckLocker extends AppCompatActivity {
    private LinearLayout lockerlayout1, lockerlayout2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_locker);
        lockerlayout1 = findViewById(R.id.locker1);
        lockerlayout2 = findViewById(R.id.locker2);

        int locker_1 = 0; // locker_1 값
        int locker_2 = 1; // locker_2 값

        if (locker_1 == 0)
            lockerlayout1.setBackgroundColor(Color.GREEN);
        else
            lockerlayout1.setBackgroundColor(Color.RED);

        if (locker_2 == 0)
            lockerlayout2.setBackgroundColor(Color.GREEN);
        else
            lockerlayout2.setBackgroundColor(Color.RED);

    }
}