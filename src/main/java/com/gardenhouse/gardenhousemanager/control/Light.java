package com.gardenhouse.gardenhousemanager.control;

public enum Light {
    LITTLE("Małe zapotrzebowanie na światło. Półmrok"),
    MEDIUM("Średnie zapotrzebowanie na światło. Światło dla rosliny przynajmniej 5 godzin dziennie"),
    HARD("Wysokie zapotrzebowanie na światło. Rożlina powinna mieć dostęp do światła cały czas ");

    private String description;

    Light(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
