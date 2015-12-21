package com.example.user.arraylist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 12/18/2015.
 */
public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<Item> item;


    public ViewPagerAdapter(Context context, ArrayList<Item> item) {
        this.context =context;
        this.item = item;
        Log.e("nazmul","adapter:item size"+item.size());
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {



        LayoutInflater inflater;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        textView =(TextView) itemView.findViewById(R.id.text1);
        describ =(TextView) itemView.findViewById(R.id.text2);



       // textView.setText(item.get());
       // textView.setText(a[position]);
        textView.setText(item.get(position).getName().toString());
        describ.setText(item.get(position).getDescription().toString());

        ((ViewPager) container).addView(itemView);

        return itemView;
    }




    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);

    }

    TextView textView,describ;
}