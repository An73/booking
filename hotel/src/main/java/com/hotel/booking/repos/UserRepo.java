package com.hotel.booking.repos;

import com.hotel.booking.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepo extends CrudRepository<User, Long> {
    @Modifying
    @Query(value = "INSERT INTO Users(FIRST_NAME, LAST_NAME, NICKNAME) VALUES (:first_name, :last_name, :nickname)",
    nativeQuery = true)
    @Transactional
    void insertUser(@Param("first_name") String first_name,
                    @Param("last_name") String last_name,
                    @Param("nickname") String nickname);

    User findByNickname(String nickname);
}
