package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.database.LogicAppHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.LogicAppSetKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.UserKitchenParameters;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.database.DataBaseForHerbs;
import com.gardenhouse.gardenhousemanager.appconsole.user.logic.LogicAppGenerateUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.basicwelcome.WelcomeInApp;
import com.gardenhouse.gardenhousemanager.flowerpot.PotSize;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;
import java.util.*;
import java.util.List;

public class LogicHerbsDetail implements Runnable{

    public static Scanner scanner;
    private static User user;
    private static final int EXIT = 0;
    private static final int GET_LIST = 1;
    private static final int ADD_HERB_TO_USER_LIST= 2;
    private static final int MY_HERB=3;

    @Override
    public void run() {
        int userChoice = 8;
        user = enterToAppForUser();
        scanner = new Scanner(System.in);

        while (userChoice != 0) {
            do {
                try {
                    String displayMenu = WelcomeInApp.displayTitleAndVersionApp();
                    System.out.println(displayMenu);
                    String basicMenu = WelcomeInApp.displayBasicMenu();
                    System.out.println(basicMenu);
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
                        case ADD_HERB_TO_USER_LIST:
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
                                search.setIdHerb(idHerb);
                                scanner.nextLine();

                                //Ustawienie parametrów kuchni
                                System.out.println("Wprowadzasz zmiany lub ustawiasz pierwszy raz parametry kuchni wpisz TAK \njeżeli masz już ustawione parametry wpisz NIE");
                                String answerCreateKitchenParameters = scanner.nextLine().toUpperCase();
                                LogicAppSetKitchenParameters kitchenParameters = new LogicAppSetKitchenParameters(user);
                                if (answerCreateKitchenParameters.equals("NIE")){
                                    System.out.println("Parametry Twojej kuchni: \n"+ user.getMyKitchen().toString());
                                }else if (answerCreateKitchenParameters.equals("TAK")){
                                    firstStepForSetKitchenParametersLight(user,kitchenParameters);
                                    twoStepForSetKitchenParametersWetness(user,kitchenParameters);
                                    threeStepForSetKitchenParametersTemperature(user,kitchenParameters);
                                    UserKitchenParameters myKitchen = user.getMyKitchen();
                                    System.out.println(myKitchen);
                                    scanner.nextLine();
                                } else {
                                    System.err.println("Błędna odpowiedź! spróbuj ponownie");
                                }

                                System.out.println("Czy na pewno chcesz dodać zioło do swojego panelu? TAK (Dodajemy zioło) lub NIE (Anulowanie operacji)");
                                String userAnswer = scanner.nextLine().toUpperCase();
                                if (userAnswer.equals("TAK")) {
                                    user.addMyHerb(nameUserHerb, search);
                                    System.out.println("Właśnie dodałeś zioło: \n" + search.toStringSowHerb());
                                } else if (userAnswer.equals("NIE")) {
                                    System.out.println("Rozumiem! Zioło nie zostało dodane do Twojego panelu. Pozostały tylko ustawienia parametrów w kuchni.");
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
                                    getHerbsForUser();
                                } catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                            }
                            break;
                        default:
                            System.err.println("Opcja wybrana jest błędna. Dostępne 0 1 2");
                    }

                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    System.err.println("Podano dane w nieprawidłowej postaci");
                }
               scanner.nextLine();
            } while (userChoice != 0);
        }
    }

    private void createFlowerPotByUser() {
        System.out.println("Utwórz obiekt doniczki, w której zasadzisz zioło z panelu");

        System.out.println("Rozmiar doniczki \n " +
                " ( 1 krok )Wybierz rozmiar? (0,1,2,3 lub 4)");
        PotSize[] values = PotSize.values();
        for (PotSize potSize : values) {
            System.out.println(potSize.getMl() + "ml; opcja: " + potSize.ordinal());
        }
        int size = scanner.nextInt();

    }

    private void getHerbsForUserByName() {
        System.out.println("_________________________________________________");
        System.out.println("Lista Twoich ziół:");
        System.out.println("_________________________________________________");
        scanner.nextLine();
        Map<String, HerbDetail> myHerbs = user.getMyHerbs();
        Set<Map.Entry<String, HerbDetail>> entries = myHerbs.entrySet();
        for (Map.Entry<String, HerbDetail> entryHerbs : entries) {
            System.out.println(entryHerbs.getKey() + " id: " +entryHerbs.getValue().getIdHerb());
        }
        System.out.println("Wpisz nazwę swojej rośliny, którą chcesz wyświetlić");
        String herbsByName = scanner.nextLine();
        for (Map.Entry<String, HerbDetail> entry : entries) {
            if (entry.getKey().contains(herbsByName)){
                System.out.println(entry.getValue().toStringSowHerb());
                System.out.println("Chcesz zasadzić lub podlać? PODLEJ  ZASADZ");
                String answer = scanner.nextLine().toUpperCase();
                if (answer.equals("ZASADZ")){
                    sowUserHerbs(entry);
                }else if (answer.equals("PODLEJ")){
                    // TODO: 09.11.2021  
                }else {
                    // TODO: 09.11.2021  
                }
            }else {
                System.out.println("Nie znaleziono po nazwie");
            }
        }
    }

    private void sowUserHerbs(Map.Entry<String, HerbDetail> entry) {
        HerbDetail value = entry.getValue();
        System.out.println( "Obiekt do zasadzenia" + value);
        HerbDetail.FlowerPot flowerPot = value.instance();
        // TODO: 09.11.2021 Tworzenie doniczki i przypisanie jej do zioła! 
    }

    private void getHerbsForUser() {
        Map<String, HerbDetail> myHerbs = user.getMyHerbs();
        Set<Map.Entry<String, HerbDetail>> entries = myHerbs.entrySet();
        for (Map.Entry<String, HerbDetail> next : entries) {
            System.out.println("Twoja nazwa rośliny: "+ next.getKey());
            System.out.println(next.getValue().toStringSowHerb());
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
        System.out.println("0 - Bardzo niska temperatura - poniżej 17 stopni C \n1 - Temperatura średnia - w przedziale 18-22 stopni C\n2 - Temperatura wysoka - powyżej 23 stopni C  ");
        int userWetnessChoice = scanner.nextInt();
        TemperatureInTheKitchen[] temperature = TemperatureInTheKitchen.values();
        for (TemperatureInTheKitchen temperatureInTheKitchen : temperature) {
            if (userWetnessChoice == temperatureInTheKitchen.ordinal()) {
                kitchenParameters.setTemperature(user,temperatureInTheKitchen);
            }
        }
    }
    private void twoStepForSetKitchenParametersWetness(User user, LogicAppSetKitchenParameters kitchenParameters) {
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


    /**
     * @return Herb on data base
     */
    private HerbDetail checkInfoAboutHerbsOnDataBase() {
        List<HerbDetail> herbDetails = getHerbDetails();
        for (HerbDetail herbDetail : herbDetails) {
            System.out.println(herbDetail.getName());
        }
        scanner = new Scanner(System.in);
        System.out.println("Wybierz zioło z listy, które chcesz zasiać. Każde zioło ma swoje preferencje hodowlane. Zastanów się czy Twoje pomieszczenie (balkon, kuchnia ..)spełniają określone wymogi.");
        String nameHerb = scanner.nextLine().toUpperCase();
        LogicAppHerbs logicAppHerbs = new LogicAppHerbs();
        HerbDetail herbDetail = logicAppHerbs.search(nameHerb);
        System.out.println("Preferowane warunki hodowlane dla tego zioła" + "\n");
        System.out.println(herbDetail.toString());
        return herbDetail;

    }

    private List<HerbDetail> getHerbDetails() {
        DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();
        return dataBaseForHerbs.allHerbs();
    }

}
