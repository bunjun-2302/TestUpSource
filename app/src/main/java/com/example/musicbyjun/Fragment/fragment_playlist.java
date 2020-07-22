package com.example.musicbyjun.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.musicbyjun.Activity.DanhsachbaihatActivity;
import com.example.musicbyjun.Activity.ShowDanhsachPlaylistActivity;
import com.example.musicbyjun.Adapter.PlaylistAdapter;
import com.example.musicbyjun.Model.Playlist;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_playlist extends Fragment {
    View view;
    ListView lvPlaylist;
    TextView tvTitilePl,tvXemthemPl;
    PlaylistAdapter playlistAdapter;
    ArrayList <Playlist> mangplaylists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        getData();
        setControl();
        tvXemthemPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShowDanhsachPlaylistActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void setControl() {
        lvPlaylist = view.findViewById(R.id.listviewPlaylist);
        tvTitilePl = view.findViewById(R.id.textviewTitlePlaylist);
        tvXemthemPl =view.findViewById(R.id.textviewViewmorePlaylist);
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        //dataservice tra ve cai gi thi call ve cai do
        Call<List<Playlist>> callback = dataservice.GetPlaylistCurrent();
        //su kien lang nghe va su kien khi that bai
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                mangplaylists = (ArrayList<Playlist>) response.body();
                //Log.d("Playlist",mangplaylists.get(0).getTenPlaylist());
                playlistAdapter = new PlaylistAdapter(getActivity(),android.R.layout.simple_list_item_1,mangplaylists);
                lvPlaylist.setAdapter(playlistAdapter);
                setListViewHeightBasedOnChildren(lvPlaylist);

                lvPlaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                        Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                        //đặt cờ để gọi bên activity danh sach bài hát
                        // chỗ này muốn gọi posotion được thì phải implement Seriable ở model Playlist
                        intent.putExtra("itemplaylist",mangplaylists.get(position));
                        startActivity(intent);

                    }
                });

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }
    // set chieu cao cho playlist cho đẹp màn hình
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
