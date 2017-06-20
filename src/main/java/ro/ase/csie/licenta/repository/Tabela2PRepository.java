package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Meci;
import ro.ase.csie.licenta.domain.Tabela2P;

import java.util.List;

public interface Tabela2PRepository extends JpaRepository<Tabela2P, Long> {
    List<Tabela2P> findByMeci(Meci meci);
}
