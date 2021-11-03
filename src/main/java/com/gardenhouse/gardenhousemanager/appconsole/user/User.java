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
    private Map<String, HerbDetail> myHerbs;
    private UserKitchenParameters myKitchen;


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, HerbDetail> getMyHerbs() {
        return this.myHerbs;
    }

    public void setMyHerbs(Map<String, HerbDetail> myHerbs) {
        this.myHerbs = myHerbs;
    }

    public UserKitchenParameters getMyKitchen() {
        return this.myKitchen;
    }

    public void setMyKitchen(UserKitchenParameters myKitchen) {
        this.myKitchen = myKitchen;
    }

    public void addMyHerb(String idHerb, HerbDetail herb){
        if (myHerbs==null){
            myHerbs = new HashMap<>();
        }
        myHerbs.put(idHerb,herb);
        System.out.println("INFO: Dodano zioło do Twojej listy");
    }

    @Override
    public String toString() {
        return "Użytkownik: " + name + "\n" + myKitchen.toString();
    }
}
