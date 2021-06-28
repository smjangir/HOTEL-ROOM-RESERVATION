package com.shubham.hotelreservation.entity;

import com.shubham.hotelreservation.entity.base.IHotel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements IHotel {

    @EqualsAndHashCode.Include @NonNull private final int id;
    @NonNull private final String name;
    @NonNull private final int ratings;
    @NonNull private final int weekdayRatesForRegularCustomer;
    @NonNull private final int weekendRatesForRegularCustomer;
    @NonNull private final int weekdayRatesForRewardCustomer;
    @NonNull private final int weekendRatesForRewardCustomer;

}
