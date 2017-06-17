package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Jucator;

/**
 * Created by valkr on 6/17/2017.
 */
public interface JucatorRepository extends JpaRepository<Jucator, Long> {
}
