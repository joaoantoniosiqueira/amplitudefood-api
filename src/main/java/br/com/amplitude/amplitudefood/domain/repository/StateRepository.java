package br.com.amplitude.amplitudefood.domain.repository;

import br.com.amplitude.amplitudefood.domain.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
