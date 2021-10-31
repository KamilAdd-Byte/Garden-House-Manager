package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.*;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;
import com.gardenhouse.gardenhousemanager.service.HerbsService;
import com.gardenhouse.gardenhousemanager.serviceImpl.HerbsServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

    private static final int EXIT = 0;
    private static final int GET_LIST = 1;
    private static final int HERB= 2;
    private static final int MY_HERB=3;
    @Override
    public void run() {
        int userChoice = 8;

        while (userChoice!=0){
            System.out.println(title);
            System.out.println("Wybierz: 0 - Wyjście  1 - Lista Ziół  2 - Zasadź zioło  3 - Moje zioła");
            userChoice = scanner.nextInt();

            switch (userChoice){
                case EXIT:
                    System.out.println("Do zo ba! Byku! Wróć kiedys jeszcze");
                    scanner.close();
                case GET_LIST:
                    ListHerbs listHerbs = new ListHerbs();
                    List<HerbDetail> herbDetails = listHerbs.allHerbs();
                    herbDetails.forEach(System.out::println);
                    break;
                case HERB:
                    System.out.println("WYbierz zioło, które chcesz zasiać i wpisz jego nazwę");
                    scanner = new Scanner(System.in);
                    String nameHerb = scanner.nextLine();
                    ListHerbs ls = new ListHerbs();
                    HerbDetail search = ls.search(nameHerb);
                    search.sow(search);
                    System.out.println("Własnie zasadziłes zioło: " + search.toStringSowHerb());
                    break;
                case MY_HERB:
                    System.out.println("Twoje zasadzone zioła i ich paramatry");
                    HerbDetail.MyHerbs myHerbs = new HerbDetail.MyHerbs();
                    List<HerbDetail> sowHerbs = myHerbs.getSowHerbs();
                    sowHerbs.forEach(System.out::println);
                    break;
                default:
                    System.err.println("Opcja wybrana jest błedna. Dostepne 0 1 2");
            }

        }
    }

}
