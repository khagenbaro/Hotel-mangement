package com.HotelManagement.services.impl;

import com.HotelManagement.dto.ReservationDTO;
import com.HotelManagement.mapper.ReservationMapper;
import com.HotelManagement.modal.Reservation;
import com.HotelManagement.repository.ReservationRepository;
import com.HotelManagement.services.ReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;
    @Override
    public List<Reservation> getReservationList() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        try{
            Optional<Reservation> reservation = reservationRepository.findById(id);
            return  reservation;
        }
        catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public String reserveARoom(ReservationDTO reservationDTO) {
        try{
            Reservation reservation = reservationMapper.dtoToEntity(reservationDTO);
            reservationRepository.save(reservation);
            return "Reservation is Successful !!";
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deleteReservationById(long id) {
        try{
            Optional<Reservation> hotel = reservationRepository.findById(id);
            if(!hotel.isEmpty()){
                reservationRepository.deleteById(id);
                return "Reservation is removed Successfully";
            }
                return "Reservation can not be removed";
        }
        catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
