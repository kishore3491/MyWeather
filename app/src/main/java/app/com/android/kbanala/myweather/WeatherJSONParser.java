package app.com.android.kbanala.myweather;

import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kishore on 6/13/2015.
 */
public class WeatherJSONParser {

    public static double getMaxTemperatureForDay(String weatherJSONStr, int dayIndex){

        try{
            JSONObject weather = new JSONObject(weatherJSONStr);
            JSONArray days = weather.getJSONArray("list");
            JSONObject daysInfo = days.getJSONObject(dayIndex);
            JSONObject temperatureInfo = daysInfo.getJSONObject("temp");
            return temperatureInfo.getDouble("max");
        }
        catch (JSONException je){
            Log.e("JSON Error", je.toString());
        }
        return -1;
    }
}
