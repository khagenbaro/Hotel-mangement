package com.HotelManagement.services;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.mapper.RoomMapper;
import com.HotelManagement.modal.Room;
import com.HotelManagement.repository.RoomRepository;

public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private RoomMapper roomMapper;
    @Override
    public String addRooms(RoomDTO roomDTO) {
        Room room = roomMapper.dtoToEntity(roomDTO);
        roomRepository.save(room);
        return "Room added Successfully !!";
    }
}
