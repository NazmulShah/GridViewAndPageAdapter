package com.example.user.arraylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by User on 12/18/2015.
 */
public class SingleViewActivity extends Activity {

    ViewPager viewPager;
    PagerAdapter adapter,mPagerAdapter;

    Button first , last;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view);



        //get intent data
        Intent i = getIntent();

        //selected image id
        int positionfirst = i.getExtras().getInt("id");

        ArrayList<Item> item = (ArrayList<Item>) getIntent().getSerializableExtra("rowItems");

        // Declare Variables


            //System.out.println(item.size());
        Log.e("nazmul","size"+item.size());

        for(int j=0;j<item.size();j++){

           // System.out.println(item.get(j));
            Log.e("nazmul", "size" + item.get(j).getName());
        }


        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.view_pager);



        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(SingleViewActivity.this,item);

        // mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(positionfirst);

        //Toast.makeText(this, position, Toast.LENGTH_LONG).show();
    }





}