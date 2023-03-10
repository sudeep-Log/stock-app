package com.app.stockapp.repository;

import com.app.stockapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM User u WHERE u.username = :name",nativeQuery = true)
    User findByUsername(@Param("name") String name);


}
