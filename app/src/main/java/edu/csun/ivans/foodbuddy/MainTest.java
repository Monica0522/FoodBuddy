package edu.csun.ivans.foodbuddy;

/**
 * Created by Ivan on 8/19/2017.
 */

public class MainTest {
    public static void main(String[] args){
        YelpRetriever driver = new YelpRetriever();
        Place place = driver.getPlace("mexican");

        System.out.println("   Name is: " + place.getName());
        System.out.println("   city is: " + place.getCity());

        place = driver.getPlace("mexican");

        System.out.println("   Name is: " + place.getName());
        System.out.println("   city is: " + place.getCity());
        place = driver.getPlace("mexican");
        System.out.println("   Name is: " + place.getName());
        System.out.println("   city is: " + place.getCity());
    }
}
