package com.HotelManagement.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LunchMenu")
public class LunchMenu {
    private Long lunchMenId;
    private String name;
    private String description;
    private List<LunchItem> items;
}
