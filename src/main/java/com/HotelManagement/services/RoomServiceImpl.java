package com.HotelManagement.services;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.mapper.RoomMapper;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.modal.Room;
import com.HotelManagement.repository.HotelRepository;
import com.HotelManagement.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper, RoomRepository roomRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }
    @Override

    public String addRooms(RoomDTO roomDTO) {
        try{
            Room room = roomMapper.dtoToEntity(roomDTO);
            List<Hotel> hotelList=  hotelRepository.findAll();
            boolean containsHotel = hotelList.stream().anyMatch(
                    hotel -> hotel.getHotelName().equals(room.getHotelName()));
            if(containsHotel){
                roomRepository.save(room);
                return "Room added Successfully !!";
            }
            else{
                return "Hotel does not exists";
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public String deleteRoomById(long id) {
        try{
            Optional<Room> room = roomRepository.findById(id);
            if(!room.isEmpty()){
                roomRepository.deleteById(id);
                return "Room has been deleted Successfully";
            }
            else{
                return "Room can not be deleted";
            }
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateRoom(long id, RoomDTO roomDTO) {
        try{
            Optional<Room> room = roomRepository.findById(id);
            Room roomObj = roomMapper.dtoToEntity(roomDTO);
            roomObj.setRoomNumber(roomDTO.getRoomNumber());
            roomObj.setRoomType(roomDTO.getRoomType());
            roomObj.setPrice(roomDTO.getPrice());
            //logic to check whether hotel exists
            List<Hotel> hotelList = hotelRepository.findAll();
            boolean containsHotel = hotelList.stream().anyMatch(
                    hotel -> hotel.getHotelName().equals(roomDTO.getHotelName()));
            if(containsHotel){
                roomRepository.save(roomObj);
                return "Room updated Successfully !!";
            }
            else{
                return "Hotel does not exists ! Room can not be updated";
            }        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
