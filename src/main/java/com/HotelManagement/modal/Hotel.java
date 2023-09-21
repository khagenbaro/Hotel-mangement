package com.HotelManagement.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="Hotel")
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", nullable = false)
    private Address address;

    @OneToMany( cascade = CascadeType.ALL)
    @Column (name="roomId",nullable = false)
    private List<Room> rooms;
}
