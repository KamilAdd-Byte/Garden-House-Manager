package com.gardenhouse.gardenhousemanager.appconsole;

public enum LightForKitchen {
    LITTLE(1, "Twoje miejsce w kuchni jest mało naświetlone. Może to być przeszkodą w prawidłowym rozwoju niektórych ziół. Spróbuj poszukać miejsca w domu, które jest bardziej nasłonecznione np: parapet w pokoju itp. "),
    MEDIUM(2, "Miejsce średnio naświetlone. Mimo wszystko bardzo dobrze wpływa na wzrost ziół"),
    STRONG(3, "Bardzo naświetlona kuchnia. Zdecydowanie najlepsze miejsce dla rozwoju ziół. Pamietaj tylko, że niektóre zioła nie lubią stać w pełnym słońcu.");

    private int lightScale;
    private String description;

    LightForKitchen(int lightScale, String description) {
        this.lightScale = lightScale;
        this.description = description;
    }
}
