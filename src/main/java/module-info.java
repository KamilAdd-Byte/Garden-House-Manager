module Garden.House.Manager {
    requires java.persistence;
    requires spring.boot.starter;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.data.commons;
    requires spring.core;
    requires spring.expression;
    requires spring.data.jpa;
    requires com.h2database;

    exports com.gardenhouse.gardenhousemanager;
}
