package com.sendbird.android.sample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ortiz.touchview.TouchImageView;
import com.sendbird.android.sample.R;
import com.sendbird.android.sample.utils.PhotoViewerActivity;

public class FloorplanActivity extends AppCompatActivity {

    TouchImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floorplan);
        imageView = findViewById(R.id.floorPlanView);

        String floorPlanName = getIntent().getStringExtra("floorPlan");

        imageView.setImageResource(getFloorPlanImage(floorPlanName));



    }

    private int getFloorPlanImage(String imageName){
        int drawableId = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());
        return drawableId;
    }


}
