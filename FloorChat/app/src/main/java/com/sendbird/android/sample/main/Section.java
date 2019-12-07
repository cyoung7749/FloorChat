package com.sendbird.android.sample.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Section implements Serializable {

    private String id;
    private String name;
    private List<Section> floors;
    private String floorPlan;

    public Section(String id, String name, ArrayList<Section> floors, String floorPlan){
        this.id = id;
        this.name = name;
        this.floors = floors;
        this.floorPlan = floorPlan;
    }

    public Section(String id, String name, String floorPlan){
        this.id = id;
        this.name = name;
        this.floors = new ArrayList<>();
        this.floorPlan = floorPlan;
    }

    public Section(String id, String name){
        this.id = id;
        this.name = name;
        this.floors = new ArrayList<>();
        this.floorPlan = null;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Section> getFloors() {
        return floors;
    }

    public String getFloorPlan() {
        return floorPlan;
    }

    public Boolean hasMoreSections(){
        if(floors.isEmpty()){
            return false;
        }
        return true;
    }

    public  Boolean hasFloorplan(){
        if(floorPlan == null){
            return false;
        }
        return true;
    }
}