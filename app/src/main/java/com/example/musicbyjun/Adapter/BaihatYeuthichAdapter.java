package com.example.musicbyjun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Model.BaiHat;
import com.example.musicbyjun.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaihatYeuthichAdapter extends RecyclerView.Adapter<BaihatYeuthichAdapter.ViewHolder>{
    Context context;
    ArrayList <BaiHat> baihatyeuthichArrayList;

    public BaihatYeuthichAdapter(Context context, ArrayList<BaiHat> baihatyeuthichArrayList) {
        this.context = context;
        this.baihatyeuthichArrayList = baihatyeuthichArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihatyeuthich,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baihatyeuthich = baihatyeuthichArrayList.get(position);
        holder.tvtenbaihatyeuthich.setText(baihatyeuthich.getTenBH());
        holder.tvtencasihatbhyt.setText(baihatyeuthich.getCasiBH());
        Picasso.with(context).load(baihatyeuthich.getHinhbaihat()).into(holder.imghinh);


    }

    @Override
    public int getItemCount() {
        return baihatyeuthichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvtenbaihatyeuthich, tvtencasihatbhyt;
        ImageView imghinh, imglike;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtenbaihatyeuthich = itemView.findViewById(R.id.tvtenbaihatyeuthich);
            tvtencasihatbhyt = itemView.findViewById(R.id.tvtencasibaihatyeuthich);
            imghinh =itemView.findViewById(R.id.imgvBaihatyeuthich);
            imglike = itemView.findViewById(R.id.imgvLuotthich);
        }
    }
}
