package com.sendbird.android.sample.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sendbird.android.sample.R;

import java.io.Serializable;
import java.util.ArrayList;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder> {
    ArrayList<Building> buildings;

    public BuildingAdapter(ArrayList<Building> buildings){
        this.buildings = buildings;
    }

    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_recycler, parent, false);

        BuildingViewHolder holder = new BuildingViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position){
        holder.building.setText(buildings.get(position).getName());
    }

    @Override
    public int getItemCount(){
        return buildings.size();
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

                    Intent section = new Intent(context, SectionActivity.class);
                    section.putExtra("sections", (Serializable) buildings.get(p).getSections());
                    context.startActivity(section);

                }
            });
        }


    }
}
