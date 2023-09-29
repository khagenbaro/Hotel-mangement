package com.HotelManagement.repository;

import com.HotelManagement.modal.BreakfastMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakfastMenuRepository extends JpaRepository<BreakfastMenu,Long> {
}
