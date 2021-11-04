package com.gardenhouse.gardenhousemanager.appconsole.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author kamillodzinski
 * Klasa tworząca Usera i zapisywania go do prywatnej listy api
 */
public class LogicAppGenerateUser {
    private User user;
    private List<User> allUser;

    public LogicAppGenerateUser(User user, List<User> allUser) {
        this.user = user;
        this.allUser = allUser;
    }

    public LogicAppGenerateUser() { }

    /**
     * @param name of user
     * @return new object User
     */
    public User createNewUser(String name){
        this.user = new User(name);
        return this.user;
    }

    /**
     * @param user create user which it is not NULL
     */
    public void addUserToList (User user){
        if (allUser==null){
            allUser = new ArrayList<>();
        }
        allUser.add(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getAllUser() {
        return allUser;
    }

    public void setAllUser(List<User> allUser) {
        this.allUser = allUser;
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

    @Override
    public String toString() {
        return "LogicAppGenerateUser{" +
                "user=" + user +
                ", allUser=" + allUser +
                '}';
    }
}
