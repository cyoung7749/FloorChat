package com.sendbird.android.sample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sendbird.android.sample.R;

import java.util.ArrayList;

public class SectionActivity extends AppCompatActivity {

    private RecyclerView sectionRecyclerView;
    SectionAdapter adapter;

    ArrayList<Section> sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        sectionRecyclerView = findViewById(R.id.sectionRecycler);
        sectionRecyclerView.setHasFixedSize(true);
        sectionRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        sections = (ArrayList<Section>) getIntent().getSerializableExtra("sections");
        adapter = new SectionAdapter(sections);
        sectionRecyclerView.setAdapter(adapter);
    }
}
