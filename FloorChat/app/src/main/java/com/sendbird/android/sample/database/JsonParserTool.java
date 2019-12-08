package com.sendbird.android.sample.database;

import android.content.Context;

import com.sendbird.android.sample.main.Building;
import com.sendbird.android.sample.main.Section;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonParserTool {

    private String filePath;
    private String jsonString;
    private JSONObject jsonObject;

    public JsonParserTool(Context context, String fileName){
        getJsonFromAssets(context, fileName);
        this.jsonString = usingBufferedReader(filePath);
        try {
            this.jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Building getBuilding(String building){
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("building");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if(building.equals("Engineering Building")){
            JSONObject b = findAndReturnBuildingObject(building, jsonArray);
            try {
                ArrayList<Section> sections = parseEngineeringBuildingSections(b.getJSONArray("sections"));
                return new Building("engineeringBuilding", building, sections);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private ArrayList<Section> parseEngineeringBuildingSections(JSONArray preSections){
        ArrayList<Section> sectionArrayList = new ArrayList<>();
        for(int i = 0; i < preSections.length(); i++){
            try {
                JSONObject sections = preSections.getJSONObject(0);

                Iterator<String> keys = sections.keys();

                while (keys.hasNext()){
                    String section = keys.next();
                    JSONArray floorJsonArray = sections.getJSONArray(section);
                    ArrayList<Section> floorList = new ArrayList<>();
                    for(int j = 0; j < floorJsonArray.length(); j++){
                        JSONObject floorSection = floorJsonArray.getJSONObject(j);
                        floorList.add(new Section("floor"+floorSection.get("floor"), "Floor "+floorSection.get("floor"), (String) floorSection.get("floorplan")));
                    }
                    sectionArrayList.add(new Section(section, section, floorList));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sectionArrayList;
    }

    private JSONObject findAndReturnBuildingObject(String name, JSONArray jArray){
        for(int i = 0; i<jArray.length(); i++){
            try {
                String name1 = (String) jArray.getJSONObject(i).get("name");
                if(name1.contains(name)){
                    return jArray.getJSONObject(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void getJsonFromAssets(Context context, String fileName){
        File f = new File(context.getCacheDir()+fileName);
        if (!f.exists()) try {

            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            FileOutputStream fos = new FileOutputStream(f);
            fos.write(buffer);
            fos.close();
        } catch (Exception e) { throw new RuntimeException(e); }

        this.filePath = f.getPath();
    }

    private static String usingBufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
