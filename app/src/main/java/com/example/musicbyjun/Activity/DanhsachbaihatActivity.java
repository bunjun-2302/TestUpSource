package com.example.musicbyjun.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Adapter.DanhsachBaiHatAdapter;
import com.example.musicbyjun.Model.BaiHat;
import com.example.musicbyjun.Model.Playlist;
import com.example.musicbyjun.Model.QuangCao;
import com.example.musicbyjun.Model.TheLoai;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {

    ImageView imgdsbhqc;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewshowAlldsbh;
    FloatingActionButton floatingActionButtonforshowalllist;
    ArrayList<BaiHat> mangbaihatpl,mangbaihat;


    DanhsachBaiHatAdapter danhsachBaiHatAdapter;
    QuangCao quangcao;
    Playlist playlist;
    TheLoai theloai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        //hàm để gọi sự kiện nhận acticity mới như setcontrol setevent
        DataIntent();
        setControl();
        setEvent();

        if (quangcao != null && !quangcao.getTenBH().equals("")){
            //gan len view collapsion
            setValueOnView(quangcao.getTenBH(),quangcao.getHinhBH());
            //lay du lieu ve
            getDataQuangcao(quangcao.getIdQC());
        }
        if (playlist!= null &&!playlist.getTenPlaylist().equals("")){
            setValueOnView(playlist.getTenPlaylist(),playlist.getHinhPlaylist());
            //lấy dữ liệu vè
            getDataPlaylist(playlist.getIdPlaylist());
        }
        if (theloai!= null &&!theloai.getTenTL().equals("")){
            setValueOnView(theloai.getTenTL(),theloai.getHinhTL());
            //lấy dữ liệu vè
            getDataTheloai(theloai.getIdTL());
        }
    }
    //doc du lieu
    //THELOAI
    private void getDataTheloai (String idtheloai){
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetDanhsachbaihatTheoTheLoai(idtheloai);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhsachBaiHatAdapter = new DanhsachBaiHatAdapter(DanhsachbaihatActivity.this,mangbaihat);
                recyclerViewshowAlldsbh.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewshowAlldsbh.setAdapter(danhsachBaiHatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
    //QUANGCAO
    private void getDataQuangcao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetDanhsachBaihatTheoQuangCao(idquangcao);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhsachBaiHatAdapter = new DanhsachBaiHatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewshowAlldsbh.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewshowAlldsbh.setAdapter(danhsachBaiHatAdapter);      
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });

    }
    //PLAYLIST
    private void getDataPlaylist(String idplaylist) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> calback = dataservice.GetDanhSachBaihatTheoPlaylist(idplaylist);
        calback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                //bản chất là giống nhau
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhsachBaiHatAdapter = new DanhsachBaiHatAdapter(DanhsachbaihatActivity.this,mangbaihat);
                recyclerViewshowAlldsbh.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewshowAlldsbh.setAdapter(danhsachBaiHatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void setValueOnView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            //do đường dẫn là url nên cần đổi n thành dạng bitmap mới gắn đc dữ liệu
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            //sau khi co dang bitmap roi thi ta thuc hien convert du lieu
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            //gan layout
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //gan hinh anh vao view
        Picasso.with(this).load(hinh).into(imgdsbhqc);

    }




    private void setEvent() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);




    }

    private void setControl() {
        coordinatorLayout = findViewById(R.id.coordinatorlayoutquangcao);
        collapsingToolbarLayout =findViewById(R.id.collaplayoutquangcao);
        toolbar = findViewById(R.id.toolbardanhsachnhac);
        recyclerViewshowAlldsbh = findViewById(R.id.recycleViewShowAlldsbaihatqc);
        floatingActionButtonforshowalllist =findViewById(R.id.floatbuttonLoadAllds);
        imgdsbhqc = findViewById(R.id.imgdsbaihatqc);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangcao = (QuangCao) intent.getSerializableExtra("banner");
                Toast.makeText(this,quangcao.getTenBH(),Toast.LENGTH_SHORT).show();
            }
            if(intent.hasExtra("itemplaylist")){
                playlist = (Playlist) intent.getSerializableExtra("itemplaylist");
            }
            if(intent.hasExtra("idtheloai")){
                theloai = (TheLoai) intent.getSerializableExtra("idtheloai");
            }
        }
    }
}
