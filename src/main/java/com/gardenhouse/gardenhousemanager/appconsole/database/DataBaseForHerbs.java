package com.gardenhouse.gardenhousemanager.appconsole.database;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.monthandday.MonthOfSow;
import com.gardenhouse.gardenhousemanager.flowerpot.parameters.KindOfSoil;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
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
public class DataBaseForHerbs implements List<HerbDto> {

    private List<HerbDto> herbsDtos;

    public List<HerbDto> allHerbs(){
        if (herbsDtos ==null){
            herbsDtos = new ArrayList<>();
        }
        herbsDtos.add(new HerbDto("BAZYLIA","https://st.depositphotos.com/1000141/2653/i/600/depositphotos_26536615-stock-photo-basil-leaves-in-closeup.jpg",
                WaterConsumption.MEDIUM, Light.MEDIUM, "Jako roślina użytkowa i lecznicza. Surowcem przyprawowym jest ziele bazylii,używane w stanie świeżym lub suszonym. Liście bazylii dodaje sie do sałatek, sosów, twarogu, zapiekanek, zup (szczególnie pomidorowej), potraw miesnych i ryb.",
                22.5,25.5,MonthOfSow.JULY,new KindOfSoil[]{KindOfSoil.HUMUS_SOIL}));
        herbsDtos.add(new HerbDto("LIŚĆ LAUROWY","https://st.depositphotos.com/1000141/2653/i/600/depositphotos_26536615-stock-photo-basil-leaves-in-closeup.jpg",
                WaterConsumption.LITTLE, Light.LITTLE, "Liść laurowy wraz z zielem angielskim tworzy duet, który jest niezbędny do przygotowywania dań na ciepło – zup, sosów czy gulaszy. Najczęściej decydujemy się na gotową suszoną postać przyprawy dostępną na sklepowych półkach. " +
                "Liście laurowe możemy również uprawiać na parapecie..Świeże liście laurowe – obrywa się na bieżąco (zimą mniej), " +
                "w miarę potrzeb. Najbardziej aromatyczne są młode liście.",
                18,22,MonthOfSow.MARCH,new KindOfSoil[]{KindOfSoil.HUMUS_SOIL}));
        herbsDtos.add(new HerbDto("TYMIANEK","https://img.shmbk.pl/rimgsph/1102383_f6256a52-656a-49e4-8b4d-4466c1537b41_crop_1250_750_zdjecie.jpg",
                WaterConsumption.LITTLE, Light.HARD, " Wykorzystuje się go do potraw kuchni francuskiej oraz śródziemnomorskiej. Idealnie pasuje do mięsnych potraw (w szczególności z jagnięciną), potrawek na bazie strączków, a także do serów (zwłaszcza kozich), jajecznych przekąsek i kanapek.",
                15,23,MonthOfSow.MAY,new KindOfSoil[]{KindOfSoil.HUMUS_SOIL}));
        herbsDtos.add(new HerbDto("MIETA","https://histografy.pl/wp-content/uploads/2020/09/mieta-pieprzowa.jpg",
                WaterConsumption.MEDIUM, Light.MEDIUM, "Lekka, orzeźwiająca i soczyście zielona mięta sprawdzi się zarówno do dań słodkich, jak i wytrawnych. Doskonale pasuje do zimnych napojów i " +
                "drinków z dodatkiem cytryny lub limonki (np. lemoniady czy mojito), a także do sałatek owocowych czy warzywnych.", 18,23,MonthOfSow.MAY,new KindOfSoil[]{KindOfSoil.HUMUS_SOIL}));
        herbsDtos.add(new HerbDto("SZCZYPIOREK","https://www.diki.pl/images-common/words400/chives.jpg",
                WaterConsumption.MEDIUM, Light.MEDIUM, "Długie łodygi szczypiorku przypominające zielone rurki idealnie współgrają z jajecznymi potrawami, nadając im ostrości i świeżego aromatu. Świetnie pasują również do sałatek, mięsnych " +
                "dań czy potraw zapiekanych w piekarniku, a także jako dekoracyjne wykończenie przekąsek (np. kanapek czy przystawek).", 20,25, MonthOfSow.APRIL,new KindOfSoil[]{KindOfSoil.HUMUS_SOIL,KindOfSoil.SUBSOIL}));
        herbsDtos.add(new HerbDto("KOCI MIETKA","https://lh3.googleusercontent.com/proxy/H0STCef8hJtlrUOaQ61ueUgp3tIRZ6o6jvNhMatV3TrugrW-2VzCSoBjSdmNkUcLiFEdcwhJNJc70gGLOTSg76ODQ0MX0uoVjhh3nkYfjGi_",
                WaterConsumption.MEDIUM, Light.MEDIUM, "Kocimiętkę można wykorzystywać do urozmaicania rabat w ogrodach naturalistycznych, wiejskich i śródziemnomorskich. Warto ją również uprawiać w pobliżu altan, na tarasie i balkonie, gdyż odstrasza niektóre owady (np.: muchy i komary!). " +
                "To ponadto znana roślina miododajna i przyciąga pożyteczną faunę. Kocimiętka to również znane zioło – wykazuje działania bakteriobójcze, moczopędnie, przeciwzapalnie i relaksujące.", 20,23,MonthOfSow.MAY,new KindOfSoil[]{KindOfSoil.SUBSOIL}));
        herbsDtos.add(new HerbDto("KLOSOWIEC POMARSZCZONY","https://zielonyogrodek.pl/i/images/4/1/7/d2FjPTc3MHgx_src_88417-Kosowiec-agastache-fot.-Martin-Rupprechter---Pixabay.jpg",
                WaterConsumption.BIG, Light.HARD, "Kłosowiec pomarszczony (Agastache rugosa) nazywany też miętą koreańską. W krajach azjatyckich roślina wykorzystywana jest także jako przyprawa kulinarna (świeża lub suszona). Świeże liście można dodawać do napojów, sałatek i deserów. " +
                "Kłosowiec uznawany jest też za roślinę leczniczą, wykazującą min. działanie przeciwgorączkowe i przeciwbiegunkowe. Liście mają delikatny, anyżowo-miętowy aromat.", 20,23,MonthOfSow.JUNE,new KindOfSoil[]{KindOfSoil.FERTILE_SOIL,KindOfSoil.SOIL_GARDEN,KindOfSoil.HUMUS_SOIL}));
        return herbsDtos;
    }

