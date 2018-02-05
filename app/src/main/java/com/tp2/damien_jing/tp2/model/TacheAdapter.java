package com.tp2.damien_jing.tp2.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tp2.damien_jing.tp2.R;

import java.util.List;

/**
 * Created by Admin on 2018/1/29.
 */

public class TacheAdapter extends BaseAdapter{
    protected List<Tache> mesDonnees;
    protected LayoutInflater inflater;

    public TacheAdapter(Context context,List<Tache> lesTaches){
        this.mesDonnees = lesTaches;
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return this.mesDonnees.size();
    }

    public Object getItem(int i){
        return this.mesDonnees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.tache_layout,null);
            holder.textview = (TextView)convertView.findViewById(R.id.textView3);
            holder.imageview = (ImageView)convertView.findViewById(R.id.imageView3);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textview.setText(mesDonnees.get(i).getNom());
        holder.imageview.setImageResource(mesDonnees.get(i).getCategorie().getResId());
        return convertView;

    }

    private class ViewHolder{
        protected TextView textview;
        protected ImageView imageview;


    }


}
