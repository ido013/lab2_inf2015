/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author ab791257
 */
public class Json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String jsonString = FileReader.loadFileIntoString("json/catalog.json", "UTF-8");
            JSONArray arr = JSONArray.fromObject(jsonString);
            JSONObject obj;
            System.out.println("Albums parus depuis 1990:");
            int counter = 0;
            for (int i = 0; i < arr.size(); i++) {
                obj = arr.getJSONObject(i);
                int year = obj.getInt("year");
                if (year >= 1990) {
                    System.out.println("* " + obj.getString("title"));
                    counter++;
                }
            }
            System.out.println("Il y a " + arr.size() + " CD(s) dans le catalogue dont " + counter + " paru(s) depuis 1990.");
            counter = 0;
            for (int i = 0; i < arr.size(); i++) {
                obj = arr.getJSONObject(i);
                if (obj.getBoolean("instock")) {
                    System.out.println("* " + obj.getString("title") + ": " + obj.getDouble("price") + "$");
                    counter++;
                }
            }
            System.out.println("Il y a " + counter + " CD(s) en stock.");
            
        } catch (IOException ex) {
            System.out.println("File not found");
        }
        JSONObject nouv= new JSONObject();
        nouv.accumulate("id", "1321033823");
        nouv.accumulate("total", 9.9);
        nouv.accumulate("date", "11/11/2011");
        nouv.accumulate("validated", true);
        JSONObject alb = new JSONObject();
        alb.accumulate("id", "1");
        alb.accumulate("title", "Hide your heart");
        JSONArray array = new JSONArray();
        array.add(alb);
        nouv.accumulate("album", array);
        System.out.println(nouv);        
    }

}
