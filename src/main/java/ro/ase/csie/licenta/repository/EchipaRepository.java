package ro.ase.csie.licenta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Meci;

import java.util.List;

public interface EchipaRepository extends JpaRepository<Echipa, Long> {
    List<Echipa> findByMeci(Meci meci);
}