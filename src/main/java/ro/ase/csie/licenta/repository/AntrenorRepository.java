package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Antrenor;
import ro.ase.csie.licenta.domain.Jucator;

import java.util.List;

public interface AntrenorRepository extends JpaRepository<Antrenor, Long> {
    List<Antrenor> findByNume(String nume);
}
