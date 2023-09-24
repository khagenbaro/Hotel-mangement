package com.HotelManagement.services.impl;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.mapper.HotelMapper;
import com.HotelManagement.mapper.RoomMapper;
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

    @Autowired
    private RoomMapper roomMapper;
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
    public HotelDTO getHotelById(long id) {
       try{
           Optional<Hotel> hotel = hotelRepository.findById(id);
           return hotelMapper.entityToDTO(hotel.get());
       }
       catch (Exception ex){
           throw new RuntimeException(ex.getMessage());
       }
    }

    @Override
    public String addHotel(HotelDTO hotelDto) {
        try{
            Hotel hotel = hotelRepository.findByHotelName(hotelDto.getHotelName());
            List<Hotel> hotelList =  hotelRepository.findAll();
            String hotelName = hotelDto.getHotelName();
            boolean  containsHotel = false;
            if(hotel!=null){
                containsHotel= true;
            }
            if(containsHotel){
                // fetch all the rooms for the hotel
                // add room number to the hotel if it does not exist
                List<Room> roomList  = hotel.getRooms();
                List<Room>rooms = roomService.getRoomsListByHotelName(hotel.getHotelName());
                List<Integer> roomNumberList = new ArrayList<>();
                for(Room room:roomList){
                    roomNumberList.add(room.getRoomNumber());
                }
                for (Room room : hotel.getRooms()) {
                    // check if room number  already exist if not add the room to the hotel
                    if (!roomNumberList.contains(room.getRoomNumber())) {
                            hotel.getRooms().add(room);
                        }
                    // else return room already exists.
                    else{
                            return "Room Number Already Exists !";
                        }
                }
            }
            else{
                hotelRepository.save(hotel);
            }

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
