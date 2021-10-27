//package com.gardenhouse.gardenhousemanager.databaseherb;
//
//import com.gardenhouse.gardenhousemanager.model.Herb;
//import com.gardenhouse.gardenhousemanager.model.Herbs;
//
//import java.util.HashSet;
//import java.util.Iterator;
//
//public class DataBaseHerbs extends HashSet<Herbs> {
//    private final HashSet<Herbs> herbs = new HashSet<>();
//
//    @Override
//    public Iterator<Herbs> iterator() {
//        return this.herbs.iterator();
//    }
//
//    @Override
//    public int size() {
//        return this.herbs.size();
//    }
//
//    @Override
//    public boolean add(Herbs herb) {
//        if (herb != null) {
//            return this.herbs.add(herb);
//        }
//        return false;
//    }
//
//    public HashSet<Herbs> herbs() {
//
//    }
// }
