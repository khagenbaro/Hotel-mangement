package com.HotelManagement.services;

import com.HotelManagement.dto.*;
import com.HotelManagement.modal.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface RoomService {
     String addRooms(RoomDTO roomDto);

     List<RoomDTO> getAllRooms();

     RoomDTO getRoomById(long id);

     List<Room> getRoomsListByHotelName(String hotelName);

     String deleteRoomById(long id);

     String updateRoom(long id, RoomDTO roomDTO);


}
