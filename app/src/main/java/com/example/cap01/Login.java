package com.example.cap01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ImageButton back_1 = (ImageButton) findViewById(R.id.back_1);
        Button login = (Button) findViewById(R.id.login);
        EditText login_id = (EditText) findViewById(R.id.login_id);
        EditText login_pw = (EditText) findViewById(R.id.login_pw);
        TextView login_text = (TextView) findViewById(R.id.login_text);

        //아이디 비밀번호 저장용
        SharedPreferences getsavedata = getSharedPreferences("idpw",MODE_PRIVATE);
        SharedPreferences.Editor setsavedata = getsavedata.edit();
        String saveid = getsavedata.getString("id","");
        String savepw = getsavedata.getString("pw","");

        //입력된 텍스트값 초기화
        login_text.setText("");


        //기존에 저장된 데이터가 있다면 로그인 입력과정 넘기기
        if(saveid != "" || savepw != ""){
            //서치에 성공했는지 실패했는지 검사
            boolean search = onlinedata(saveid,savepw);

            //서버연결쪽 으로 연결해서 있는지 없는지 체크
            if (search==false){
                login_text.setText("ID 또는 PW가 변경되었습니다.");
            }else if((search==true)){
                //로그인에 성공했다고 값을 반환하는 과정임
                //id 값과 서치에 성공했다는걸 알려주는것을 넘김
                Intent intent = new Intent();
                intent.putExtra("result_ID",saveid);
                setResult(RESULT_OK,intent);

                //액티비티 종료
                finish();
            }
        }





        //돌아가는 버튼을 눌렀을시 아무기능없이 액티비티 종료기능임
        back_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //캔슬했다고 알림(나가기 했다고)
                setResult(RESULT_CANCELED);
                finish();
            }
        });


        //로그인 버튼 누를때 작동하는것
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //아이디 패스워드 입력부분 값 받아오기
                String ID = login_id.getText().toString();
                String PW = login_pw.getText().toString();

                //ID 나 PW 가 입력값이 없을때
                if ( (ID.length() == 0) || (PW.length() == 0) ){
                    login_text.setText("ID, PW가 입력되지 않았습니다.");
                    login_text.setTextColor(Color.parseColor("#ED1C24"));
                    if(login_id.getText().length()==24){
                    }
                }
                else{
                    //서치에 성공했는지 실패했는지 검사
                    boolean search = onlinedata(ID,PW);

                    //서버연결쪽 으로 연결해서 있는지 없는지 체크
                    if (search==false){
                        login_text.setText("ID 또는 PW가 올바르지 않습니다.");
                    }else if((search==true)){
                        //로그인에 성공했다고 값을 반환하는 과정임

                        //로그인데이터 저장
                        setsavedata.putString("id",ID);
                        setsavedata.putString("pw",PW);
                        setsavedata.commit();

                        //id 값과 서치에 성공했다는걸 알려주는것을 넘김
                        Intent intent = new Intent();
                        intent.putExtra("result_ID",ID);
                        setResult(RESULT_OK,intent);

                        //액티비티 종료
                        finish();
                    }

                }
            }
        });

    }

    private boolean onlinedata(String ID, String PW){

        //서버 연결과 관련되서 아이디가 있는지 없는지 체크할 예정
        /*
        if(ID 와 PW 가 맞지 않을 때){

            return false;
        }
        else{
            return true;
        }

         */
        return true;
    }
}

