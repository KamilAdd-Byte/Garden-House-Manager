package com.gardenhouse.gardenhousemanager.flowerpot;

/**
 * Type of soil for plants - 'Typ ziemi dla roślin'.
 */
public enum KindOfSoil {

    HUMUS_SOIL("Ziemia próchnicza"),
    SOIL_GARDEN("Ziemia bezpośrednio z ogrodu"),
    SUBSOIL("Podłoże ogrodnicze do kwiatów"),
    FERTILE_SOIL("Ziemia żyzna");

    private String description;

    KindOfSoil(String description) {
        this.description = description;
    }
}
