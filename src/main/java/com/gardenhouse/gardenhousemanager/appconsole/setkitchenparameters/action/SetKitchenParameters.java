package com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.action;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.user.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

public interface SetKitchenParameters {
    /**
     * This method set light for user kitchen
     * @see LightForKitchen
     *
     * @param user logged user
     *
     * @return one parameter for UserKitchenParameters - light
     */
    UserKitchenParameters setLight(UserLogged user);

    /**
     * This method set light for user kitchen
     * @see TemperatureInTheKitchen
     *
     * @param user logged user
     *
     * @return one parameter for UserKitchenParameters - temperature
     */
    UserKitchenParameters setTemperature(UserLogged user);

    /**
     * This method set light for user kitchen
     * @see WetnessForKitchen
     *
     * @param user logged user
     *
     * @return one parameter for UserKitchenParameters - wetness
     */
    UserKitchenParameters setWetness(UserLogged user);

    /**
     * Method gets all parameters of the user's kitchen
     * @see UserKitchenParameters
     * @return all parameters of the user's kitchen
     */
    UserKitchenParameters getUserKitchenParameters();

    /**
     * Method displays all parameters of the user's kitchen
     *
     * @param user logged user
     * @return display all parameters of the user's kitchen
     */
    String displayParameters(UserLogged user);
}
