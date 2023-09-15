package com.HotelManagement.repository;

import com.HotelManagement.modal.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Room,Long> {
}
