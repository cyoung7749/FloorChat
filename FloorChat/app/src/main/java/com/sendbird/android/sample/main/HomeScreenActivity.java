package com.sendbird.android.sample.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sendbird.android.sample.R;
import com.sendbird.android.sample.database.JsonParserTool;

import java.io.File;
import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity {

    private RecyclerView nearbyRecyclerView;
    private RecyclerView campusBuildingRecyclerView;
    BuildingAdapter nearbyAdapter;
    BuildingAdapter campusAdapter;

    ArrayList<Building> buildings;
    FloatingActionButton openChatFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        nearbyRecyclerView = findViewById(R.id.nearbyBuildingRecycler);
        campusBuildingRecyclerView = findViewById(R.id.campusBuildingRecycler);

        nearbyRecyclerView.setHasFixedSize(true);
        nearbyRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        campusBuildingRecyclerView.setHasFixedSize(true);
        campusBuildingRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        buildings = new ArrayList<>();

        ArrayList<Section> sections = new ArrayList<>();

        /** TODO:
         * this is the part where the we extract from the database and
         * assign the values to buildings
         *
         */

        String fileName = "buildings.json";
        JsonParserTool jsonParserTool = new JsonParserTool(getBaseContext(), fileName);
        buildings.add(jsonParserTool.getBuilding("Engineering Building"));

        nearbyAdapter = new BuildingAdapter(buildings);
        nearbyRecyclerView.setAdapter(nearbyAdapter);

        //more placeholders***************
        ArrayList<Building> campusBuildings = buildings;
        campusBuildings.add(new Building("building4", "Allison Road Classrooms", sections));
        //********************************

        campusAdapter = new BuildingAdapter(campusBuildings);
        campusBuildingRecyclerView.setAdapter(campusAdapter);



        openChatFAB = findViewById(R.id.openChatFAB);

        openChatFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChatActivity();
            }
        });
    }

    public void openChatActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
