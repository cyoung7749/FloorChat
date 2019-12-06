package com.example.floorchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
