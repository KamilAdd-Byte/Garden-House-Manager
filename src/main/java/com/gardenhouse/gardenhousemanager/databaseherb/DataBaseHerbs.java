//package com.gardenhouse.gardenhousemanager.databaseherb;
//
//import com.gardenhouse.gardenhousemanager.model.Herb;
//import com.gardenhouse.gardenhousemanager.model.HerbDetail;
//
//import java.util.HashSet;
//import java.util.Iterator;
//
//public class DataBaseHerbs extends HashSet<HerbDetail> {
//    private final HashSet<HerbDetail> herbs = new HashSet<>();
//
//    @Override
//    public Iterator<HerbDetail> iterator() {
//        return this.herbs.iterator();
//    }
//
//    @Override
//    public int size() {
//        return this.herbs.size();
//    }
//
//    @Override
//    public boolean add(HerbDetail herb) {
//        if (herb != null) {
//            return this.herbs.add(herb);
//        }
//        return false;
//    }
//
//    public HashSet<HerbDetail> herbs() {
//
//    }
// }
