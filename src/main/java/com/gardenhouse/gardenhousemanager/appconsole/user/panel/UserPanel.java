package com.gardenhouse.gardenhousemanager.appconsole.user.panel;

import com.gardenhouse.gardenhousemanager.appconsole.menu.Menu;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.flowerpot.FlowerPot;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserPanel extends User implements Menu {

    public UserPanel() {
    }

    public UserPanel(String name) {
        super(name);
    }

    public UserPanel(String name, Map<String, HerbDto> myHerbs, UserKitchenParameters myKitchen, List<FlowerPot> myFlowerPots) {
        super(name, myHerbs, myKitchen, myFlowerPots);
    }


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
        return "1 - Wyświetl swoje zioła\n2 - Pielęgnuj lub zasadź zioło z listy\n3 - Usuń zioło ze swojej listy\n4 - Wyjdź z panelu";
    }

    public void getHerbsForUser(User user) {
        System.out.println("_________________________________________________");
        System.out.println("Lista Twoich ziół:");
        System.out.println("_________________________________________________");
        displayUserHerbs(user);
    }

    private void displayUserHerbs(User user) {
        try {
            Map<String, HerbDto> myHerbs = user.getMyHerbs();
            Set<Map.Entry<String, HerbDto>> entries = myHerbs.entrySet();
            for (Map.Entry<String, HerbDto> entryHerbs : entries) {
                System.out.println(entryHerbs.getKey() + " id: " + entryHerbs.getValue().getIdHerb());
                System.out.println(entryHerbs.getValue());
            }
        } catch (NullPointerException e){
            System.err.println("Bład lub nie masz ziół na liście");
        }
    }
}
