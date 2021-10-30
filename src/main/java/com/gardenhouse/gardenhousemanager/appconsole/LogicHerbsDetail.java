package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.*;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.List;
import java.util.Scanner;

public class LogicHerbsDetail implements Runnable{
    public static final Scanner scanner = new Scanner(System.in);

    private static final int EXIT = 0;
    private static final int GET_LIST = 1;
    private static final int BASIL= 2;

    @Override
    public void run() {
        int userChoice = 8;

        while (userChoice!=0){
            System.out.println("Wybierz: 0 - Wyjście  1 - Lista Ziół  2 - Zasadź Bazylię");
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
                case BASIL:
                    System.err.println("Dopiero implementuję :)");
            }

        }
    }
}
