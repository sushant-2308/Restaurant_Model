package com.example.Restaurant.controller;


import com.example.Restaurant.model.Restaurant;
import com.example.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
      RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addMyRestaurant(restaurant);
    }

    @GetMapping("/getAllRestaurant")
    public List<Restaurant> getRestaurant(){
         return restaurantService.getAllRestaurant();
    }

    @GetMapping("/getRestaurantById/{id}")
    public Restaurant getRestaurantById(@PathVariable int id){
        return restaurantService.getIdBasedRestaurant(id);
    }

    @PutMapping("/updateRestaurant/{id}")
    public String updateRestaurantInfo(@PathVariable int id,@RequestBody Restaurant restaurant){
        return restaurantService.UpdateRestaurantData(id,restaurant);
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public String deleteRestaurant(@PathVariable int id){
        return restaurantService.deleteRestaurantData(id);
    }
}
