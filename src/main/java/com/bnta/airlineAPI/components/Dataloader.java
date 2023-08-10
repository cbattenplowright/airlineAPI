package com.bnta.airlineAPI.components;

import com.bnta.airlineAPI.repositories.FlightRepository;
import com.bnta.airlineAPI.repositories.PassengerRepository;
import com.bnta.airlineAPI.models.Passenger;
import com.bnta.airlineAPI.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

            List<Passenger> passengers = new ArrayList<>();
            passengers.add(new Passenger("Frank Smith", "07987654322"));
            passengers.add(new Passenger("Olivia Jones", "07777777779"));
            passengers.add(new Passenger("Oliver Brown", "07333333335"));
            passengers.add(new Passenger("Amelia Williams", "07555555557"));
            passengers.add(new Passenger("Benjamin Johnson", "07123456791"));

            passengers.add(new Passenger("Clara Davis", "07987654323"));
            passengers.add(new Passenger("David Miller", "07777777780"));
            passengers.add(new Passenger("Eva Anderson", "07333333336"));
            passengers.add(new Passenger("Harry Carter", "07555555558"));
            passengers.add(new Passenger("Isabella Thomas", "07123456792"));

            passengers.add(new Passenger("James Green", "07987654324"));
            passengers.add(new Passenger("Katherine Peterson", "07777777781"));
            passengers.add(new Passenger("Leo Collins", "07333333337"));
            passengers.add(new Passenger("Maya Jackson", "07555555559"));
            passengers.add(new Passenger("Noah Williams", "07123456793"));
            passengerRepository.saveAll(passengers);

            List<Flight> flights = new ArrayList<>();
            flights.add(new Flight("New York", 177, "2023-03-08", "10:00"));
            flights.add(new Flight("London", 251, "2023-03-10", "12:00"));
            flights.add(new Flight("Los Angeles", 297, "2023-03-15", "10:00"));
            flights.add(new Flight("Paris", 228, "2023-03-17", "12:00"));
            flights.add(new Flight("Sydney", 353, "2023-03-19", "14:00"));
            flights.add(new Flight("Tokyo", 196, "2023-03-22", "10:00"));
            flights.add(new Flight("Dubai", 336, "2023-03-24", "12:00"));
            flights.add(new Flight("Rome", 183, "2023-03-26", "14:00"));
            flights.add(new Flight("Berlin", 277, "2023-03-28", "16:00"));
            flights.add(new Flight("Mexico City", 237, "2023-03-27", "12:07"));
            flightRepository.saveAll(flights);

        }
    }

}
