package br.com.amplitude.amplitudefood.domain.repository;

import br.com.amplitude.amplitudefood.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
