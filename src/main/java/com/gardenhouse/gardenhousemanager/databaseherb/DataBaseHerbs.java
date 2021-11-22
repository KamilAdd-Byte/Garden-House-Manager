//package com.gardenhouse.gardenhousemanager.databaseherb;
//
//import com.gardenhouse.gardenhousemanager.model.Herb;
//import com.gardenhouse.gardenhousemanager.model.HerbDto;
//
//import java.util.HashSet;
//import java.util.Iterator;
//
//public class DataBaseHerbs extends HashSet<HerbDto> {
//    private final HashSet<HerbDto> herbs = new HashSet<>();
//
//    @Override
//    public Iterator<HerbDto> iterator() {
//        return this.herbs.iterator();
//    }
//
//    @Override
//    public int size() {
//        return this.herbs.size();
//    }
//
//    @Override
//    public boolean add(HerbDto herb) {
//        if (herb != null) {
//            return this.herbs.add(herb);
//        }
//        return false;
//    }
//
//    public HashSet<HerbDto> herbs() {
//
//    }
// }
