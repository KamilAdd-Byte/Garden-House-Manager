package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * Użytkownik aplikacji. Posiada swoja mapę zasianych ziół.
 */
public class User {
    private String name;
    private Map<Integer, HerbDetail> myHerbs;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, HerbDetail> getMyHerbs() {
        return myHerbs;
    }

    public void setMyHerbs(Map<Integer, HerbDetail> myHerbs) {
        this.myHerbs = myHerbs;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", myHerbs=" + myHerbs +
                '}';
    }
    public void addMyHerb(int idHerb,HerbDetail herb){
        if (myHerbs==null){
            myHerbs = new HashMap<>();
        }
        if (herb!=null){
            myHerbs.put(idHerb,herb);
            System.out.println("Dodano zioło do Twojej listy");
        }else {
            System.err.println("Dodanie nie powiodło się");
        }
    }
}
