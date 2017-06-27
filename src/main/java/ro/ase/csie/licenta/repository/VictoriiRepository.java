package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Meci;
import ro.ase.csie.licenta.domain.Victorii;

import java.util.List;

public interface VictoriiRepository extends JpaRepository<Victorii, Long> {
    List<Victorii> findByEchipa(Echipa echipa);
}
