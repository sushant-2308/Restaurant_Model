package com.example.Restaurant.service;

import com.example.Restaurant.model.Restaurant;
import com.example.Restaurant.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    public String addMyRestaurant(Restaurant restaurant) {
        boolean insertionStatus= restaurantDao.save(restaurant);
        if(insertionStatus)
            return "User added successfully..!";
        else
            return "Failed user add not possible";
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantDao.getAllRestaurantFromData();
    }

    public Restaurant getIdBasedRestaurant(int id) {
        List<Restaurant> RestaurantRightNow=restaurantDao.getAllRestaurantFromData();

        for(Restaurant restaurant:RestaurantRightNow){
            if(restaurant.getRestaurantId()==(id))
                return restaurant;
        }
        return null;
    }

    public String UpdateRestaurantData(int id, Restaurant restaurant) {
        List<Restaurant> RestaurantRightNow=restaurantDao.getAllRestaurantFromData();

        for(Restaurant res:RestaurantRightNow){
            if(res.getRestaurantId()==(id)){
                if(restaurantDao.update(id,restaurant))
                    return "Updated Successfully...!";
            }
        }
        return "Restaurant cannot be updated Please Check the id";
    }

    public String deleteRestaurantData(int id) {
        List<Restaurant> RestaurantRightNow=restaurantDao.getAllRestaurantFromData();

        for(Restaurant res:RestaurantRightNow){
            if(res.getRestaurantId()==(id)){
                if(restaurantDao.remove(res))
                    return "Restaurant with id "+id+" has been deleted successfully..!";
            }
        }
        return "Restaurant cannot be deleted Please Check the id";
    }
}
