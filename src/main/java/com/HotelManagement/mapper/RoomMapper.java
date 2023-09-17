package com.HotelManagement.mapper;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.modal.Room;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public RoomDTO entityToDTO(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setHotelName(room.getHotelName());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setPrice(room.getPrice());
        return roomDTO;
    }
    public  Room dtoToEntity(RoomDTO roomDto){
        Room room = new Room();
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setHotelName(roomDto.getHotelName());
        room.setRoomType(roomDto.getRoomType());
        room.setPrice(roomDto.getPrice());
        return room;
    }
}
