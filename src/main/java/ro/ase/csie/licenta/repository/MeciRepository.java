package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Meci;

/**
 * Created by valkr on 6/17/2017.
 */
public interface MeciRepository extends JpaRepository<Meci, Long> {
}
