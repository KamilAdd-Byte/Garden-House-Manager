package com.gardenhouse.gardenhousemanager.appconsole.user.menu;

import com.gardenhouse.gardenhousemanager.appconsole.menu.Menu;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

public class UserMenu extends UserLogged implements Menu {

    @Override
    public String title() {
        return "°°°°°° LOGOWANIE °°°°°°";
    }

    @Override
    public String menuOptions() {
        return "\n1 - Zarejestruj nowego użytkownika \n2 - Zaloguj się\n3 - Tylko sprawdź aplikacje - (user default)";
    }
}
