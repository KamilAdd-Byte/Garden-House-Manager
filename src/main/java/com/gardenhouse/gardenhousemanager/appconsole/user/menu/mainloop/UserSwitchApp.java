package com.gardenhouse.gardenhousemanager.appconsole.user.menu.mainloop;

import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.logic.LogicAppGenerateUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.menu.UserMenu;

import java.util.Scanner;

public class UserSwitchApp extends UserMenu {
    private static final int REGISTRY_USER = 1;
    private static final int LOG_IN_USER = 2;
    private static final int DEFAULT_USER = 3;
    private static final Scanner scanner = new Scanner(System.in);
    private int userOptions;
    private static UserLogged newLoggedUser;

    public void mainLoop(int userOptions) {
            switch (userOptions) {
                case REGISTRY_USER:
                    LogicAppGenerateUser generateUser = new LogicAppGenerateUser();
                    newLoggedUser = generateUser.createNewLoggedUser();
                    setNewLoggedUser(newLoggedUser);
                    break;
                case LOG_IN_USER:
                    generateUser = new LogicAppGenerateUser();
                    break;
                case DEFAULT_USER:
                    System.out.println("Podaj imię ");
                    String defaultName = scanner.nextLine();
                    User user = new User(defaultName);
                    System.out.println(user.getName() + " Heloo Default");
                    break;
                default:
                    System.out.println("Podano niewłasciwą opcje \n" + getBasicUserOptions());
            }
    }

    public static UserLogged getNewLoggedUser() {
        return newLoggedUser;
    }

    public static void setNewLoggedUser(UserLogged newLoggedUser) {
        UserSwitchApp.newLoggedUser = newLoggedUser;
    }
}
