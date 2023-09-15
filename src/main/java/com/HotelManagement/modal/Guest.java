package com.HotelManagement.modal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id",nullable = false)
    private ContactInfo contactInfo;


    @Column(nullable = false)
    private Gender gender;

}
