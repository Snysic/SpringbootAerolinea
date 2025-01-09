package dev.aerolinea.springaerolinea.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String departure, String destination, LocalDateTime dateTime);
}
