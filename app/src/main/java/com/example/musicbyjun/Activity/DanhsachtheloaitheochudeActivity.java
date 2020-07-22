package com.example.musicbyjun.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicbyjun.Model.ChuDe;
import com.example.musicbyjun.R;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {

    ChuDe chuDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        GetIntent();
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if(intent.hasExtra("chude")){
            chuDe = (ChuDe) intent.getSerializableExtra("chude");
            Toast.makeText(this,chuDe.getTenCHUDE(),Toast.LENGTH_SHORT).show();
        }
    }
}
