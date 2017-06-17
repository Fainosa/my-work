package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Jucator;

import java.util.List;

public interface JucatorRepository extends JpaRepository<Jucator, Long> {
    List<Jucator> findByNume(String nume);
}
