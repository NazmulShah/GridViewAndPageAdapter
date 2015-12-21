package com.example.user.arraylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    GridView gridView;
    public  ArrayList<Item> rowItems;


    public static final String[] name = {"Rahim","karim","siddiq","Rahim","karim","siddiq","Rahim","karim","siddiq"};
    public static final String[] describtion = {"Rahim vlo cele","karim kharap sele","siddiq both","Rahim vlo cele","karim kharap sele","siddiq both","Rahim vlo cele","karim kharap sele","siddiq both"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItems = new ArrayList<Item>();
        for(int i =0; i<name.length;i++)
        {
            Item item = new Item(name[i],describtion[i]);
            rowItems.add(item);
        }


        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new TextAdapter(this, rowItems));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
                //Intent i = new Intent(getApplicationContext(),ImageSwitcherExampleActivity.class);

                // Pass image index
                i.putExtra("id", position);
                i.putExtra("rowItems",rowItems);

                startActivity(i);
            }
        });

    }




}
