package com.HotelManagement.mapper;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.modal.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {
    public HotelDTO entityToDTO(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setRooms(mapRoomsToDTo(hotel.getRooms()));
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setState(hotel.getState());
        return  hotelDTO;
    }
    public Hotel dtoToEntity(HotelDTO hotelDto){
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setCity(hotelDto.getCity());
        hotel.setRooms(mapDtoRooms(hotelDto.getRooms()));
        hotel.setAddress(hotelDto.getAddress());
        hotel.setState(hotelDto.getState());
        return  hotel;
    }
    private List<RoomDTO> mapRoomsToDTo(List<Room> rooms) {
        return rooms.stream()
                .map(room -> {
                    RoomDTO roomDTO = new RoomDTO();
                    roomDTO.setRoomNumber(room.getRoomNumber());
                    roomDTO.setPrice(room.getPrice());
                    roomDTO.setRoomType(room.getRoomType());
                    roomDTO.setHotelName(room.getHotelName());
                    roomDTO.setAvailable(room.isAvailable());
                    return roomDTO;
                })
                .collect(Collectors.toList());
    }
    private List<Room> mapDtoRooms(List<RoomDTO> roomDTO) {
        return roomDTO.stream()
                .map(room -> {
                    Room roomObj= new Room();
                    roomObj.setRoomNumber(room.getRoomNumber());
                    roomObj.setPrice(room.getPrice());
                    roomObj.setRoomType(room.getRoomType());
                    roomObj.setHotelName(room.getHotelName());
                    roomObj.setAvailable(room.isAvailable());
                    return roomObj;
                })
                .collect(Collectors.toList());
    }
}