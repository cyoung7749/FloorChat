package com.sendbird.android.sample.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sendbird.android.sample.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.BuildingViewHolder> {
    ArrayList<Section> sections;
    String pastTitle;

    public SectionAdapter(ArrayList<Section> sections){

        this.sections = sections;
    }

    public SectionAdapter(ArrayList<Section> sections, String pastTitle){
        this.sections = sections;
        this.pastTitle = pastTitle;
    }

    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_recycler, parent, false);

        BuildingViewHolder holder = new BuildingViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position){
        holder.building.setText(sections.get(position).getName());
    }

    @Override
    public int getItemCount(){
        return sections.size();
    }

    public class BuildingViewHolder extends RecyclerView.ViewHolder{
        TextView building;

        public BuildingViewHolder(View v){
            super(v);
            building = v.findViewById(R.id.buildingName);
            final Context context = v.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int p = getLayoutPosition();
                    System.out.println("Click: " + p);

                    if(sections.get(p).hasMoreSections()){
                        Intent section = new Intent(context, SectionActivity.class);
                        section.putExtra("sections", (Serializable) sections.get(p).getFloors());

                        section.putExtra("buildingName", pastTitle);
                        section.putExtra("sectionName", sections.get(p).getName());
                        context.startActivity(section);
                    } else if(sections.get(p).hasFloorplan()){

                        Intent floorplan = new Intent(context, FloorplanActivity.class);
                        floorplan.putExtra("floorPlan", sections.get(p).getFloorPlan());
                        context.startActivity(floorplan);
                    } else {
                        CharSequence message = "Floorplan for " + sections.get(p).getName() + " is not available";
                        Toast t = Toast.makeText(context, message, Toast.LENGTH_LONG);
                        t.show();
                    }


                }
            });
        }


    }
}
