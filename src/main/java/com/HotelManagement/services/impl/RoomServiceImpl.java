package com.HotelManagement.services.impl;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.mapper.RoomMapper;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.modal.Room;
import com.HotelManagement.repository.HotelRepository;
import com.HotelManagement.repository.RoomRepository;
import com.HotelManagement.services.RoomService;
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
                /* Add this room to the hotel repository */
                Hotel hotel = hotelRepository.findByHotelName(room.getHotelName());
                // add the room to the hotel repo
                hotel.getRooms().add(room);
                // add the room to the room repo
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
    public RoomDTO getRoomById(long id) {
        try{
            Optional<Room> room = roomRepository.findById(id);
            if(room.isPresent()){
                // map dto to room dto and return
                return roomMapper.entityToDTO(room.get());
            }
            else{
                throw  new RuntimeException("Not valid id");
            }
        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Room> getRoomsListByHotelName(String hotelName) {
        List<Room> rooms =roomRepository.findAllByHotelName(hotelName);
        return rooms;
    }

    @Override
    public String deleteRoomById(long id) {
        try{
            Optional<Room> optionalRoom = roomRepository.findById(id);
            // convert optional room to type Room
            Room room = optionalRoom.orElse(new Room());
            if(optionalRoom.isPresent()){
                // logic to delete the room from the hotel repo as well as from the room repo
                Hotel hotel = hotelRepository.findByHotelName(optionalRoom.get().getHotelName());
                // remove from hotel repo
                hotel.getRooms().remove(room);
                //remove from the room repo
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
            if(room.isPresent()){
                Room roomObj = room.get();
                roomObj.setRoomNumber(roomDTO.getRoomNumber());
                roomObj.setRoomType(roomDTO.getRoomType());
                roomObj.setPrice(roomDTO.getPrice());
                //logic to check whether hotel exists
                // todo update the room of the hotel
                List<Hotel> hotelList = hotelRepository.findAll();
                Hotel hotelOptional = hotelRepository.findByHotelName(roomDTO.getHotelName());
                if(hotelOptional!=null){
                    roomObj.setHotelName(hotelOptional.getHotelName());
                    // update the room in the hotel repo
                    roomRepository.save(roomObj);
                    // update the room in the room repo
                    hotelRepository.save(hotelOptional);
                    return "Room updated Successfully !!";
                }
                else{
                    return "Hotel does not exists !!";
                }

            }
            else{
                return "Id is not Valid !! Room can not be updated";
            }
        }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
