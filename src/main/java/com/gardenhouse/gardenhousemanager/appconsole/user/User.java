package com.gardenhouse.gardenhousemanager.appconsole.user;

import com.gardenhouse.gardenhousemanager.appconsole.control.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * Użytkownik aplikacji. Posiada swoja mapę zasianych ziół.
 */
public class User {
    private String name;
    private static Map<String, HerbDetail> myHerbs;
    private UserKitchenParameters myKitchen;


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Map<String, HerbDetail> getMyHerbs() {
        return User.myHerbs;
    }

    public static void setMyHerbs(Map<String, HerbDetail> myHerbs) {
        User.myHerbs = myHerbs;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", myHerbs=" + myHerbs +
                '}';
    }
    public static void addMyHerb(String idHerb, HerbDetail herb){
        if (myHerbs==null){
            myHerbs = new HashMap<>();
        }
        myHerbs.put(idHerb,herb);
        System.out.println("Dodano zioło do Twojej listy");
    }
}
