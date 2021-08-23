package com.pjh.ex_0823;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class SwipeRefreshActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        swipe = findViewById(R.id.swipe);

        //디스크 배경색 변경
        swipe.setProgressBackgroundColorSchemeColor(Color.parseColor("#aaaaff"));

        //디스크 사이즈 변경
        swipe.setSize(SwipeRefreshLayout.LARGE); //디스크 사이즈 DEFAULT / LARGE

        //당겨질 최대 좌표값 설정
        swipe.setProgressViewEndTarget(true, 400);

        //당겼을 때 디스크의 시작위치 및 끝 위치 설정
        //swipe.setProgressViewOffset(false, 200, 400);

        //디스크 안에 있는 로딩속성색 변경
        swipe.setColorSchemeResources(R.color.c1, R.color.c2, R.color.c3, R.color.c4);

        //이벤트 감지자 등록
        swipe.setOnRefreshListener(rl);

    }//onCreate()

    SwipeRefreshLayout.OnRefreshListener rl = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //당겼다가 손을 땠을 때(로딩이 시작되면) 호출되는 메서드
            //Toast.makeText(SwipeRefreshActivity.this,"로딩시작", Toast.LENGTH_SHORT).show();
            //new NaverAsync().execute();
            handler.sendEmptyMessageDelayed(0, 3000); //3초 대기 후 handler 호출
        }
    };
    
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            //로딩이 끝난다고 가정하자!!
            //로딩이 완료되면 디스크를 제거
            swipe.setRefreshing(false);
        }
    };

}