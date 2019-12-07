package com.sendbird.android.sample.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sendbird.android.sample.R;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.BuildingViewHolder> {
    ArrayList<Section> sections;

    public SectionAdapter(ArrayList<Section> sections){

        this.sections = sections;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int p = getLayoutPosition();
                    System.out.println("Click: " + p);
                }
            });
        }


    }
}
