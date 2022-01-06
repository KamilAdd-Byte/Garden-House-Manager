package com.gardenhouse.gardenhousemanager.appconsole.user.service.impl;

import com.gardenhouse.gardenhousemanager.appconsole.database.connect.DBConnector;
import com.gardenhouse.gardenhousemanager.appconsole.database.insert.DBInsertRecord;
import com.gardenhouse.gardenhousemanager.appconsole.database.table.DBCreateTableUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import com.gardenhouse.gardenhousemanager.appconsole.user.service.DisplayQuestion;
import com.gardenhouse.gardenhousemanager.appconsole.user.service.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author kamil sulejewski
 * Klasa odpowiedzialna za tworzenie nowego użutkownika i zapisywania go do bazy danych H2 w pliku
 * @see DBConnector łączenie z bazą H2
 * @see DBCreateTableUser tworzenie tabeli użytkownika
 * @see DBInsertRecord dodawanie użytkownika do bazy
 */
public class UserServiceImpl implements UserService, DisplayQuestion {
    private User user;
    private UserLogged userLogged;
    private Scanner scanner;

    public UserServiceImpl() {
    }

    /**
     * This is constructor for logged user
     * @param userLogged logged user in app database
     */
    public UserServiceImpl(UserLogged userLogged) {
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
     * This method is used for create new logged user and save his on data base
     * @return new logged user
     */
    @Override
    public UserLogged createNewLoggedUser() {
        if (userLogged == null) {
            userLogged = new UserLogged();
        }
        scanner = new Scanner(System.in);

        setUserName();
        setUserLogin();
        setUserPassword();

        addedUserToDB(userLogged);//zapisanie do bazy

        return userLogged;
    }

    private void setUserPassword() {
        System.out.println(displayQuestionForPassword());
        String password = scanner.nextLine();
        userLogged.setPassword(password);
    }

    private void setUserLogin() {
        System.out.println(displayQuestionForLogin());
        String login = scanner.nextLine();
        userLogged.setLogin(login);
    }

    private void setUserName() {
        System.out.println(displayQuestionForName());
        String name = scanner.nextLine();
        if (name!=null){
            userLogged.setName(name);
        }
    }

    @Override
    public UserLogged searchUserByLogin(String login){
        UserLogged result = null;
        scanner = new Scanner(System.in);
        System.out.println(displayQuestionForLogin());
        login = scanner.nextLine();
        Connection connect = DBConnector.connect();
        try {
            Statement statement = connect.createStatement();
            String sql = "select * from USER where login = "+"'"+login+"'";
            ResultSet resultSet = statement.executeQuery(sql);

            result = (UserLogged) resultSet;
            System.out.println("znaleziono " + resultSet);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public UserLogged removeUserByLogin(String login) {
        return null;
    }


    /**
     * @param user new create user which fields write by user in createNewLoggedUser() method.
     */
    private void addedUserToDB(UserLogged user) {
        DBInsertRecord.insertUser(user);
    }

    @Override
    public String displayQuestionForName() {
        return "Podaj imię";
    }

    @Override
    public String displayQuestionForLogin() {
        return "Podaj login";
    }

    @Override
    public String displayQuestionForPassword() {
        return "Podaj hasło";
    }
}