    @Override
    public int size() {
        return this.herbsDtos.size();
    }

    @Override
    public boolean isEmpty() {
        return this.herbsDtos.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.herbsDtos.contains(o);
    }

    @Override
    public Iterator<HerbDto> iterator() {
        return this.herbsDtos.iterator();
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
    public boolean add(HerbDto herbDto) {
        if (herbsDtos ==null){
            herbsDtos = new ArrayList<>();
        }
        if (herbDto !=null){
            return this.herbsDtos.add(herbDto);
        }else {
            log.info("Nie udało sie dodać zioło do bazy");
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return this.herbsDtos.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends HerbDto> collection) {
        return this.herbsDtos.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends HerbDto> collection) {
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
        this.herbsDtos.clear();
    }

    @Override
    public boolean equals(Object o) {
        return this.herbsDtos.equals(o);
    }

    @Override
    public int hashCode() {
        return this.herbsDtos.hashCode();
    }

    @Override
    public HerbDto get(int i) {
        return this.herbsDtos.get(i);
    }

    @Override
    public HerbDto set(int i, HerbDto herbDto) {
        return this.herbsDtos.set(i, herbDto);
    }

    @Override
    public void add(int i, HerbDto herbDto) {
        this.herbsDtos.add(i, herbDto);
    }

    @Override
    public HerbDto remove(int i) {
        return this.herbsDtos.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return herbsDtos.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<HerbDto> listIterator() {
        return this.herbsDtos.listIterator();
    }

    @Override
    public ListIterator<HerbDto> listIterator(int i) {
        return this.herbsDtos.listIterator(i);
    }

    @Override
    public List<HerbDto> subList(int i, int i1) {
        return this.herbsDtos.subList(i, i1);
    }
}
