package com.example.musicbyjun.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Adapter.DanhsachtatcachudeApdapter;
import com.example.musicbyjun.Model.ChuDe;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcachudeActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllchude;
    Toolbar toolbarAllchude;
    DanhsachtatcachudeApdapter danhsachtatcachudeApdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        setControl();
        getData();
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDe>> callback =dataservice.GetAllchude();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                //Log.d("showallchude",mangchude.get(0).getTenCHUDE());
                danhsachtatcachudeApdapter = new DanhsachtatcachudeApdapter(DanhsachtatcachudeActivity.this,mangchude);
                recyclerViewAllchude.setLayoutManager(new GridLayoutManager(DanhsachtatcachudeActivity.this,1));
                recyclerViewAllchude.setAdapter(danhsachtatcachudeApdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void setControl() {
        recyclerViewAllchude = findViewById(R.id.recyclevieAllchude);
        toolbarAllchude = findViewById(R.id.toolbarallchude);
        setSupportActionBar(toolbarAllchude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tat ca chu de");
        toolbarAllchude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
