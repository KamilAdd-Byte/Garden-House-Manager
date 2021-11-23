package com.gardenhouse.gardenhousemanager.appconsole.user.basicwelcome;

import com.gardenhouse.gardenhousemanager.appconsole.menu.Menu;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

/**
 * This class it's generate title, version and description on user view in console.
 * This class contains special writing MENU.
 */
public class WelcomeInApp implements Menu {

    private static final String version = "Garden Home Management v1.0 \nConsole version\n@Kamil Sulejewski °r 2021\n\n";
    private static final String description = "Miejsce na opis funkcjonalności!!\n\n";
    private static final String titleBasicMenu = "°°°°°°°°°°°°°°°° MENU °°°°°°°°°°°°°°°\n";

    private UserLogged user;

    public WelcomeInApp(UserLogged user) {
        this.user = user;
    }
    public WelcomeInApp() {
    }
    public UserLogged getUser() {
        return user;
    }

    public void setUser(UserLogged user) {
        this.user = user;
    }

    public String displayTitleAndVersionApp(){
        return title() + version + description;
    }
    public String displayBasicMenu(){
        return titleBasicMenu + displayAccount() + "\n"+ menuOptions() +"\n";
    }

    public String displayAccount(){
        String result = "          konto: " + getUser().getLogin()+"\n";
        result += "-------------------------------------";
        return result;
    }
    /**
     * @param user to pass exists user
     * @return writing welcome a username.
     */
    public static String welcomeUser(User user){
        return "Witaj w aplikacji " + user.getName().toUpperCase();
    }
    /**
     * @param user to pass exists user
     * @return writing welcome a username.
     */
    public static String welcomeLoggedUser(UserLogged user){
        return "Witaj w aplikacji " + user.getName().toUpperCase();
    }

    @Override
    public String title() {
        return "\n" +
                "\n" +
                " _____   _       __         __              __              __                    ___   ____ ___  ___\n" +
                "/__  /  (_)___  / /___ _   / /_  ____  ____/ /___ _      __/ /___ _____  ___     |__ \\ / __ \\__ \\<  /\n" +
                "  / /  / / __ \\/ / __ `/  / __ \\/ __ \\/ __  / __ \\ | /| / / / __ `/ __ \\/ _ \\    __/ // / / /_/ // / \n" +
                " / /__/ / /_/ / / /_/ /  / / / / /_/ / /_/ / /_/ / |/ |/ / / /_/ / / / /  __/   / __// /_/ / __// /  \n" +
                "/____/_/\\____/_/\\__,_/  /_/ /_/\\____/\\__,_/\\____/|__/|__/_/\\__,_/_/ /_/\\___/   /____/\\____/____/_/   \n" +
                "                                                                                                     \n" +
                "\n";
    }

    @Override
    public String menuOptions() {
        return "Wybierz: \n0 - Wyjście  \n1 - Lista Ziół  \n2 - Szczegółowe informacje na temat hodowli ziół\n3 - Panel";
    }
}
