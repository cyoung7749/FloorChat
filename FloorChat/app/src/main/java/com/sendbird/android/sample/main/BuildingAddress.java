package com.sendbird.android.sample.main;

import android.content.Context;
import android.location.Location;

import com.sendbird.android.sample.database.JsonParserTool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BuildingAddress {
    private String name;
    private String address;
    public String[] addressArray = new String[6];
    Location location;
    public BuildingAddress(String name, String address, Context context){
        this.address = address;
        this.name = name;

        String fileName = "buildingsAddress";
        String filePath = JsonParserTool.getPathFromAssets(context, fileName);
        String jsonString = JsonParserTool.usingBufferedReader(filePath);

        try {
            JSONObject jObject = new JSONObject(jsonString);
            jObject.length();
            JSONArray jArray = jObject.getJSONArray("buildingAddress");
            //for loop

            JSONObject eng_buildingjObject0 = jArray.getJSONObject(0);
            addressArray[0] = eng_buildingjObject0.getString("address");
            JSONObject eng_buildingjObject1 = jArray.getJSONObject(1);
            addressArray[1] = eng_buildingjObject1.getString("address");
            JSONObject eng_buildingjObject2 = jArray.getJSONObject(2);
            addressArray[2] = eng_buildingjObject2.getString("address");
            JSONObject eng_buildingjObject3 = jArray.getJSONObject(3);
            addressArray[3] = eng_buildingjObject3.getString("address");
            JSONObject eng_buildingjObject4 = jArray.getJSONObject(4);
            addressArray[4] = eng_buildingjObject4.getString("address");
            JSONObject eng_buildingjObject5 = jArray.getJSONObject(5);
            addressArray[5] = eng_buildingjObject5.getString("address");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
