package com.sendbird.android.sample.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.View;

import com.sendbird.android.sample.R;

import java.util.ArrayList;

public class SectionActivity extends AppCompatActivity {

    private TextView buildingName;
    private TextView sectionName;
    private RecyclerView sectionRecyclerView;
    SectionAdapter adapter;
    FloatingActionButton openChatFAB;

    ArrayList<Section> sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        buildingName = findViewById(R.id.buildingName);
        sectionName = findViewById(R.id.sectionNameTextView);
        openChatFAB = findViewById(R.id.openChatFAB);

        openChatFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChatActivity();
            }
        });

        sectionRecyclerView = findViewById(R.id.sectionRecycler);
        sectionRecyclerView.setHasFixedSize(true);
        sectionRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        sections = (ArrayList<Section>) getIntent().getSerializableExtra("sections");
        String building = getIntent().getStringExtra("buildingName");
        String section = getIntent().getStringExtra("sectionName");

        buildingName.setText(building);
        if(section!=null){
            sectionName.setText(section);
        } else{
            sectionName.setText("");
        }

        adapter = new SectionAdapter(sections, buildingName.getText().toString());
        sectionRecyclerView.setAdapter(adapter);
    }

    public void openChatActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
