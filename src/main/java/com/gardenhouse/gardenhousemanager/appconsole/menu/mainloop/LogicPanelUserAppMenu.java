package com.gardenhouse.gardenhousemanager.appconsole.menu.mainloop;

import com.gardenhouse.gardenhousemanager.appconsole.LogicApp;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.action.impl.SetKitchenParametersImpl;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.user.UserKitchenMenu;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.panel.UserPanelMenu;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

/**
 * Klasa obsługująca PANEL użytkownika, który jest zalogowany
 */
@Getter
@Setter
public class LogicPanelUserAppMenu extends UserPanelMenu {

    private static final int SETTING_FOR_KITCHEN = 1;
    private static final int ADD_HERB_TO_PANEL = 2;
    private static final int VIEW_ALL_HERBS = 3;
    private static final int SOW_WATER_HERB = 4;
    private static final int DELETE_HERB = 5;
    private static final int BACK = 6;
    private static final Scanner scanner = new Scanner(System.in);
    private static UserKitchenMenu menu = new UserKitchenMenu();
    private UserLogged user;

    public LogicPanelUserAppMenu() {
    }

    public LogicPanelUserAppMenu(UserLogged user) {
        this.user = user;
    }

    public static UserKitchenMenu getMenu() {
        return menu;
    }


    public void mainLoop(int userOptions, UserLogged user) {

        while (userOptions != 6) {
            System.out.println("\n"+"Twój panel"+"\n"+menuOptions());
            userOptions = scanner.nextInt();
            switch (userOptions) {
                case SETTING_FOR_KITCHEN:
                    SetKitchenParametersImpl kitchenParameters = new SetKitchenParametersImpl(user);
                    System.out.println("Ustawianie parametrów kuchni");
                    kitchenParameters.firstStepForSetKitchenParametersLight(user);
                    kitchenParameters.twoStepForSetKitchenParametersWetness(user);
                    kitchenParameters.threeStepForSetKitchenParametersTemperature(user);
                    //display parameters user kitchen
                    System.out.println(kitchenParameters.displayParameters(user));
                    break;
                case ADD_HERB_TO_PANEL:
                    // TODO: 12.12.2021
                    System.out.println("impl");
                    break;
                case VIEW_ALL_HERBS:
                    // TODO: 23.11.2021
                    break;
                case SOW_WATER_HERB:
                    System.out.println("Implementacja");
                    // TODO: 23.11.2021
                    break;
                case DELETE_HERB:
                    // TODO: 23.11.2021
                    System.out.println("Implementacja :)");
                    break;
                case BACK:
                    LogicApp logicAppHerbs = new LogicApp();
                    logicAppHerbs.run();
                    break;
                default:
                    System.err.println("Błąd");
            }
        }
    }
}
