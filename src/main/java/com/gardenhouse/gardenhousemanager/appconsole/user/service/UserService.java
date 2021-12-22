package com.gardenhouse.gardenhousemanager.appconsole.user.service;

import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

public interface UserService {
    UserLogged createNewLoggedUser();
    UserLogged searchUserByLogin(String login);
    UserLogged removeUserByLogin(String login);
}
