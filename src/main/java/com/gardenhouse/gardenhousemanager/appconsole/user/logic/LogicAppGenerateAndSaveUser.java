package com.gardenhouse.gardenhousemanager.appconsole.user.logic;

import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

/**
 * @author kamil sulejewski
 * Klasa tworząca Usera i zapisywania go do prywatnej listy api
 */
public class LogicAppGenerateAndSaveUser {
    private User user;
    private UserLogged userLogged;
    private static File file;
    private static Scanner scanner;

    public LogicAppGenerateAndSaveUser() {
    }

    /**
     * This is constructor for logged user
     * @param userLogged logged user in app database
     */
    public LogicAppGenerateAndSaveUser(UserLogged userLogged) {
        this.userLogged = userLogged;

    }

    /**
     * @param name of default user
     * @return new object User
     */
    public User createNewUser(String name) {
        this.user = new User(name);
        return this.user;
    }

    /**
     * This method is used for create new logged user
     * @return new logged user
     */
    public UserLogged createNewLoggedUser() {
        scanner = new Scanner(System.in);
        System.out.println("Podaj imię");
        String name = scanner.nextLine();
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String password = scanner.nextLine();
        if (userLogged == null) {
            userLogged = new UserLogged();
        }
        userLogged.setName(name);
        userLogged.setLogin(login);
        userLogged.setPassword(password);
        addUserToFile(userLogged);
        return userLogged;
    }

    private static File createNewFile(){
        file = new File("users");
        return file;
    }

    private void addUserToFile(UserLogged user){
        userLogged = user;
        File usersFile = createNewFile();
        try {
            PrintWriter writer = new PrintWriter(usersFile);
            writer.println(userLogged.getLogin() +";"+ userLogged.getName() +";" + userLogged.getPassword());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
