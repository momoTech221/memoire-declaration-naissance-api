package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.declarationNaissance.modele.DemandeDto;

@Repository
public interface DemandeRepository extends JpaRepository<DemandeDto,Long> {
}
