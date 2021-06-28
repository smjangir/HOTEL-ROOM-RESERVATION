package com.shubham.hotelreservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.shubham.hotelreservation.entity.Hotel;
import com.shubham.hotelreservation.entity.base.IHotel;
import com.shubham.hotelreservation.service.base.IHotelReservationService;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class HotelReservationApplicationTests {

	@Autowired
	public IHotelReservationService hotelReservationService;

	@Test
	@Order(1)
	void setup() {
		IHotel lakewoodHotel = Hotel.builder()
				.id(1)
				.name("Lakewood")
				.ratings(3)
				.weekdayRatesForRegularCustomer(110)
				.weekdayRatesForRewardCustomer(80)
				.weekendRatesForRegularCustomer(90)
				.weekendRatesForRewardCustomer(80)
				.build();

		IHotel bridgewoodHotel = Hotel.builder()
				.id(2)
				.name("Bridgewood")
				.ratings(4)
				.weekdayRatesForRegularCustomer(160)
				.weekdayRatesForRewardCustomer(110)
				.weekendRatesForRegularCustomer(60)
				.weekendRatesForRewardCustomer(50)
				.build();

		IHotel ridgewoodHotel = Hotel.builder()
				.id(3)
				.name("Ridgewood")
				.ratings(5)
				.weekdayRatesForRegularCustomer(200)
				.weekendRatesForRegularCustomer(100)
				.weekendRatesForRewardCustomer(150)
				.weekendRatesForRewardCustomer(40)
				.build();

		hotelReservationService.addHotel(lakewoodHotel);
		hotelReservationService.addHotel(bridgewoodHotel);
		hotelReservationService.addHotel(ridgewoodHotel);
	}

	@Test
	@Order(2)
	void test1(){
		assertEquals("Lakewood",
				hotelReservationService.findCheapestHotel("REGULAR",
					List.of(LocalDate.of(2009,3,16),
						LocalDate.of(2009,3,17),
						LocalDate.of(2009,3,18))).get().getName()
		);
	}

	@Test
	@Order(3)
	void test2(){
		assertEquals("Bridgewood",
				hotelReservationService.findCheapestHotel("REGULAR",
					List.of(LocalDate.of(2009,3,20),
						LocalDate.of(2009,3,21),
						LocalDate.of(2009,3,22))).get().getName()
		);
	}

	@Test
	@Order(4)
	void test3(){
		assertEquals("Ridgewood",
				hotelReservationService.findCheapestHotel("REWARD",
					List.of(LocalDate.of(2009,3,26),
						LocalDate.of(2009,3,27),
						LocalDate.of(2009,3,28))).get().getName()
		);
	}

}
