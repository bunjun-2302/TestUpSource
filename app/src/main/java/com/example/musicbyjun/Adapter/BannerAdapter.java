package com.example.musicbyjun.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.musicbyjun.Activity.DanhsachbaihatActivity;
import com.example.musicbyjun.Model.QuangCao;
import com.example.musicbyjun.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> arrListBanner;

    public BannerAdapter(Context context, ArrayList<QuangCao> arrListBanner) {
        this.context = context;
        this.arrListBanner = arrListBanner;
    }
    @Override
    public int getCount() {
        return arrListBanner.size();// trong mảng có bao nhiêu tấm hình thì có bấy nhiêu cái pager. nên căn theo size mảng
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { // trả về view tùy vào từng object
        return view == object;
    }

    //định hình và gán dữ liệu cho từng object
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);
        //setcontrol
        ImageView imgbackgrBanner = view.findViewById(R.id.imaginebackgroundBanner);
        ImageView songbanner = view.findViewById(R.id.imagineViewbanner);
        TextView titlesongbanner = view.findViewById(R.id.titlebannerbaihat);
        TextView titlenoidung = view.findViewById(R.id.titlenoidungbaihat);

        //load dữ liệu từng mảng nào, tại vị trí gì, vào phần layout nào
        Picasso.with(context).load(arrListBanner.get(position).getHinhQC()).into(imgbackgrBanner);
        Picasso.with(context).load(arrListBanner.get(position).getHinhBH()).into(songbanner);

        //truyền vào vị trí các titile từ dữ liệu lấy từ mảng
        titlesongbanner.setText(arrListBanner.get(position).getTenBH());
        titlenoidung.setText(arrListBanner.get(position).getNoidungQC());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("banner",arrListBanner.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
