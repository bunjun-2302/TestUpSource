package com.example.musicbyjun.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Adapter.AlbumAdapter;
import com.example.musicbyjun.Model.Album;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_album_hot extends Fragment {
    View view;
    RecyclerView recyclerViewAlbum;
    TextView tvxemthemAlbum;
    AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album_hot,container,false);
        getData();
        setcontrol();
        return view;
    }

    private void setcontrol() {
        recyclerViewAlbum = view.findViewById(R.id.recyclevieAlbum);
        tvxemthemAlbum = view.findViewById(R.id.tvxemthemalbum);
    }

    private void getData() {

        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbumHot();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangAlbum = (ArrayList<Album>) response.body();
                Log.d("Album",mangAlbum.get(0).getTenAlbum());
                albumAdapter = new AlbumAdapter(getActivity(),mangAlbum);
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
                recyclerViewAlbum.setLayoutManager(linearLayoutManager);
                recyclerViewAlbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
