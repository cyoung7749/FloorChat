package com.example.floorchat;

import java.util.List;

public class Building {

    private String id;
    private String name;
    private List<Section> sections;

    public Building(String id, String name, List<Section> sections){
        this.id = id;
        this.name = name;
        this.sections = sections;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Section> getSections() {
        return sections;
    }
}
