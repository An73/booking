package com.hotel.booking.repos;

import com.hotel.booking.domain.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RoomRepo extends CrudRepository<Room, Long> {
    @Query(value = "SELECT * FROM Rooms " +
            "inner join booked on rooms.numb = booked.numb AND " +
            "((:check_in BETWEEN booked.check_in and booked.check_out) OR " +
            "(:check_out BETWEEN booked.check_in and booked.check_out) OR " +
            ":check_in <= booked.check_in and :check_out >= booked.check_out)",
            nativeQuery = true)
    List<Room> findC(@Param("check_in") Date check_in, @Param("check_out") Date check_out);

    List<Room> findByCategory(String category);
    List<Room> findByCategoryAndPriceLessThanEqual(String category, Integer price);

    @Query(value = "SELECT PRICE FROM Rooms where numb = :numb",
    nativeQuery = true)
    int findPriceByNumb(@Param("numb") Integer number);
}

/*public interface RoomRepo extends CrudRepository<RoomPrice, Long> {
    @Query(value = "SELECT * FROM Rooms " +
            "inner join booked on  rooms.numb != booked.numb or " +
            "((booked.check_out <= :check_in or booked.check_in > :check_in) where",
            nativeQuery = true)
    public List<RoomPrice> findC(@Param("check_in") Date check_in, @Param("check_out") Date check_out);
}*/
