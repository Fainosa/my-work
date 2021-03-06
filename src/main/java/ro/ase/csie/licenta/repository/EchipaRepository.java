package ro.ase.csie.licenta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Antrenor;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Jucator;
import ro.ase.csie.licenta.domain.Meci;

import java.util.List;

public interface EchipaRepository extends JpaRepository<Echipa, Long> {
    List<Echipa> findByMeci(Meci meci);
    List<Echipa> findByNumeEchipa( String nume);
    List<Echipa> findByJucatori (Jucator jucator);
    List<Echipa> findByAntrenori(Antrenor antrenor);


}