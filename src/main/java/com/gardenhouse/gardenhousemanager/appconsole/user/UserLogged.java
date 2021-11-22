package com.gardenhouse.gardenhousemanager.appconsole.user;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
import java.util.List;
import java.util.Map;

public class UserLogged extends User {
    private String login;
    private String password;

    public UserLogged(){ }

    public UserLogged(String name, String login, String password) {
        super(name);
        this.login = login;
        this.password = password;
    }
    public UserLogged(String name, Map<String, HerbDto> myHerbs, UserKitchenParameters myKitchen,
                      List<HerbDto> myFlowerPots, String login, String password) {
        super(name, myHerbs, myKitchen, myFlowerPots);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Map<String, HerbDto> getMyHerbs() {
        return super.getMyHerbs();
    }

    @Override
    public void setMyHerbs(Map<String, HerbDto> myHerbs) {
        super.setMyHerbs(myHerbs);
    }

    @Override
    public UserKitchenParameters getMyKitchen() {
        return super.getMyKitchen();
    }

    @Override
    public void setMyKitchen(UserKitchenParameters myKitchen) {
        super.setMyKitchen(myKitchen);
    }

    @Override
    public List<HerbDto> getMyFlowerPots() {
        return super.getMyFlowerPots();
    }

    @Override
    public void setMyFlowerPots(List<HerbDto> myFlowerPots) {
        super.setMyFlowerPots(myFlowerPots);
    }

    @Override
    public void addMyHerb(String idHerb, HerbDto herb) {
        super.addMyHerb(idHerb, herb);
    }

    @Override
    public String toString() {
        return "Użytkownik zalogowany {" +
                " imię= " + getName() +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString() +
                "\n parametry kuchni= " + getMyKitchen() +
                "\n lista moich ziół= " + getMyHerbs();
    }

    @Override
    public String loggedDisplay(){
        return "Konto: " + login;
    }
}
