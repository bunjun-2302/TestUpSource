package com.example.musicbyjun.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbyjun.Activity.DanhsachbaihatActivity;
import com.example.musicbyjun.Model.Playlist;
import com.example.musicbyjun.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShowdanhsachPlaylistAdapter extends RecyclerView.Adapter<ShowdanhsachPlaylistAdapter.ViewHolder> {
    Context context;
    ArrayList<Playlist> mangshowAllplaylist;

    public ShowdanhsachPlaylistAdapter(Context context, ArrayList<Playlist> mangshowAllplaylist) {
        this.context = context;
        this.mangshowAllplaylist = mangshowAllplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_showdanhdachplaylist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = mangshowAllplaylist.get(position);
        Picasso.with(context).load(playlist.getHinhPlaylist()).into(holder.imgvHinhplshowall);
        holder.tvtenplshowall.setText(playlist.getTenPlaylist());
    }

    @Override
    public int getItemCount() {
        return mangshowAllplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgvHinhplshowall;
        TextView tvtenplshowall,tvtencsshowall;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgvHinhplshowall = itemView.findViewById(R.id.imgvHinhplShowallDanhsachpl);
            tvtenplshowall =itemView.findViewById(R.id.tvTenplShowallDspl);
            tvtencsshowall = itemView.findViewById(R.id.tvTencsShowallDspl);
            //chuyển activity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist",mangshowAllplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
