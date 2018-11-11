package com.example.ansarfarid.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main5Activity_random extends AppCompatActivity {

    MyDataBase myDataBase;
    ListView lv;
    String Table = "RANDOM_TABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_random);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();


        myDataBase = new MyDataBase(this);
        lv = (ListView) findViewById(R.id.listview_random);


        display();
    }

    public void display(){
        Cursor data = myDataBase.getAllDATA(Table);
        final ArrayList<String> list = new ArrayList<>();
        final ArrayList<String> list_path = new ArrayList<>();

        if(data.getCount() == 0){
            Toast.makeText(this, "Data Retrieval Failed!", Toast.LENGTH_LONG).show();
        }

        while(data.moveToNext()){
            list.add(data.getString(1));
            list_path.add(data.getString(2));
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //videoPlayer = new VideoPlayer(list_path.get(position));
                Intent intent = new Intent(Main5Activity_random.this, VideoPlayer.class);
                intent.putStringArrayListExtra("complete_name", list);
                intent.putStringArrayListExtra("complete_path", list_path);
                intent.putExtra("position", position);
                intent.putExtra("total positions", lv.getAdapter().getCount());
                intent.putExtra("path", list_path.get(position));
                intent.putExtra("name", list.get(position));
                startActivity(intent);
            }
        });
    }


}
