package com.gardenhouse.gardenhousemanager.appconsole.user.logic;

import com.gardenhouse.gardenhousemanager.appconsole.database.DBConnector;
import com.gardenhouse.gardenhousemanager.appconsole.database.table.DBCreateTableUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
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
 * Klasa tworząca Usera i zapisywania go do bazy danych H2 w pliku
 * @see DBConnector łączenie z bazą H2
 * @see DBCreateTableUser tworzenie tabeli użytkownika
 */
public class LogicAppGenerateAndSaveUser {
    private User user;
    private static UserLogged userLogged;
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
     * This method is used for create new logged user and save his on data base
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

        addedUserToDB(userLogged);//zapisanie do bazy

        return userLogged;
    }

    public ResultSet searchUserByLogin(String login){
        ResultSet result = null;
        scanner = new Scanner(System.in);
        System.out.println("Podaj login");
        login = scanner.nextLine();
        Connection connect = DBConnector.connect();
        try {
            Statement statement = connect.createStatement();
            String sql = "select * from USER where login = "+"'"+login+"'";
            result = statement.executeQuery(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @param userLogged logged user which fields write for user in createNewLoggedUser() method.
     */
    private void addedUserToDB(UserLogged userLogged) {
        String password = userLogged.getPassword();
        String name = userLogged.getName();
        String login = userLogged.getLogin();
        try {
            Connection connect = DBConnector.connect();
            DBCreateTableUser.createUserTable(connect);
            Statement statement = connect.createStatement();
            String sql = "insert into USER(name,login,password)" + "values('"+name+"','"+login+"','"+password +"')";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
