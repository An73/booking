package com.hotel.booking.repos;

import com.hotel.booking.domain.Booked;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface BookedRepo extends CrudRepository<Booked, Long> {
    @Modifying
    @Query(value = "INSERT INTO Booked(NUMB, CHECK_IN, CHECK_OUT, ADDITION_OPTION, USER) " +
            "VALUES (:numb, :check_in, :check_out, :addition_option, :user)",
            nativeQuery = true)
    @Transactional
    void insertBooked(@Param("numb") Integer numb,
                      @Param("check_in") Date check_in,
                      @Param("check_out") Date check_out,
                      @Param("addition_option") String addition_option,
                      @Param("totalprice") Integer totalprice,
                      @Param("user") String user);
}
