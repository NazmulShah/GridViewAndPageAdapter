package com.example.user.arraylist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 12/18/2015.
 */
public class TextAdapter extends BaseAdapter{

    Context context;
    List <Item> Item;
    public TextAdapter(Context context,List<Item> item) {
        this.context = context;
        this.Item = item;
    }

    @Override
    public int getCount() {
        return Item.size();
    }

    @Override
    public Object getItem(int position) {
        return Item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater minflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.custom_cell, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.friend_name);
            //holder.age = (TextView) convertView.findViewById(R.id.tv_textview2);
            //holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        Item rowItem = (com.example.user.arraylist.Item) getItem(position);

        holder.name.setText(rowItem.getName());
      //  holder.age.setText(""+rowItem.getageid());
        // holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }


    private class ViewHolder {
        TextView name,age;
    }




}
