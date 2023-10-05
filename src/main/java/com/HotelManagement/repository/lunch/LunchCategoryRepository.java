package com.HotelManagement.repository.lunch;

import com.HotelManagement.modal.LunchCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchCategoryRepository extends JpaRepository<LunchCategory, Long> {
}
