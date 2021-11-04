package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.database.LogicAppHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.LogicAppSetKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.database.DataBaseForHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.user.LogicAppGenerateUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.flowerpot.Material;
import com.gardenhouse.gardenhousemanager.flowerpot.PotSize;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.awt.*;
import java.util.*;
import java.util.List;

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
    public static Scanner scanner;
    private static User user;
    private static final int EXIT = 0;
    private static final int GET_LIST = 1;
    private static final int HERB= 2;
    private static final int MY_HERB=3;
    private static final int SOW_WATER=4;


    @Override
    public void run() {
        int userChoice = 8;
        user = enterToAppForUser();
        scanner = new Scanner(System.in);

        while (userChoice != 0) {
            do {
                try {
                    System.out.println(title);
                    System.out.println("Wybierz: \n0 - Wyjście  \n1 - Lista Ziół  \n2 - Zasadź zioło \n3 - Moje zioła \n4 - Pielęgnacja moich ziół");
                    userChoice = scanner.nextInt();
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
                        case HERB:
                            HerbDetail search = checkInfoAboutHerbsOnDataBase();
                            System.out.println("Chcesz dodać ** "+ search.getName() +" ** do Twojej listy ziół? TAK lub NIE");
                            String answer = scanner.nextLine().toUpperCase();
                            if (answer.equals("NIE")){
                                System.out.println("Może następnym razem sie zdecydujesz : ) ");
                            }else if (answer.equals("TAK")){
                                System.out.println("Zatem do dzieła: Nazwij zioło (preferowana nazwa zbliżona do oryginalnej, pomoże to w przeprowadzeniu Cię krok po kroku w jego zasianiu.)");
                                String nameUserHerb = scanner.nextLine();
                                System.out.println("Nadaj swojemu ziołu id w postaci liczby");
                                int idHerb = scanner.nextInt();
                                scanner.nextLine();

                                //Ustawienie parametrów kuchni
                                System.out.println("Wprowadzasz zmiany lub ustawiasz pierwszy raz parametry kuchni wpisz TAK \njeżeli masz już ustawione parametry wpisz NIE");
                                String answerCreateKitchenParameters = scanner.nextLine().toUpperCase();
                                LogicAppSetKitchenParameters kitchenParameters = new LogicAppSetKitchenParameters(user);
                                if (answerCreateKitchenParameters.equals("NIE")){
                                    System.out.println("Parametry Twojej kuchni: \n"+ user.getMyKitchen().toString());
                                }else if (answerCreateKitchenParameters.equals("TAK")){
                                    firstStepForSetKitchenParametersLight(user,kitchenParameters);
                                    twoStepForSetKitchenParametersWeatness(user,kitchenParameters);
                                    threeStepForSetKitchenParametersTemperature(user,kitchenParameters);
                                    UserKitchenParameters myKitchen = user.getMyKitchen();
                                    System.out.println(myKitchen);
                                    scanner.nextLine();
                                } else {
                                    System.err.println("Błędna odpowiedź! spróbuj ponownie");
                                }

                                System.out.println("Czy na pewno chcesz zasadzić zioło? TAK (Sadzimy zioło) lub NIE (Dodajemy do listy, będziesz mógł/mogła zasadzić później)");
                                String userAnswer = scanner.nextLine().toUpperCase();
                                if (userAnswer.equals("TAK")) {
                                    search.sow(idHerb, search);
                                    //Pierwsze podlanie rośliny, tworzenie doniczki!todo Implementacja
                                    search.setPot(new HerbDetail.FlowerPot(PotSize.MEDIUM, Color.BLUE, Material.PLASTIC,search));
                                    user.addMyHerb(nameUserHerb, search);
                                    //podlewanie wartościami nie modyfikowalnymi
                                    search.water(search,50);
                                    System.out.println("Właśnie zasadziłeś zioło: " + search.toStringSowHerb());
                                } else if (userAnswer.equals("NIE")) {
                                    user.addMyHerb(nameUserHerb, search);
                                    System.out.println("Rozumiem! Zioło zostało dodane do Twojego panelu. Możesz rozpocząć hodowle w dowolnym momencie. Wciśnij enter");
                                }
                            } else {
                                System.err.println("Błędnie wprowadzone dane. Spróbuj jeszcze raz!");
                            }
                            break;
                        case MY_HERB:
                            System.out.println("Twoje wszystkie zioła i ich paramatry");
                            if (user.getMyHerbs()==null){
                                System.err.println("Nie masz jeszcze żadnych ziół");
                            }else {
                                try {
                                    Map<String, HerbDetail> myHerbs = user.getMyHerbs();
                                    Set<Map.Entry<String, HerbDetail>> entries = myHerbs.entrySet();
                                    for (Map.Entry<String, HerbDetail> next : entries) {
                                        System.out.println("Twoja nazwa rośliny: "+ next.getKey());
                                        System.out.println(next.getValue().toStringSowHerb());
                                    }
                                } catch (NullPointerException e){
                                    e.printStackTrace();
                                }
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




    private User enterToAppForUser() {
        // TODO: 03.11.2021 Baza użytkowników!!! Walidacja
        LogicAppGenerateUser generateUser = new LogicAppGenerateUser();
        System.out.println("Rozpoczynasz korzystanie z programu. Masz już swoje konto? \nWpisz swoje imię");
        scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        user = generateUser.createNewUser(userName);
        System.out.println("witaj w programie <<<<<<<<<<<" + user.getName() + ">>>>>>>>>>>>>>>>>>");
        return user;
    }

    private static void firstStepForSetKitchenParametersLight(User user,LogicAppSetKitchenParameters kitchenParameters) {
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
                kitchenParameters.setLight(user,lightForKitchen);
            }
        }
    }
    private void threeStepForSetKitchenParametersTemperature(User user, LogicAppSetKitchenParameters kitchenParameters) {
        System.out.println("( 3 krok ) Spróbuj określić przybliżoną temperaturę jaka panuje w Twojej kuchni? ");
        System.out.println("0 - Bardzo mała temperatura \n1 - Temperatura średnia \n2 - Temperatura wysoka");
        int userWetnessChoice = scanner.nextInt();
        TemperatureInTheKitchen[] temperature = TemperatureInTheKitchen.values();
        for (TemperatureInTheKitchen temperatureInTheKitchen : temperature) {
            if (userWetnessChoice == temperatureInTheKitchen.ordinal()) {
                kitchenParameters.setTemperature(user,temperatureInTheKitchen);
            }
        }
    }
    private void twoStepForSetKitchenParametersWeatness(User user,LogicAppSetKitchenParameters kitchenParameters) {
        System.out.println("( 2 krok ) Spróbuj określić przybliżoną wartość wilgotności jaka panuje w Twojej kuchni? ");
        System.out.println("0 - Bardzo mała wilgotność, suche powietrze \n1 - Wilgotność optymalna \n2 - Wysoka wilgotność, szybkie pojawianie się pleśni w pomieszczeniu)");
        int userWetnessChoice = scanner.nextInt();
        WetnessForKitchen[] wetnessForKitchens = WetnessForKitchen.values();
        for (WetnessForKitchen wetnessForKitchen : wetnessForKitchens) {
            if (userWetnessChoice == wetnessForKitchen.ordinal()) {
                kitchenParameters.setWetness(user,wetnessForKitchen);
            }
        }
    }



    private HerbDetail checkInfoAboutHerbsOnDataBase() {

        List<HerbDetail> herbDetails1 = getHerbDetails();
        for (HerbDetail herbDetail : herbDetails1) {
            System.out.println(herbDetail.getName());
        }
        scanner = new Scanner(System.in);
        System.out.println("Wybierz zioło z listy, które chcesz zasiać. Każde zioło ma swoje preferencje hodowlane. Zastanów się czy Twoje pomieszczenie (balkon, kuchnia ..)spełniają określone wymogi.");
        String nameHerb = scanner.nextLine().toUpperCase();
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
