package com.gardenhouse.gardenhousemanager.appconsole.control;

import lombok.Getter;

@Getter
public enum WetnessForKitchen {
    MINIMUM (0, "Pomieszczenie: Niska wilgotność powietrza wpływa niekorzystnie na zdrowie i samopoczucie człowieka oraz powoduje rozsychanie się parkietów i mebli. Niekorzystnie wpływa również na rozwój niektórych roślin. Nasilenie tego zjawiska obserwujemy w okresie grzewczym, kiedy wilgotność powietrza jest bardzo niska, spadając do poziomu 20-30%."),
    OPTIMUM(1, "Pomieszczenie: Optymalna wilgotność 40-60 %"),
    MAXIMUM(2, "Pomieszczenie: W warunkach nadmiernej wilgoci rozwijają się roztocza, pojawiają się grzyby i pleśń. Wszystko to szkodliwe patogeny, które bardzo źle znoszą alergicy o osoby o wrażliwym układzie oddechowym, w tym dzieci. Wystąpić mogą problemy z oddychaniem, ale też pogorszenie się samopoczucia.");

    private int wetness;
    private String description;

    WetnessForKitchen(int wetness, String description) {
        this.wetness = wetness;
        this.description = description;
    }
}
