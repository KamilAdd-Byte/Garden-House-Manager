package com.gardenhouse.gardenhousemanager.appconsole.user.menu.mainloop;

import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.logic.LogicAppGenerateUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.menu.UserLoggedMenu;

import java.util.Scanner;

/**
 * Klasa rejestrująca nowego użytkownika
 */
public class LogicUserLoggedApp extends UserLoggedMenu {

    private static final int REGISTRY_USER = 1;
    private static final int LOG_IN_USER = 2;
    private static final int DEFAULT_USER = 3;
    private static final Scanner scanner = new Scanner(System.in);
    private static UserLogged newLoggedUser;

    public void mainLoop(int userOptions) {
        LogicAppGenerateUser generateUser = new LogicAppGenerateUser();
            switch (userOptions) {
                case REGISTRY_USER:
                    newLoggedUser = generateUser.createNewLoggedUser();
                    setNewLoggedUser(newLoggedUser);
                    newLoggedUser.loggedDisplay();
                    break;
                case LOG_IN_USER:
                    System.out.println("Podaj login ");
                    String login = scanner.nextLine();
                    System.out.println("Podaj hasło ");
                    String password = scanner.nextLine();
                    generateUser.login(login,password);
                    break;
                case DEFAULT_USER:
                    System.out.println("Podaj imię ");
                    String defaultName = scanner.nextLine();
                    User user = new User(defaultName);
                    System.out.println(user.getName() + " Heloo Default");
                    break;
                default:
                    System.out.println("Podano niewłasciwą opcje \n" );
            }
    }

    public static UserLogged getNewLoggedUser() {
        return newLoggedUser;
    }

    public static void setNewLoggedUser(UserLogged newLoggedUser) {
        LogicUserLoggedApp.newLoggedUser = newLoggedUser;
    }
}
