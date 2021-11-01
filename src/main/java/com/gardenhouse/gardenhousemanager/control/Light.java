package com.gardenhouse.gardenhousemanager.control;

public enum Light {
    LITTLE(1, "Małe zapotrzebowanie na światło. Półmrok"),
    MEDIUM(2, "Średnie zapotrzebowanie na światło. Światło dla rośliny przynajmniej 5 godzin dziennie na kuchennym parapecie "),
    HARD(3, "Wysokie zapotrzebowanie na światło. Roślina powinna mieć dostęp do światła cały czas. Kuchenny parapet to idealne miejsce ");

    private int lightScale;
    private String description;

    Light(int lightScale, String description) {
        this.lightScale = lightScale;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getLightScale() {
        return lightScale;
    }

    public void setLightScale(int lightScale) {
        this.lightScale = lightScale;
    }
}
