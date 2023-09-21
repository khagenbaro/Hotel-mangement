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

    private int roomNumber;

    private double price;

    private String hotelName;

    private RoomType roomType;

}
