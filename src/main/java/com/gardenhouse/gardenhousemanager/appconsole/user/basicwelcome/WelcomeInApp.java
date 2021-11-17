package com.gardenhouse.gardenhousemanager.appconsole.user.basicwelcome;

import com.gardenhouse.gardenhousemanager.appconsole.user.User;

/**
 * This class it's generate title, version and description on user view in console.
 * This class contains special writing MENU.
 */
public class WelcomeInApp {
    private static final String title = "\n" +
            "\n" +
            " _____   _       __         __              __              __                    ___   ____ ___  ___\n" +
            "/__  /  (_)___  / /___ _   / /_  ____  ____/ /___ _      __/ /___ _____  ___     |__ \\ / __ \\__ \\<  /\n" +
            "  / /  / / __ \\/ / __ `/  / __ \\/ __ \\/ __  / __ \\ | /| / / / __ `/ __ \\/ _ \\    __/ // / / /_/ // / \n" +
            " / /__/ / /_/ / / /_/ /  / / / / /_/ / /_/ / /_/ / |/ |/ / / /_/ / / / /  __/   / __// /_/ / __// /  \n" +
            "/____/_/\\____/_/\\__,_/  /_/ /_/\\____/\\__,_/\\____/|__/|__/_/\\__,_/_/ /_/\\___/   /____/\\____/____/_/   \n" +
            "                                                                                                     \n" +
            "\n";
    private static final String version = "Garden Home Management v1.0 \nConsole version\n@Kamil Sulejewski °r 2021\n\n";
    private static final String description = "Miejsce na opis funkcjonalności!!\n\n";
    private static final String titleBasicMenu = "°°°°°°° MENU °°°°°°°\n";
    private static final String basicMenu = "Wybierz: \n0 - Wyjście  \n1 - Lista Ziół  \n2 - Dodaj zioło do panelu\n3 - Moje zioła \n";

    private WelcomeInApp() {
    }

    public static String displayTitleAndVersionApp(){
        return title + version + description;
    }
    public static String displayBasicMenu(){
        return titleBasicMenu + basicMenu;
    }

    /**
     * @param user to pass exists user
     * @return writing welcome a username.
     */
    public static String welcomeUser(User user){
        return "Witaj w aplikacji " + user.getName().toUpperCase();
    }
}
