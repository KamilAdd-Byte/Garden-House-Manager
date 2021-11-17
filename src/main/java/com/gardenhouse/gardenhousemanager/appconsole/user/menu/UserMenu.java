package com.gardenhouse.gardenhousemanager.appconsole.user.menu;

import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

public class UserMenu extends UserLogged {
    private String title = "°°°°°° LOGOWANIE °°°°°°";
    private String basicUserOptions = "\n1 - Zarejestruj nowego użytkownika \n2 - Zaloguj się\n3 - Tylko sprawdź aplikacje - (user default)";

    public String displayTitle(){
        return title;
    }
    public String displayMenuForUser(){
        return basicUserOptions;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBasicUserOptions() {
        return basicUserOptions;
    }

    public void setBasicUserOptions(String basicUserOptions) {
        this.basicUserOptions = basicUserOptions;
    }
}
