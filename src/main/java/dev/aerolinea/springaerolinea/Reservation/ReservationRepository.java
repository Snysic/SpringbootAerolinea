package dev.aerolinea.springaerolinea.Reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aerolinea.springaerolinea.Flight.Flight;
import dev.aerolinea.springaerolinea.User.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByFlight(Flight flight);
}
