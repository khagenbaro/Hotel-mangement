package com.HotelManagement.services;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.mapper.HotelMapper;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelMapper hotelMapper;
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotelById(long id) {
       try{
           Optional<Hotel> hotel = hotelRepository.findById(id);
           return hotel;
       }
       catch (Exception ex){
           throw new RuntimeException(ex.getMessage());
       }
    }

    @Override
    public String addHotel(HotelDTO hotelDto) {
        try{
            Hotel hotel = hotelMapper.dtoToEntity(hotelDto);
            hotelRepository.save(hotel);
            return "Hotel added Successfully !!";
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deleteHotel(long id) {
        try{
            Optional<Hotel> hotel = hotelRepository.findById(id);
            if(!hotel.isEmpty()){
                hotelRepository.deleteById(id);
                return "Hotel has been deleted Successfully ";
            }
            return "Hotel can not be deleted ";
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
