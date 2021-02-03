package com.dotter.doctoruntact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class PopupActivity extends Activity {

    TextView txtText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        //UI 객체생성
        txtText = (TextView)findViewById(R.id.txtText);

    }

    //확인 버튼 클릭
    public void mOnClose(View v){

        //데이터 받아오기
        Intent intent = getIntent();
        final String userid = intent.getStringExtra("userid"); //userid 받아오기
        final String name = intent.getStringExtra("name");
        final String title = intent.getStringExtra("title");

        //데이터 전달하기
        Intent intent_toMessage = new Intent(this,MessageActivity.class);
        intent_toMessage.putExtra("userid",userid); // 작성자 id 넘겨주기
        intent_toMessage.putExtra("name",name);
        intent_toMessage.putExtra("title",title);
        startActivity(intent_toMessage);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    /*@Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }*/
}

