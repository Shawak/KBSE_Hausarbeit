/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

/**
 *
 * @author Maximilian Nussbaum
 * http://blog.wilderland.de/2015/05/webservice-fur-die-abfrage-von-postleitzahlen/
 */
public class PlzApi {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String getName(int plz) {
        String json = WebHelper.getHTML("http://api.zippopotam.us/de/" + plz);
        if (json == null) {
            return "";
        }

        JsonObject obj = gson.fromJson(json, JsonObject.class);
        if (obj == null) {
            return "";
        }

        JsonArray arr = obj.getAsJsonArray("places");
        String ret = arr.size() > 0 ? arr.get(0).getAsJsonObject().get("place name").getAsString() : null;
        return ret;
    }
}
