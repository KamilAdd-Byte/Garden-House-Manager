package com.gardenhouse.gardenhousemanager.appconsole.user.panel;

import com.gardenhouse.gardenhousemanager.appconsole.menu.Menu;

/**
 * Klasa wyświetlająca tytuł i menu dla zalogowanych użytkowników
 */
public class UserPanelMenu implements Menu {

    public UserPanelMenu() { }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String title() {
        return "****** PANEL UŻYTKOWNIKA ******";
    }

    @Override
    public String menuOptions() {
        return "1 - Ustaw parametry pomieszczenia\n2 - Dodaj zioło do swojej listy\n3 - Wyświetl swoje zioła i ich parametry\n4 - Pielęgnuj lub zasadź zioło z listy\n5 - Usuń zioło ze swojej listy\n6 - Wyjdź z panelu";
    }
}
