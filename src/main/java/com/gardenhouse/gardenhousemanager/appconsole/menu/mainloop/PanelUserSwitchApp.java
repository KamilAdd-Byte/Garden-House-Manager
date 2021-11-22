package com.gardenhouse.gardenhousemanager.appconsole.menu.mainloop;

import com.gardenhouse.gardenhousemanager.appconsole.LogicHerbsDetail;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.panel.UserPanel;
import com.gardenhouse.gardenhousemanager.model.HerbDto;

import java.util.Map;
import java.util.Scanner;

public class PanelUserSwitchApp extends UserPanel {
    private static final int VIEW_ALL_HERBS = 1;
    private static final int SOW_WATER_HERB = 2;
    private static final int DELETE_HERB = 3;
    private static final int BACK = 4;
    private static final Scanner scanner = new Scanner(System.in);
    private static UserLogged user;

    public void mainLoop(int userOptions, UserLogged user) {
        scanner.nextLine();
        while (userOptions != 4) {
            System.out.println(title());
            System.out.println(menuOptions());
            userOptions = scanner.nextInt();
            switch (userOptions) {
                case VIEW_ALL_HERBS:
                    try {
                        Map<String, HerbDto> myHerbs = user.getMyHerbs();
                        getHerbsForUser(user);
                    } catch (NullPointerException e) {
                        System.err.println("Nie masz ziół na liście");
                        e.printStackTrace();
                    }
                    break;
                case SOW_WATER_HERB:
                    System.out.println("Implementacja");
                    break;
                case DELETE_HERB:
                    System.out.println("Implementacja :)");
                    break;
                case BACK:
                    LogicHerbsDetail logicAppHerbs = new LogicHerbsDetail();
                    logicAppHerbs.run();
                    break;
                default:
                    System.err.println("Błąd");
            }
        }
    }
}
