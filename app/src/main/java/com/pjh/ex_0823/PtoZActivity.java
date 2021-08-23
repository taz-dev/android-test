package com.pjh.ex_0823;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PtoZActivity extends AppCompatActivity {

    ImageView photo;
    PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptoz);

        photo = findViewById(R.id.photo);
        
        //이미지 확대축소를 위한 클래스 객체 생성
        attacher = new PhotoViewAttacher(photo);
        attacher.update();
    }
}