package com.gardenhouse.gardenhousemanager.appconsole.user.menu.mainloop;

import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.logic.LogicAppGenerateAndSaveUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.menu.UserLoggedMenu;

import java.sql.ResultSet;
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
        LogicAppGenerateAndSaveUser generateUser = new LogicAppGenerateAndSaveUser();
            switch (userOptions) {
                case REGISTRY_USER:
                    newLoggedUser = generateUser.createNewLoggedUser();
                    setNewLoggedUser(newLoggedUser);
                    newLoggedUser.loggedDisplay();
                    break;
                case LOG_IN_USER:
                    System.out.println("Podaj login");
                    String login = scanner.nextLine();
                    ResultSet resultSet = generateUser.searchUserByLogin(login);
                    System.out.println(resultSet);
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
