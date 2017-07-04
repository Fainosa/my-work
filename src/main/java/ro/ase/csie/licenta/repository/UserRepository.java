package ro.ase.csie.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Jucator;
import ro.ase.csie.licenta.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
