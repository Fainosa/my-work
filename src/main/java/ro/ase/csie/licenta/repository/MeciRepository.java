package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Competitie;
import ro.ase.csie.licenta.domain.Meci;

import java.util.List;

public interface MeciRepository extends JpaRepository<Meci, Long> {
    List<Meci> findByCompetitie(Competitie competitie);
}
