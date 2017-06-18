package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Meci;

public interface MeciRepository extends JpaRepository<Meci, Long> {
}
