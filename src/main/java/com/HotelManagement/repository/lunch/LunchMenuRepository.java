package com.HotelManagement.repository.lunch;

import com.HotelManagement.modal.LunchMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchMenuRepository extends JpaRepository<LunchMenu, Long> {
}
