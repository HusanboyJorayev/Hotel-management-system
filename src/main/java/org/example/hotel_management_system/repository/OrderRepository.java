package org.example.hotel_management_system.repository;

import org.example.hotel_management_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query(value = "delete from orders where user_id=?1", nativeQuery = true)
    void deleteByUserId(Integer userId);
}
