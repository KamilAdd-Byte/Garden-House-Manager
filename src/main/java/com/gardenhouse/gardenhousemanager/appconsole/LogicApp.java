package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.database.LogicAppHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.user.panel.UserPanelMenu;
import com.gardenhouse.gardenhousemanager.appconsole.menu.mainloop.LogicPanelUserAppMenu;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.LogicAppSetKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.database.DataBaseForHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.basicwelcome.WelcomeInApp;
import com.gardenhouse.gardenhousemanager.appconsole.user.menu.UserLoggedMenu;
import com.gardenhouse.gardenhousemanager.appconsole.user.menu.mainloop.LogicUserLoggedApp;
import com.gardenhouse.gardenhousemanager.flowerpot.parameters.PotSize;
import com.gardenhouse.gardenhousemanager.model.HerbDto;

import java.util.*;
import java.util.List;

/**
 * Jest to główna klasa, która obsługuje podstawowe funkcje aplikacji.
 * Lista ziół wraz ze specykikacja ich hodowli.
 * @see LogicPanelUserAppMenu - funkcje dla zalogowanego użytkownika. (switch)
 * @see LogicUserLoggedApp - proces logowania i rejestrowania nowego użytkownika (switch)
 */
public class LogicApp implements Runnable{

    public static Scanner scanner;
    private static UserLogged user;
    private static final int EXIT = 0;
    private static final int GET_LIST = 1;
    private static final int SPECIFICATION_HERBS = 2;
    private static final int PANEL=3;

    @Override
    public void run() {
        int userChoice = 9;
        scanner = new Scanner(System.in);
        while (userChoice != 0) {
            do {
                try {
                    WelcomeInApp welcome = new WelcomeInApp();
                    System.out.println(welcome.displayTitleAndVersionApp());
                    System.out.println(welcome.menuOptions());
                    userChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (userChoice) {
                        case EXIT:
                            try {
                                System.out.println("Do zo ba! Byku! Wróć kiedys jeszcze");
                                scanner.close();
                            }catch (IllegalStateException e){
                                System.err.println("Wyjście z programu");
                            }

                            break;
                        case GET_LIST:
                            LogicAppHerbs logicAppHerbs = new LogicAppHerbs();
                            logicAppHerbs.displayAllHerbsInDataBase();
                            break;
                        case SPECIFICATION_HERBS:
                            // TODO: 23.11.2021 IMPLEMENTATION TASK
                            break;
                        case PANEL:
                            loggedUserOnApp();
                            WelcomeInApp loggedWelcome = new WelcomeInApp(user);
                            String s = loggedWelcome.welcomeLoggedUser(user);
                            System.out.println(s);
                            panelUserStart(user);
                            break;
                        default:
                            System.err.println("Opcja wybrana jest błędna. Dostępne 0 1 2");
                    }

                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    System.err.println("Podano dane w nieprawidłowej postaci");
                }
            } while (userChoice != 0);
        }
    }

    private void panelUserStart(UserLogged user) {
        LogicPanelUserAppMenu panel = new LogicPanelUserAppMenu(user);
        System.out.println(panel.title() + "\n"+ panel.menuOptions());
        int choice = scanner.nextInt();
        panel.mainLoop(choice,user);
    }

    private UserLogged loggedUserOnApp() {
        LogicUserLoggedApp logicLoggedUserApp = new LogicUserLoggedApp();
        UserLoggedMenu userLoggedMenu = new UserLoggedMenu();
        System.out.println("Rozpoczynasz korzystanie z programu. Masz już swoje konto?\n\n");
        System.out.println(userLoggedMenu.title() + userLoggedMenu.menuOptions());
        scanner = new Scanner(System.in);
        System.out.printf("Twój wybór ");
        int choice = scanner.nextInt();
        logicLoggedUserApp.mainLoop(choice);
        user = LogicUserLoggedApp.getNewLoggedUser();
        System.out.println(user.loggedDisplay());
        scanner.nextLine();
        return user;
    }
}
