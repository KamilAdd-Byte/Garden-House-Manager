package com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

public class LogicAppSetKitchenParameters {
    private UserKitchenParameters userKitchenParameters;
    private UserLogged user;

    public LogicAppSetKitchenParameters(UserLogged user) {
        this.user=user;
        userKitchenParameters = new UserKitchenParameters();
    }

    public UserKitchenParameters setLight(UserLogged user, LightForKitchen lightForKitchen){
        userKitchenParameters.setLight(lightForKitchen);
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }
    public UserKitchenParameters setTemperature(UserLogged user,TemperatureInTheKitchen temperature){
        userKitchenParameters.setTemperature(temperature);
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }
    public UserKitchenParameters setWetness(UserLogged user,WetnessForKitchen wetness){
        userKitchenParameters.setWetness(wetness);
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }

    public UserKitchenParameters getUserKitchenParameters() {
        return userKitchenParameters;
    }

    public static String displayParameters(UserLogged user){
       return  "Parametry kuchni: " + "\n" +
                "oświetlenie: " + user.getMyKitchen().getLight() + "\n" +
                "wilgotność: " + user.getMyKitchen().getWetness() + "\n" +
                "temperatura:  min-" + user.getMyKitchen().getTemperature().getIntervalMin() + "  max- " + user.getMyKitchen().getTemperature().getIntervalMax();
    }
}
