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

import java.util.ArrayList;

public class DanhsachBaiHatAdapter extends RecyclerView.Adapter<DanhsachBaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList <BaiHat> mangdsbaihat;

    public DanhsachBaiHatAdapter(Context context, ArrayList<BaiHat> mangdsbaihat) {
        this.context = context;
        this.mangdsbaihat = mangdsbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachbaihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BaiHat baiHat = mangdsbaihat.get(position);
        holder.tvsttbh.setText(position+1+"");
        holder.tvtenbhtrongdsbh.setText(baiHat.getTenBH());
        holder.tvtenCStrongdsbh.setText(baiHat.getCasiBH());

    }

    @Override
    public int getItemCount() {
        return mangdsbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvsttbh, tvtenbhtrongdsbh, tvtenCStrongdsbh;
        ImageView imgliketrongqc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvsttbh = itemView.findViewById(R.id.tvSTTdsbh);
            tvtenbhtrongdsbh = itemView.findViewById(R.id.tvTenbhTrongdsbh);
            tvtenCStrongdsbh = itemView.findViewById(R.id.tvTenCStrongdsbh);
            imgliketrongqc = itemView.findViewById(R.id.imgvLuotthichinqc);
        }
    }
}
