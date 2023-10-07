package com.HotelManagement.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LunchCategory")
public class LunchCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "lunchCategory", cascade = CascadeType.ALL)
    private List<LunchItem> lunchItemList;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private LunchMenu lunchMenu;


}
