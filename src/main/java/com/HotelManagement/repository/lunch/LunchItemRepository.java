package com.HotelManagement.repository.lunch;

import com.HotelManagement.modal.LunchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchItemRepository extends JpaRepository<LunchItem, Long> {
}
