package com.pjh.ex_0823;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        //전화걸기
        if(ActivityCompat.checkSelfPermission(
                PermissionActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED){
            setPermission();
            return;
        }

        //주소록
        if(ActivityCompat.checkSelfPermission(
                PermissionActivity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED){
            setPermission();
            return;
        }

        //파일쓰기
        if(ActivityCompat.checkSelfPermission(
                PermissionActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
            setPermission();
            return;
        }

    }//onCreate()

    //권한설정 감지자
    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            //모든 권한의 수락이 완료되었을 경우 호출되는 메서드
            Intent i = new Intent(PermissionActivity.this, PermissionActivity.class);
            startActivity(i);
            finish();
        }

        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {
            //준비해둔 권한 중 한가지라도 수락이 안된 것이 있다면 호출되는 메서드
            finish();
        }
    };

    //권한설정 감지자 등록 및 사용자에게 권한에 대한 허가받기
    public void setPermission(){

        TedPermission.with(PermissionActivity.this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("이 웹에서 요구하는 권한이 있습니다.\n[설정]->[권한]에서 확인하세요")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CALL_PHONE,
                                Manifest.permission.READ_CONTACTS).check();

    }//setPermission()

}