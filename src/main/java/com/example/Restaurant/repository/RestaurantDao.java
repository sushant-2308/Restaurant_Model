package com.example.Restaurant.repository;

import com.example.Restaurant.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao {

    private List<Restaurant> restaurantList;

    public RestaurantDao() {
        restaurantList=new ArrayList<>();
    }

    public boolean save(Restaurant restaurant) {
        restaurantList.add(restaurant);
        return true;
    }

    public List<Restaurant> getAllRestaurantFromData() {
        return restaurantList;
    }

    public boolean update(int id, Restaurant restaurant) {
        for(Restaurant res:restaurantList){
            if(res.getRestaurantId()==id){
                remove(res);
                save(restaurant);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Restaurant res) {
        restaurantList.remove(res);
        return true;
    }
}
