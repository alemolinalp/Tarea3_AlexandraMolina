package com.example.alexandramolina.tarea3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alexandramolina on 12/3/18.
 */

public class CustomMusicAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private ArrayList<Musica> arrayList;

    public CustomMusicAdapter(Context context, int layout, ArrayList<Musica> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView textViewSong, textViewArtist;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            viewHolder.textViewSong = view.findViewById(R.id.textView);
            viewHolder.textViewArtist = view.findViewById(R.id.textView2);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final Musica music = arrayList.get(i);
        viewHolder.textViewSong.setText(music.getCancion());
        viewHolder.textViewArtist.setText(music.getArtista());

        return view;
    }
}
