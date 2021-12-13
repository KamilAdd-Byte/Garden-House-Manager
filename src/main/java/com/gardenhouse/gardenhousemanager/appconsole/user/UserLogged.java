package com.gardenhouse.gardenhousemanager.appconsole.user;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.user.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.flowerpot.FlowerPot;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

public class UserLogged extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String password;

    public UserLogged(){ }

    public UserLogged(String name, String login, String password) {
        super(name);
        this.login = login;
        this.password = password;
    }

    public UserLogged(String name, Map<String, HerbDto> myHerbs, UserKitchenParameters myKitchen,
                      List<FlowerPot> myFlowerPots, String login, String password) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "\n\nWitaj " + getName() + " konto: " + login;
    }
}
