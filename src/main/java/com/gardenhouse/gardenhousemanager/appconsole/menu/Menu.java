package com.gardenhouse.gardenhousemanager.appconsole.menu;

/**
 * Interface z metoda title i menuOptions do zaimplementowania
 * w innych klasach obsługujących użytkownika.
 */
public interface Menu {
    /**
     * @return title menu
     */
    String title();

    /**
     * @return menu options
     */
    String menuOptions();
}
