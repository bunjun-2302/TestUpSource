package com.example.musicbyjun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicbyjun.Model.Playlist;
import com.example.musicbyjun.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView tvTenpl;
        ImageView imgvBackground, imfvPl;
    }

    //gan layout cho list
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //cap phat bo nho
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            //setcontrol
            viewHolder.tvTenpl = convertView.findViewById(R.id.tvTenPl);
            viewHolder.imfvPl = convertView.findViewById(R.id.imgViewPl);
            viewHolder.imgvBackground = convertView.findViewById(R.id.imgvBackgroundPl);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // moi dong co 1 du lieu
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlaylist()).into(viewHolder.imgvBackground);
        Picasso.with(getContext()).load(playlist.getIconPlaylist()).into(viewHolder.imfvPl);
        viewHolder.tvTenpl.setText(playlist.getTenPlaylist());

        return convertView;
    }
}
