package com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.action.impl;

import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.action.SetKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.user.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import java.util.Scanner;

public class SetKitchenParametersImpl implements SetKitchenParameters {

    private UserKitchenParameters userKitchenParameters;
    private UserLogged user;
    private static final Scanner scanner = new Scanner(System.in);

    public SetKitchenParametersImpl(UserLogged user) {
        this.user = user;
        userKitchenParameters = new UserKitchenParameters();
    }

    /**
     * This method set light for user kitchen
     * @see LightForKitchen
     *
     * @param user logged user
     *
     * @return one parameter for UserKitchenParameters - light
     */
    @Override
    public UserKitchenParameters setLight(UserLogged user){
        System.out.println("Zaczynamy ustawiać warunki w Twojej kuchni niezbedne do prawidłowego wzrostu ziół \n " +
                " ( 1 krok )Jakiego rodzaju masz oświetlenie w kuchni? (0,1 lub 2)");
        LightForKitchen[] lightForKitchens = LightForKitchen.values();
        for (LightForKitchen light : lightForKitchens) {
            System.out.println(light.getDescription());
        }
        int setLight = scanner.nextInt();

        LightForKitchen[] kitchenLight = LightForKitchen.values();
        for (LightForKitchen light : kitchenLight) {
            if (setLight==light.ordinal()){
               userKitchenParameters.setLight(light);
            }
        }
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }

    /**
     * This method set light for user kitchen
     * @see TemperatureInTheKitchen
     *
     * @param user logged user
     *
     * @return one parameter for UserKitchenParameters - temperature
     */
    @Override
    public UserKitchenParameters setTemperature(UserLogged user){
        System.out.println("( 3 krok ) Spróbuj określić przybliżoną temperaturę jaka panuje w Twojej kuchni? ");
        System.out.println("0 - Bardzo niska temperatura - poniżej 17 stopni C \n1 - Temperatura średnia - w przedziale 18-22 stopni C\n2 - Temperatura wysoka - powyżej 23 stopni C  ");
        int userWetnessChoice = scanner.nextInt();
        TemperatureInTheKitchen[] temperature = TemperatureInTheKitchen.values();
        for (TemperatureInTheKitchen temperatureInTheKitchen : temperature) {
            if (userWetnessChoice == temperatureInTheKitchen.ordinal()) {
                userKitchenParameters.setTemperature(temperatureInTheKitchen);
            }
        }
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }

    /**
     * This method set light for user kitchen
     * @see WetnessForKitchen
     *
     * @param user logged user
     *
     * @return one parameter for UserKitchenParameters - wetness
     */
    @Override
    public UserKitchenParameters setWetness(UserLogged user){
        System.out.println("( 2 krok ) Spróbuj określić przybliżoną wartość wilgotności jaka panuje w Twojej kuchni? ");
        System.out.println("0 - Bardzo mała wilgotność, suche powietrze \n1 - Wilgotność optymalna \n2 - Wysoka wilgotność, szybkie pojawianie się pleśni w pomieszczeniu)");
        int userWetnessChoice = scanner.nextInt();
        WetnessForKitchen[] wetnessForKitchens = WetnessForKitchen.values();
        for (WetnessForKitchen wetnessForKitchen : wetnessForKitchens) {
            if (userWetnessChoice == wetnessForKitchen.ordinal()) {
                userKitchenParameters.setWetness(wetnessForKitchen);
            }
        }
        user.setMyKitchen(userKitchenParameters);
        return userKitchenParameters;
    }

    /**
     * Method gets all parameters of the user's kitchen
     * @see UserKitchenParameters
     * @return all parameters of the user's kitchen
     */
    @Override
    public UserKitchenParameters getUserKitchenParameters() {
        return this.userKitchenParameters;
    }

    /**
     * Method displays all parameters of the user's kitchen
     *
     * @param user logged user
     * @return display all parameters of the user's kitchen
     */
    @Override
    public String displayParameters(UserLogged user){
       return  "Parametry kuchni: " + "\n" +
                "oświetlenie: " + user.getMyKitchen().getLight() + "\n" +
                "wilgotność: " + user.getMyKitchen().getWetness() + "\n" +
                "temperatura:  min-" + user.getMyKitchen().getTemperature().getIntervalMin() + "  max- " + user.getMyKitchen().getTemperature().getIntervalMax();
    }

    public void firstStepForSetKitchenParametersLight(UserLogged user){
        setLight(user);
    }
    public void twoStepForSetKitchenParametersWetness(UserLogged user){
        setWetness(user);
    }
    public void threeStepForSetKitchenParametersTemperature(UserLogged user){
        setTemperature(user);
    }
}
