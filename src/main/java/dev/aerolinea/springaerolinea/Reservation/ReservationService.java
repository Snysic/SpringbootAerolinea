package dev.aerolinea.springaerolinea.Reservation;

import dev.aerolinea.springaerolinea.Flight.Flight;
import dev.aerolinea.springaerolinea.User.User;

public interface ReservationService {
    Reservation bookFlight(User user, Flight flight, int seats);
}

