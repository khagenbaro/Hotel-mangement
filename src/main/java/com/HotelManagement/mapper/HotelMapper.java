package com.HotelManagement.mapper;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.modal.Hotel;

public class HotelMapper {
    public HotelDTO entityToDTO(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setHotelId(hotel.getHotelId());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setRooms(hotel.getRooms());
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setState(hotel.getState());
        return  hotelDTO;
    }
    public Hotel entityToDTO(HotelDTO hotelDto){
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDto.getHotelId());
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setCity(hotelDto.getCity());
        hotel.setRooms(hotelDto.getRooms());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setState(hotelDto.getState());
        return  hotel;
    }
}
