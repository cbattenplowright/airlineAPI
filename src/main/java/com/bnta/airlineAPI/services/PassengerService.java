package com.bnta.airlineAPI.services;

import com.bnta.airlineAPI.models.Flight;
import com.bnta.airlineAPI.models.FlightDTO;
import com.bnta.airlineAPI.models.Passenger;
import com.bnta.airlineAPI.models.PassengerDTO;
import com.bnta.airlineAPI.repositories.FlightRepository;
import com.bnta.airlineAPI.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }

    public Passenger addPassenger(PassengerDTO passengerDTO){
        Passenger newPassenger = new Passenger(
                passengerDTO.getName(),
                passengerDTO.getPhoneNumber());
        return passengerRepository.save(newPassenger);
    }

    public Passenger addFlightToPassenger(PassengerDTO passengerDTO, Long passengerId){
        Passenger passengerToUpdate = passengerRepository.findById(passengerId).get();
        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passengerToUpdate.addFlightToPassenger(flight);
        }
        return passengerToUpdate;
    }

}
