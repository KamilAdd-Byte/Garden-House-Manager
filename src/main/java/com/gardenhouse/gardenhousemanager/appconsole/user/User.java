package com.gardenhouse.gardenhousemanager.appconsole.user;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** USER Add-Update-Remove-Login-
 * This class it's a new users create and has all data. User has list herbs which he wants to sow.
 */
public class User {
    private String name;
    private Map<String, HerbDetail> myHerbs;
    private UserKitchenParameters myKitchen;
    private List<HerbDetail> myFlowerPots;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Map<String, HerbDetail> myHerbs, UserKitchenParameters myKitchen, List<HerbDetail> myFlowerPots) {
        this.name = name;
        this.myHerbs = myHerbs;
        this.myKitchen = myKitchen;
        this.myFlowerPots = myFlowerPots;
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

    public List<HerbDetail> getMyFlowerPots() {
        return myFlowerPots;
    }

    public void setMyFlowerPots(List<HerbDetail> myFlowerPots) {
        this.myFlowerPots = myFlowerPots;
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
        return "Użytkownik: " + name + "\n" + myKitchen.toString() + "\n" + myFlowerPots;
    }

    public String loggedDisplay(){
        return "Konto: " + name;
    }
}
