package com.HotelManagement.repository;

import com.HotelManagement.modal.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation ,Long> {
}
