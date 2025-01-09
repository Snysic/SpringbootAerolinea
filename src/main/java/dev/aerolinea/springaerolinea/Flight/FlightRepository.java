package dev.aerolinea.springaerolinea.Flight;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAndDestinationAndDepartureTimeAfter(String departure, String destination, LocalDateTime dateTime);
}
