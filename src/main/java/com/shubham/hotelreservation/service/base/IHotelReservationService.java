package com.shubham.hotelreservation.service.base;

import com.shubham.hotelreservation.entity.base.IHotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHotelReservationService {

    void addHotel(IHotel hotel);
    void updateHotel(IHotel hotel);
    Optional<IHotel> findCheapestHotel(String customerType, List<LocalDate> dates);

}
