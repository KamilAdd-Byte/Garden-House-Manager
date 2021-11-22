package com.gardenhouse.gardenhousemanager.control.monthandday;

import java.time.Month;

public enum MonthOfSow {
    JANUARY ("styczeń",Month.JANUARY),
    FEBRUARY ("luty",Month.FEBRUARY),
    MARCH ("marzec",Month.MARCH),
    APRIL ("kwiecień",Month.APRIL),
    MAY ("maj",Month.MAY),
    JUNE ("czerwiec",Month.JUNE),
    JULY ("lipiec",Month.JULY),
    AUGUST ("sierpień",Month.AUGUST),
    SEPTEMBER ("wrzesień",Month.SEPTEMBER),
    OCTOBER ("październik",Month.OCTOBER),
    NOVEMBER ("listopad",Month.NOVEMBER),
    DECEMBER ("grudzień",Month.DECEMBER);

    private String describe;
    private Month month;

    MonthOfSow(String describe, Month month) {
        this.describe = describe;
        this.month = month;
    }

    public String getDescribe() {
        return describe;
    }
}
