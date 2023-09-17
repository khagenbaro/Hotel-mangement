package com.HotelManagement.services;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.mapper.RoomMapper;
import com.HotelManagement.modal.Room;
import com.HotelManagement.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private RoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper, RoomRepository roomRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }
    @Override

    public String addRooms(RoomDTO roomDTO) {
        Room room = roomMapper.dtoToEntity(roomDTO);
        roomRepository.save(room);
        return "Room added Successfully !!";
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
