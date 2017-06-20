package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Meci;
import ro.ase.csie.licenta.domain.Tabela1P;

import java.util.List;

public interface Tabela1PRepository extends JpaRepository<Tabela1P, Long> {
    List<Tabela1P> findByMeci(Meci meci);
}
