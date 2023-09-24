package com.HotelManagement.services;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.modal.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HotelService {
    List<HotelDTO> getAllHotels();
    Optional<Hotel> getHotelById(long id);
    String addHotel(HotelDTO hotelDto);
    String deleteHotel(long id);

}
