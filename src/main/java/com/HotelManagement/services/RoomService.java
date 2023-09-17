package com.HotelManagement.services;

import com.HotelManagement.dto.*;
import com.HotelManagement.modal.Room;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface RoomService {
     String addRooms(RoomDTO roomDto);

     List<Room> getAllRooms();
}
