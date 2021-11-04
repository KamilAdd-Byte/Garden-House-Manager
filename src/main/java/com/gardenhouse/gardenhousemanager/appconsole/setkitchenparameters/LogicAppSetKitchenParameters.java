package com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;

public class LogicAppSetKitchenParameters {
    private UserKitchenParameters userKitchenParameters;
    private User user;

    public LogicAppSetKitchenParameters(User user) {
        this.user=user;
        userKitchenParameters = new UserKitchenParameters();
    }

    public UserKitchenParameters setLight(User user, LightForKitchen lightForKitchen){
        userKitchenParameters.setLight(lightForKitchen);
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }
    public UserKitchenParameters setTemperature(User user,TemperatureInTheKitchen temperature){
        userKitchenParameters.setTemperature(temperature);
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }
    public UserKitchenParameters setWetness(User user,WetnessForKitchen wetness){
        userKitchenParameters.setWetness(wetness);
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }

    public UserKitchenParameters getUserKitchenParameters() {
        return userKitchenParameters;
    }

    public String displayParameters(User user){
       return  "Parametry kuchni: " + "\n" +
                "oświetlenie: " + user.getMyKitchen().getLight() + "\n" +
                "wilgotność: " + user.getMyKitchen().getWetness() + "\n" +
                "temperatura:  min-" + user.getMyKitchen().getTemperature().getIntervalMin() + "  max- " + user.getMyKitchen().getTemperature().getIntervalMax();
    }
}
