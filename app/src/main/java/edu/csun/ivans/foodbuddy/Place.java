package edu.csun.ivans.foodbuddy;

import com.yelp.fusion.client.models.Business;
import com.yelp.fusion.client.models.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 8/19/2017.
 */

class Place implements IPlace {
    Business business = null;
    Category testC = new Category();
    public Place(Business business){
        this.business = business;
    }

    @Override
    public String getName() {
        return business.getName();
    }

    @Override
    public List<String> getCategories() {
        // Gets the titles of all categories and throws them into a list
        List<String> catString = new ArrayList<>();
        for (Category category : business.getCategories()) {
            catString.add(category.getTitle());
        }
        return catString;
    }

    @Override
    public String getGoogleID() {
        return null;
    }

    @Override
    public String getYelpID() {
        return business.getId();
    }

    @Override
    public String getPrice() {
        return business.getPrice();
    }

    @Override
    public String getAddress1() {
        return business.getLocation().getAddress1();
    }

    @Override
    public String getAddress2() {
        return business.getLocation().getAddress2();
    }

    @Override
    public String getAddress3() {
        return business.getLocation().getAddress3();
    }

    @Override
    public String getCity() {
        return business.getLocation().getCity();
    }

    @Override
    public String getURLYelp() {
        return business.getUrl();
    }

    @Override
    public String getURLImage() {
        return business.getImageUrl();
    }

    @Override
    public double getRating() {
        return business.getRating();
    }

    @Override
    public double getLatitude() {
        return business.getCoordinates().getLatitude();
    }

    @Override
    public double getLongitude() {
        return business.getCoordinates().getLongitude();
    }

    @Override
    public int reviewCount() {
        return business.getReviewCount();
    }
}
