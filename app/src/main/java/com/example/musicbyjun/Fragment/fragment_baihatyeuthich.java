package com.example.musicbyjun.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Adapter.BaihatYeuthichAdapter;
import com.example.musicbyjun.Model.BaiHat;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_baihatyeuthich extends Fragment {
    View view;
    RecyclerView recyclerViewbhyeuthich;
    BaihatYeuthichAdapter bhytadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat_yeuthich,container,false);
        getData();
        setcontrol();
        return view;
    }

    private void setcontrol() {
        recyclerViewbhyeuthich = view.findViewById(R.id.recyclevieBhyeuthich);
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetBaihatYeuthich();
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> mangbhyt = (ArrayList<BaiHat>) response.body();
                bhytadapter = new BaihatYeuthichAdapter(getActivity(),mangbhyt);
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbhyeuthich.setLayoutManager(linearLayoutManager);
                recyclerViewbhyeuthich.setAdapter(bhytadapter);

            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
