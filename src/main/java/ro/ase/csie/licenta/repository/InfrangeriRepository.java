package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Meci;
import ro.ase.csie.licenta.domain.Infrangeri;

import java.util.List;

public interface InfrangeriRepository extends JpaRepository<Infrangeri, Long> {
    List<Infrangeri> findByEchipa( Echipa echipa);
}
