package sn.uasz.declarationNaissance.repositories;

import sn.uasz.declarationNaissance.modele.DeclareDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclareRepository extends JpaRepository<DeclareDto,Long> {
}
