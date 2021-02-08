package com.dotter.doctoruntact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import androidx.annotation.NonNull;
import model.Board;
import Adapter.BoardAdapter;
import model.Chat;

public class PopupActivity extends Activity {

    TextView txtText;
    DatabaseReference reference;
    ValueEventListener matchListner;

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

        matchBoard(userid,title);

        //데이터 전달하기
        Intent intent_toMessage = new Intent(this,MessageActivity.class);
        intent_toMessage.putExtra("userid",userid); // 작성자 id 넘겨주기
        intent_toMessage.putExtra("name",name);
        intent_toMessage.putExtra("title",title);
        startActivity(intent_toMessage);

    }

    public void mOnClose2(View v)
    {
        Intent intent_re = new Intent(this,StartActivity.class);
        startActivity(intent_re);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    private void matchBoard(final String userid,final String title) {
        reference = FirebaseDatabase.getInstance().getReference("Board");
        matchListner = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Board board;
                    board = snapshot.getValue(Board.class);

                    assert board != null;
                    if (board.getId().equals(userid) && !board.isMatch() && board.getTitle().equals(title)) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("match", true);
                        snapshot.getRef().updateChildren(hashMap);

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });//seen확인

    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        super.onBackPressed();
    }
}

