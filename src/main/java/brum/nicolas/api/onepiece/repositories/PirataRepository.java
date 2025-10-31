package brum.nicolas.api.onepiece.repositories;

import brum.nicolas.api.onepiece.entities.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PirataRepository extends JpaRepository<Pirata, Long> {
}
