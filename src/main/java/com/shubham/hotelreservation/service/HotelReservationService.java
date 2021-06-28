package com.shubham.hotelreservation.service;

import com.shubham.hotelreservation.entity.CustomerType;
import static com.shubham.hotelreservation.entity.CustomerType.REGULAR;
import static com.shubham.hotelreservation.entity.CustomerType.REWARD;

import com.shubham.hotelreservation.entity.Hotel;
import com.shubham.hotelreservation.entity.base.IHotel;
import com.shubham.hotelreservation.service.base.IHotelReservationService;
import com.shubham.hotelreservation.utils.Utility;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@NoArgsConstructor
public class HotelReservationService implements IHotelReservationService {

    private final Set<IHotel> hotels = new HashSet<>();

    public void addHotel(IHotel hotel) {
        hotels.add(hotel);
    }

    public void updateHotel(IHotel hotel){
        hotels.remove(hotel);
        hotels.add(hotel);
    }

    public Optional<IHotel> findCheapestHotel(String customerType, List<LocalDate> dates) {
        CustomerType type = CustomerType.valueOf(customerType);
        IHotel result = null;
        int minimumRates = Integer.MAX_VALUE;
        for (IHotel hotel: hotels) {
            int rates = getRates(dates, type, hotel);
            if(rates < minimumRates) {
                minimumRates = rates;
                result = hotel;
            } else if(rates == minimumRates) {
                result = hotel.getRatings() > result.getRatings()? hotel: result;
            }
        }

        return Optional.ofNullable(result);
    }

    private int getRates(List<LocalDate> dates, CustomerType type, IHotel hotel) {
        return dates.stream().mapToInt(date -> {
            final Boolean isWeekend = Utility.isWeekend(date);

            if (type.equals(REGULAR) && isWeekend) {
                return hotel.getWeekendRatesForRegularCustomer();
            } else if (type.equals(REWARD) && isWeekend) {
                return hotel.getWeekendRatesForRewardCustomer();
            } else if (type.equals(REGULAR)) {
                return hotel.getWeekdayRatesForRegularCustomer();
            } else {
                return hotel.getWeekdayRatesForRewardCustomer();
            }
        }).sum();
    }

}