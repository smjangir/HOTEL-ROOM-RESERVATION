package com.shubham.hotelreservation.utils;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import java.time.LocalDate;

public class Utility {

    public static Boolean isWeekend(LocalDate date) {
        if(date.getDayOfWeek().equals(SATURDAY) || date.getDayOfWeek().equals(SUNDAY))
            return true;
        else
            return false;
    }
}
