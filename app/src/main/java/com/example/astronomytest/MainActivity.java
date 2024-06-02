package com.example.astronomytest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{



    ArrayList<ThemeModel> themeModels = new ArrayList<>();

    int[] themeImages = {R.drawable.baseline_ac_unit_24, R.drawable.baseline_airplanemode_active_24, R.drawable.baseline_bedtime_24, R.drawable.baseline_auto_fix_high_24};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpThemeModels();

        T_RecyclerViewAdapter adapter = new T_RecyclerViewAdapter(this, themeModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpThemeModels() {
        String[] themeNames = getResources().getStringArray(R.array.full_themes_txt);
        String[] themeDescription = getResources().getStringArray(R.array.T_description);


        for (int i = 0; i<themeNames.length; i++){
            themeModels.add(new ThemeModel(themeNames[i],themeDescription[i],
                    themeImages[i]));
        }



    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("NAME", themeModels.get(position).getThemeNames());
        intent.putExtra("DESCRIPTION", themeModels.get(position).getThemeDescription());
        intent.putExtra("IMAGE", themeModels.get(position).getImage());

        startActivity(intent);


    }

}
