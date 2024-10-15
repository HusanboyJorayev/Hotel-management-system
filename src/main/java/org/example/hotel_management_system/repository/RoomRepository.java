package org.example.hotel_management_system.repository;

import org.example.hotel_management_system.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from room where id in (select rooms_id from hotel_rooms where hotel_id=?1)", nativeQuery = true)
    void deleteRoomByHotelId(Integer hotelId);

    @Query(value = "select * from room as r where r.status='ACTIVE' and r.state='EMPTY' and r.id=?1", nativeQuery = true)
    Optional<Room> findActiveEmptyRoomById(Integer id);
}
