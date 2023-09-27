package com.HotelManagement.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId ;

    @Column(nullable = false)
    private int roomNumber;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private RoomType roomType;

    @Column(nullable = false)
    private boolean isAvailable;

}
