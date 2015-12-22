package com.example.user.arraylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends Activity {

    GridView gridView;
    public  ArrayList<Item> rowItems;


  /*  public static final String[] name = {"Rahim","karim","siddiq","Rahim","karim","siddiq","Rahim","karim","siddiq"};
    public static final String[] describtion = {"Rahim vlo cele","karim kharap sele","siddiq both","Rahim vlo cele","karim kharap sele","siddiq both","Rahim vlo cele","karim kharap sele","siddiq both"};
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        rowItems = new ArrayList<Item>();


        // Reading text file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getAssets().open(
                    "jsondata.txt")));
            String temp;
            while ((temp = br.readLine()) != null)
                // Log.e("name",":"+temp);
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
            String myjsonstring = sb.toString();


            // Try to parse JSON
            try {
// Creating JSONObject from String
                JSONObject jsonObjMain = new JSONObject(myjsonstring);

// Creating JSONArray from JSONObject
                JSONArray jsonArray = jsonObjMain.getJSONArray("employee");

// JSONArray has four JSONObject
                for (int i = 0; i < jsonArray.length(); i++) {

// Creating JSONObject from JSONArray
                    JSONObject jsonObj = jsonArray.getJSONObject(i);

// Getting data from individual JSONObject
                    int id = jsonObj.getInt("id");
                    String name = jsonObj.getString("name");
                    String city = jsonObj.getString("city");
                    String gender = jsonObj.getString("gender");
                    int age = jsonObj.getInt("id");

                    Item item = new Item(name,city);
                    rowItems.add(item);


                }

            } catch (JSONException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }







        }


        /*for(int i =0; i<jsonArray.length();i++)
        {
           *//* Item item = new Item(name[i],describtion[i]);
            rowItems.add(item);*//*
            JSONObject aobj = null;
            try {
                aobj = jsonArray.getJSONObject(i);


                String  name = aobj.getString("id");
                String sex = aobj.getString("sex");
                String describtion = aobj.getString("name");

                Log.e("nazmul","check string"+ name);



            } catch (JSONException e) {
                e.printStackTrace();
            }



            Item item;

            item = new Item(name,describtion);
            //rowItems.add(item);
        }
**/

//       for(int i =0; i<name.length;i++)
//        {
//         Item item = new Item(name[i],describtion[i]);
//            rowItems.add(item);
//
//        }


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
