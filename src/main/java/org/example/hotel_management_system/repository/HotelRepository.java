package org.example.hotel_management_system.repository;

import org.example.hotel_management_system.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByOwnerId(Integer ownerId);
}
