package edu.csun.ivans.foodbuddy;

import com.yelp.fusion.client.connection.*;
import com.yelp.fusion.client.models.Business;
import com.yelp.fusion.client.models.SearchResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Response;
import java.util.Random;

/**
 * Created by Ivan on 8/19/2017.
 */

public class YelpRetriever {
    private static final String CLIENT_ID = "eZaHYMz2vnT2t6gz-TgCbg";
    private static final String CLIENT_SECRET = "tUVxNkwQ9lAX6U0kYTHf5UHc8wwf3ihZoJTc1TebgDqhvkp9tcHFhQJPSBQOkyHS";
    YelpFusionApiFactory apiFactory = new YelpFusionApiFactory();
    YelpFusionApi yelpFusionApi = null;
    Map<String, String> params;
    int radius = 10;

    /*
     * Making a new YelpRetriever object with the users location
     */

    // Defaults
    public YelpRetriever(){
        params = new HashMap<>();

        // Tries to authenticate
        try {
            yelpFusionApi = apiFactory.createAPI(CLIENT_ID, CLIENT_SECRET);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        params.put("latitude", "34.241474");
        params.put("longitude", "-118.529208");
        params.put("term", "restaurant");
    }

    public YelpRetriever(double latitude, double longitude){
        String latString = new Double(latitude).toString();
        String lonString = new Double(longitude).toString();
        params = new HashMap<>();

        // Tries to authenticate
        try {
            yelpFusionApi = apiFactory.createAPI(CLIENT_ID, CLIENT_SECRET);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        params.put("latitude", latString);
        params.put("longitude", lonString);
        params.put("term", "restaurant");
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public Place getPlace(String alias){
        Random rand = new Random();
        Business[] businessArray = null;
        Place place = null;

        params.put("categories", alias);

        Call<SearchResponse> call = yelpFusionApi.getBusinessSearch(params);
        try {
            Response<SearchResponse> response = call.execute();
            businessArray = new Business[response.body().getBusinesses().size()];
            response.body().getBusinesses().toArray(businessArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int n = rand.nextInt(businessArray.length);
        place = new Place(businessArray[n]);
        return place;
        }
}
