package com.example.musicbyjun.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.musicbyjun.Activity.DanhsachbaihatActivity;
import com.example.musicbyjun.Activity.DanhsachtatcachudeActivity;
import com.example.musicbyjun.Model.ChuDe;
import com.example.musicbyjun.Model.TheLoai;
import com.example.musicbyjun.Model.TheLoaiTrongngay;
import com.example.musicbyjun.R;
import com.example.musicbyjun.Service.APIService;
import com.example.musicbyjun.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_chudevatheloai extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView tvXemthemchudetheloai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chudetheloai,container,false);
        getData();
        setcontrol();
        return view ;
    }

    private void setcontrol() {
        horizontalScrollView = view.findViewById(R.id.horizontalScrollViewchude);
        tvXemthemchudetheloai = view.findViewById(R.id.tvxemthemchudetheloai);
        //set sự kiện chọn cho chữ xem thêm
        tvXemthemchudetheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcachudeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<TheLoaiTrongngay> callback = dataservice.GetCategoryMusic();
        callback.enqueue(new Callback<TheLoaiTrongngay>() {
            @Override
            public void onResponse(Call<TheLoaiTrongngay> call, Response<TheLoaiTrongngay> response) {

                TheLoaiTrongngay theLoaiTrongngay = response.body();
                Log.d("theloaitrongngay",theLoaiTrongngay.getTheLoai().get(0).getTenTL());
                final ArrayList<ChuDe> mangChude = new ArrayList<>();
                mangChude.addAll(theLoaiTrongngay.getChuDe());

                final ArrayList<TheLoai> mangTheloai = new ArrayList<>();
                mangTheloai.addAll(theLoaiTrongngay.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                //cài ảnh cỡ chủ đề thể loại
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(580,450);
                layoutParams.setMargins(10,20,10,30);

                for (int i=0; i<(mangChude.size());i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);

                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    if(mangChude.get(i).getHinhCHUDE()!=null){
                        Picasso.with(getActivity()).load(mangChude.get(i).getHinhCHUDE()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);

                }

                for (int j=0; j<(mangTheloai.size());j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);

                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    if(mangTheloai.get(j).getHinhTL()!=null){
                        Picasso.with(getActivity()).load(mangTheloai.get(j).getHinhTL()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    final int final_position = j;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                            intent.putExtra("idtheloai",mangTheloai.get(final_position));
                            startActivity(intent);
                        }
                    });

                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<TheLoaiTrongngay> call, Throwable t) {

            }
        });
    }
}
