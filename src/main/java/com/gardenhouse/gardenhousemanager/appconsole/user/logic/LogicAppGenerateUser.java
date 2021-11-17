package com.gardenhouse.gardenhousemanager.appconsole.user.logic;

import com.gardenhouse.gardenhousemanager.appconsole.user.User;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author kamil sulejewski
 * Klasa tworząca Usera i zapisywania go do prywatnej listy api
 */
public class LogicAppGenerateUser {
    private User user;
    private UserLogged userLogged;
    private List<UserLogged> allUser;

    public LogicAppGenerateUser() { }

    /**This is constructor for logged user
     * @param userLogged logged user in app database
     * @param allUser all logged users
     */
    public LogicAppGenerateUser(UserLogged userLogged, List<UserLogged> allUser) {
        this.userLogged = userLogged;
        this.allUser = allUser;
    }

    /**
     * @param name of user
     * @return new object User
     */
    public User createNewUser(String name){
        this.user = new User(name);
        return this.user;
    }

    /** This method is used for create new logged user
     * @param name of user
     * @param login of user
     * @param password of user
     * @return new logged user
     */
    public UserLogged createNewLoggedUser(String name,String login, String password){
        if (userLogged==null){
            userLogged = new UserLogged();
        }
        userLogged.setName(name);
        userLogged.setLogin(login);
        userLogged.setPassword(password);
        if (allUser==null){
            allUser = new ArrayList<>();
        }
        allUser.add(userLogged);
        return userLogged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicAppGenerateUser)) return false;
        LogicAppGenerateUser that = (LogicAppGenerateUser) o;
        return user.equals(that.user) && Objects.equals(allUser, that.allUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, allUser);
    }

}
