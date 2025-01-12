package dev.aerolinea.springaerolinea.countries;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
