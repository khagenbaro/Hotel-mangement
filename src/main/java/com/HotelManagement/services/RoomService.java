package com.HotelManagement.services;

import com.HotelManagement.dto.*;
import com.HotelManagement.modal.Room;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface RoomService {
     String addRooms(RoomDTO roomDto);

     List<Room> getAllRooms();

     String deleteRoomById(long id);

     String updateRoom(long id, RoomDTO roomDTO);

}
