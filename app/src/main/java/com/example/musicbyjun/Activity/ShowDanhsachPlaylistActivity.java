package com.example.musicbyjun.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Adapter.ShowdanhsachPlaylistAdapter;
import com.example.musicbyjun.Model.Playlist;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDanhsachPlaylistActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerViewShowAllPlaylist;
    ShowdanhsachPlaylistAdapter showdanhsachPlaylistAdapter;
    ArrayList<Playlist> mangshowalldanhsachplaylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_danhsach_playlist);
        setControl();
        setView();
        getData();
    }

    private void getData() {

        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetAllDanhsachPlaylist();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                mangshowalldanhsachplaylist = (ArrayList<Playlist>) response.body();

                showdanhsachPlaylistAdapter = new ShowdanhsachPlaylistAdapter(ShowDanhsachPlaylistActivity.this, mangshowalldanhsachplaylist);
                //căn chỉnh số cột show danh sách playlist
                recyclerViewShowAllPlaylist.setLayoutManager(new GridLayoutManager(ShowDanhsachPlaylistActivity.this,2));
                recyclerViewShowAllPlaylist.setAdapter(showdanhsachPlaylistAdapter);

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void setView() {
        setSupportActionBar(toolbar);
        //tao view
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // dat ten toolbar
        getSupportActionBar().setTitle("Playlist");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mauhongtim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.toolbardanhsachplaylist);
        recyclerViewShowAllPlaylist = findViewById(R.id.recycleViewShowAllPlaylist);
    }
}
