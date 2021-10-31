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
                22.5,25.5,false,"Kwiecień"));
        herbDetails.add(new HerbDetail("Liść laurowy","https://st.depositphotos.com/1000141/2653/i/600/depositphotos_26536615-stock-photo-basil-leaves-in-closeup.jpg",
                0, WaterConsumption.LITTLE, Light.LITTLE, Wetness.OPTIMUM,"Liść laurowy wraz z zielem angielskim tworzy duet, który jest niezbędny do przygotowywania dań na ciepło – zup, sosów czy gulaszy. Najczęściej decydujemy się na gotową suszoną postać przyprawy dostępną na sklepowych półkach. " +
                "Liście laurowe możemy również uprawiać na parapecie..Świeże liście laurowe – obrywa się na bieżąco (zimą mniej), " +
                "w miarę potrzeb. Najbardziej aromatyczne są młode liście.",
                20,25,false,"Marzec,Kwiecień"));
        herbDetails.add(new HerbDetail("Tymianek","https://img.shmbk.pl/rimgsph/1102383_f6256a52-656a-49e4-8b4d-4466c1537b41_crop_1250_750_zdjecie.jpg",
                0, WaterConsumption.LITTLE, Light.HARD, Wetness.MINIMUM," Wykorzystuje się go do potraw kuchni francuskiej oraz śródziemnomorskiej. Idealnie pasuje do mięsnych potraw (w szczególności z jagnięciną), potrawek na bazie strączków, a także do serów (zwłaszcza kozich), jajecznych przekąsek i kanapek.",
                10,15,false,"Przełom Maj - Czerwiec"));
        herbDetails.add(new HerbDetail("Mięta","https://histografy.pl/wp-content/uploads/2020/09/mieta-pieprzowa.jpg",
                0, WaterConsumption.MEDIUM, Light.MEDIUM, Wetness.OPTIMUM,"Lekka, orzeźwiająca i soczyście zielona mięta sprawdzi się zarówno do dań słodkich, jak i wytrawnych. Doskonale pasuje do zimnych napojów i " +
                "drinków z dodatkiem cytryny lub limonki (np. lemoniady czy mojito), a także do sałatek owocowych czy warzywnych.", 18,23,false,"Przełom Maj - Czerwiec"));
        herbDetails.add(new HerbDetail("Szczypiorek","https://www.diki.pl/images-common/words400/chives.jpg",
                0, WaterConsumption.MEDIUM, Light.MEDIUM, Wetness.OPTIMUM,"Długie łodygi szczypiorku przypominające zielone rurki idealnie współgrają z jajecznymi potrawami, nadając im ostrości i świeżego aromatu. Świetnie pasują również do sałatek, mięsnych " +
                "dań czy potraw zapiekanych w piekarniku, a także jako dekoracyjne wykończenie przekąsek (np. kanapek czy przystawek).", 20,25,false,"Przełom Marzec - Kwiecień"));
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
        // TODO: 31.10.2021
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
