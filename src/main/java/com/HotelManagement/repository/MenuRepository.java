package com.HotelManagement.repository;

import com.HotelManagement.modal.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem,Long> {
}
