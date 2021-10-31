package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

/**
 * Class for console app.
 */
@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ListHerbs implements List<HerbDetail> {

    private List<HerbDetail> herbDetails;

    public List<HerbDetail> allHerbs(){
        if (herbDetails==null){
            herbDetails = new ArrayList<>();
        }
        herbDetails.add(new HerbDetail("Bazylia","https://st.depositphotos.com/1000141/2653/i/600/depositphotos_26536615-stock-photo-basil-leaves-in-closeup.jpg",
                0, WaterConsumption.MEDIUM, Light.MEDIUM, Wetness.OPTIMUM,"Porządne zioło",
                22.5,25.5,false,"Maj"));
        herbDetails.add(new HerbDetail("Liść laurowy","https://st.depositphotos.com/1000141/2653/i/600/depositphotos_26536615-stock-photo-basil-leaves-in-closeup.jpg",
                0, WaterConsumption.LITTLE, Light.LITTLE, Wetness.OPTIMUM,"Przyprawa do zup a szczególnie rosołu.Świeże liście laurowe – obrywa się na bieżąco (zimą mniej), w miarę potrzeb. Najbardziej aromatyczne są młode liście.",
                20,25,false,"Marzec,Kwiecień"));
        herbDetails.add(new HerbDetail("Tymianek","https://img.shmbk.pl/rimgsph/1102383_f6256a52-656a-49e4-8b4d-4466c1537b41_crop_1250_750_zdjecie.jpg",
                0, WaterConsumption.LITTLE, Light.HARD, Wetness.MINIMUM," Ma on postać małej krzewinki o drobnych listkach, ale tkwi w nim wielka moc. Potrawom mięsnym, rybnym i warzywnym nadaje dymnego, pikantnego posmaku – " +
                "można go także stosować jako dodatek do omletów, sosów, zapiekanek i potraw z makaronu.",
                10,15,false,"Marzec1"));
        return herbDetails;
    }

    @Override
    public int size() {
        return this.herbDetails.size();
    }

    @Override
    public boolean isEmpty() {
        return this.herbDetails.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<HerbDetail> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(HerbDetail herbDetail) {
        if (herbDetails==null){
            herbDetails = new ArrayList<>();
        }
        if (herbDetail!=null){
            return this.herbDetails.add(herbDetail);
        }else {
            log.info("Nie udało sie dodać zioło do bazy");
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return this.herbDetails.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends HerbDetail> collection) {
        return this.herbDetails.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends HerbDetail> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        this.herbDetails.clear();
    }

    @Override
    public boolean equals(Object o) {
        return this.herbDetails.equals(o);
    }

    @Override
    public int hashCode() {
        return this.herbDetails.hashCode();
    }

    @Override
    public HerbDetail get(int i) {
        return this.herbDetails.get(i);
    }

    @Override
    public HerbDetail set(int i, HerbDetail herbDetail) {
        return this.herbDetails.set(i,herbDetail);
    }

    @Override
    public void add(int i, HerbDetail herbDetail) {
        this.herbDetails.add(i,herbDetail);
    }

    @Override
    public HerbDetail remove(int i) {
        return this.herbDetails.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<HerbDetail> listIterator() {
        return this.herbDetails.listIterator();
    }

    @Override
    public ListIterator<HerbDetail> listIterator(int i) {
        return this.herbDetails.listIterator(i);
    }

    @Override
    public List<HerbDetail> subList(int i, int i1) {
        return this.herbDetails.subList(i, i1);
    }
}
