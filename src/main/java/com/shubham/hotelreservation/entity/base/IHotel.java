package com.shubham.hotelreservation.entity.base;

public interface IHotel {

    int getId();
    String getName();
    int getRatings();
    int getWeekdayRatesForRegularCustomer();
    int getWeekendRatesForRegularCustomer();
    int getWeekdayRatesForRewardCustomer();
    int getWeekendRatesForRewardCustomer();

}
