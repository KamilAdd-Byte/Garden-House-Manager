package com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.user;

import com.gardenhouse.gardenhousemanager.appconsole.menu.Menu;

public class UserKitchenMenu implements Menu {

    /**
     * @return title menu
     */
    @Override
    public String title() {
        return "Parametry kuchni";
    }

    /**
     * @return menu options
     */
    @Override
    public String menuOptions() {
        return "1 - Światło\n2 - Temperatura\n3- Wilgotność";
    }
}
