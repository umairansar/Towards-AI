package com.example.ansarfarid.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_action, button_drama, button_comedy, button_random;
    MyDataBase myDataBase;
    Intent intent;
    DrawerLayout drawerLayout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_id:
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://umuzworld.com/?page_id=32"));
                startActivity(browser);
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.favourites:
                Toast.makeText(MainActivity.this, "Comming Soon", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id){
                    case R.id.AI_news:
                        intent = new Intent(MainActivity.this, Website.class);
                        intent.putExtra("path", "https://www.artificialintelligence-news.com/");
                        startActivity(intent);
                        break;

                    case R.id.wired:
                        intent = new Intent(MainActivity.this, Website.class);
                        intent.putExtra("path", "https://www.wired.com/tag/artificial-intelligence/");
                        startActivity(intent);
                        break;

                    case R.id.futurism:
                        intent = new Intent(MainActivity.this, Website.class);
                        intent.putExtra("path", "https://futurism.com/");
                        startActivity(intent);
                        break;

                    case R.id.mywebsite:
                        intent = new Intent(MainActivity.this, Website.class);
                        intent.putExtra("path", "http://umuzworld.com/?cat=2");
                        startActivity(intent);
                        break;
                }

                return false;
            }
        });





        button_action = (Button) findViewById(R.id.button1);
        button_comedy = (Button) findViewById(R.id.button2);
        button_drama = (Button) findViewById(R.id.button3);
        button_random = (Button) findViewById(R.id.button4);

        myDataBase = new MyDataBase(this);
        myDataBase.update_data();

        //Populating the database with video names and paths
        NamesAndPaths namesAndPaths = new NamesAndPaths(myDataBase);

        button_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Main2Activity_action.class);
               startActivity(intent);
            }
        });

        button_comedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Main4Activity_comedy.class);
                startActivity(intent1);
            }
        });

        button_drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Main3Activity_drama.class);
                startActivity(intent2);
            }
        });

        button_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, Main5Activity_random.class);
                startActivity(intent3);
            }
        });

    }





}
