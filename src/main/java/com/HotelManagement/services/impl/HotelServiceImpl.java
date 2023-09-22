package com.HotelManagement.services.impl;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.mapper.HotelMapper;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.modal.Room;
import com.HotelManagement.repository.HotelRepository;
import com.HotelManagement.repository.RoomRepository;
import com.HotelManagement.services.HotelService;
import com.HotelManagement.services.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<HotelDTO> getAllHotels() {
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        List<Hotel>  hotelList = hotelRepository.findAll();
        /*
        * Convert each hotel to dto and return the list finally*/
        for(Hotel hotel:hotelList){
            HotelDTO hotelDTO = hotelMapper.entityToDTO(hotel);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
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
        /*Todo
        *  Need to add a logic to check if the room number is already exists
        *  if exists throw some exception or message
        * */
        try{
            Hotel hotel = hotelMapper.dtoToEntity(hotelDto);
            List<Hotel> hotelList =  hotelRepository.findAll();
//            for(Hotel hot:hotelList){
//                if(hot.getHotelName().equals(hotel.getHotelName())){
//                    for(Room room:hot.getRooms()){
//                        if(room.getRoomNumber()==hotel.getRooms().)
//                    }
//                }
//            }
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
            Hotel hotel = hotelRepository.findById(id).get();
            if(hotel!=null){
                /*find all the rooms and delete and delete each room from the repo
                * as well as delete the hotel*/
               List<Room> roomList = roomService.getRoomsListByHotelName(hotel.getHotelName());
               for(Room room :roomList){
                   roomRepository.delete(room);
               }
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
