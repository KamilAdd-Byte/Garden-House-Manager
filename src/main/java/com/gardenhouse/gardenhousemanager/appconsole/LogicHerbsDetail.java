package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.control.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.database.DataBaseForHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.*;

public class LogicHerbsDetail implements Runnable{
    private static final String title = "\n" +
            "\n" +
            " _____   _       __         __              __              __                    ___   ____ ___  ___\n" +
            "/__  /  (_)___  / /___ _   / /_  ____  ____/ /___ _      __/ /___ _____  ___     |__ \\ / __ \\__ \\<  /\n" +
            "  / /  / / __ \\/ / __ `/  / __ \\/ __ \\/ __  / __ \\ | /| / / / __ `/ __ \\/ _ \\    __/ // / / /_/ // / \n" +
            " / /__/ / /_/ / / /_/ /  / / / / /_/ / /_/ / /_/ / |/ |/ / / /_/ / / / /  __/   / __// /_/ / __// /  \n" +
            "/____/_/\\____/_/\\__,_/  /_/ /_/\\____/\\__,_/\\____/|__/|__/_/\\__,_/_/ /_/\\___/   /____/\\____/____/_/   \n" +
            "                                                                                                     \n" +
            "\n";
    public static Scanner scanner = new Scanner(System.in);
    public static User user;
    private static final int EXIT = 0;
    private static final int GET_LIST = 1;
    private static final int HERB= 2;
    private static final int MY_HERB=3;
    @Override
    public void run() {
        int userChoice = 8;
        System.out.println("Rozpoczynasz korzystanie z programu. Podaj imię: ");
        String userName = scanner.nextLine();
        user = new User(userName);
        System.out.println("witaj w programie <<<<<<<<<<<" + user.getName() + ">>>>>>>>>>>>>>>>>>");

        while (userChoice != 0) {
            do {
                try {
                    System.out.println(title);
                    System.out.println("Wybierz: 0 - Wyjście  1 - Lista Ziół  2 - Zasadź zioło  3 - Moje zioła");
                    userChoice = scanner.nextInt();
                    switch (userChoice) {
                        case EXIT:
                            System.out.println("Do zo ba! Byku! Wróć kiedys jeszcze");
                            scanner.close();
                            break;
                        case GET_LIST:
                            List<HerbDetail> herbDetails = getHerbDetails();
                            herbDetails.forEach(System.out::println);
                            break;
                        case HERB:
                            HerbDetail search = checkInfoAboutHerbsOnDataBase();
                            System.out.println("Chcesz spróbować zasiać własne zioło? Tak lub nie");
                            String answer = scanner.nextLine().toUpperCase();
                            if (answer.equals("NIE")){
                                System.out.println("Może następnym razem sie zdecydujesz : ) ");
                            }else {

                                System.out.println("Zatem do dzieła: Nazwij zioło (preferowana nazwa zbliżona do oryginalnej, pomoże to w przeprowadzeniu Cię krok po kroku w jego zasianiu.)");
                                String nameUserHerb = scanner.nextLine();
                                System.out.println("Nadaj swojemu ziołu id w postaci liczby");
                                int idHerb = scanner.nextInt();
                                scanner.nextLine();
                                UserKitchenParameters kitchenUser = new UserKitchenParameters();
                                System.out.println("Zaczynamy ustawiać warunki w Twojej kuchni niezbedne do prawidłowego wzrostu ziół \n " +
                                        " ( 1 krok )Jakiego rodzaju masz oświetlenie w kuchni? (0,1 lub 2)");
                                LightForKitchen[] lightForKitchens = LightForKitchen.values();
                                for (LightForKitchen lightForKitchen : lightForKitchens) {
                                    System.out.println(lightForKitchen.getDescription());
                                }
                                int setLight = scanner.nextInt();

                                LightForKitchen[] kitchenLight = LightForKitchen.values();
                                for (LightForKitchen lightForKitchen : kitchenLight) {
                                    if (setLight==lightForKitchen.ordinal()){
                                        kitchenUser.setLight(lightForKitchen);
                                    }
                                }

                                System.out.println("( 2 krok ) Spróbuj określić przybliżoną wartość wilgotności jaka panuje w Twojej kuchni? ");
                                System.out.println("0 - Bardzo mała wilgotność \n1 - Wilgotność optymalna \n2 - Wysoka wilgotność, szybkie pojawianie sie pleśni w pomieszczeniu)");
                                int userWetnessChoice = scanner.nextInt();
                                WetnessForKitchen[] wetnessForKitchens = WetnessForKitchen.values();
                                for (WetnessForKitchen wetnessForKitchen : wetnessForKitchens) {
                                    if (userWetnessChoice == wetnessForKitchen.ordinal()) {
                                        kitchenUser.setWetness(wetnessForKitchen);
                                    }
                                }
                                System.out.println("Parametry kuchni " + userName + " - >\n"
                                        + kitchenUser.getLight().getDescription() + "\n" + kitchenUser.getWetness().getDescription());
                                scanner.nextLine();
                                System.out.println("Czy na pewno chcesz zasadzić zioło? ");
                                String userAnswer = scanner.nextLine().toUpperCase();
                                if (userAnswer.equals("TAK")) {
                                    search.sow(idHerb, search);
                                    User.addMyHerb(idHerb, search);
                                    System.out.println("Właśnie zasadziłeś zioło: " + search.toStringSowHerb());
                                } else if (userAnswer.equals("NIE")) {
                                    System.out.println("Rozumiem!");
                                }
                            }
                            break;
                        case MY_HERB:
                            System.out.println("Twoje zasadzone zioła i ich paramatry");
                            Map<Integer, HerbDetail> myHerbs = User.getMyHerbs();
                            Set<Map.Entry<Integer, HerbDetail>> entries = myHerbs.entrySet();
                            for (Map.Entry<Integer, HerbDetail> next : entries) {
                                System.out.println(next.getKey());
                                System.out.println(next.getValue().toStringSowHerb());
                            }
                            break;
                        default:
                            System.err.println("Opcja wybrana jest błedna. Dostepne 0 1 2");
                    }

                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    System.err.println("Podano dane w nieprawidłowej postaci");
                }

               scanner.nextLine();
            } while (userChoice != 0);
        }
    }

    private HerbDetail checkInfoAboutHerbsOnDataBase() {

        List<HerbDetail> herbDetails1 = getHerbDetails();
        for (HerbDetail herbDetail : herbDetails1) {
            System.out.println(herbDetail.toString());
        }
        scanner = new Scanner(System.in);
        System.out.println("Wybierz zioło z listy, które chcesz zasiać. Każde zioło ma swoje preferencje hodowlane. Zastanów się czy spełniasz określone wymogi.");
        String nameHerb = scanner.nextLine();
        DataBaseForHerbs ls = new DataBaseForHerbs();
        HerbDetail search = ls.search(nameHerb);
        System.out.println("Preferowane warunki hodowlane dla tego zioła" + "\n");
        System.out.println(search.toString());
        return search;
    }

    private List<HerbDetail> getHerbDetails() {
        DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();
        return dataBaseForHerbs.allHerbs();
    }

}
