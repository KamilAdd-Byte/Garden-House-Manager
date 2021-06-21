module Garden.House.Manager {
    requires java.persistence;
    requires spring.boot.starter;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot.starter.json;
    requires spring.beans;
    requires spring.web;
    requires spring.data.commons;
    requires spring.core;
    requires spring.boot.starter.data.jpa;
    requires spring.expression;
    requires spring.data.jpa;
    requires com.h2database;


    opens com.gardenhouse.gardenhousemanager.repository;
    opens com.gardenhouse.gardenhousemanager.model;
    opens com.gardenhouse.gardenhousemanager.rest;
    opens com.gardenhouse.gardenhousemanager.service;
    opens com.gardenhouse.gardenhousemanager.serviceImpl;
    opens com.gardenhouse.gardenhousemanager.control;
    opens com.gardenhouse.gardenhousemanager;

    exports com.gardenhouse.gardenhousemanager;
    exports com.gardenhouse.gardenhousemanager.rest;
    exports com.gardenhouse.gardenhousemanager.model;
    exports com.gardenhouse.gardenhousemanager.control;
    exports com.gardenhouse.gardenhousemanager.repository;
    exports com.gardenhouse.gardenhousemanager.service;
    exports com.gardenhouse.gardenhousemanager.serviceImpl;
    exports com.gardenhouse.gardenhousemanager.live;
}
