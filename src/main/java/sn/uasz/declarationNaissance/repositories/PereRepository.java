package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.PereDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PereRepository extends JpaRepository<PereDto,Long> {
    @Query(value = "SELECT id_pere FROM peres p WHERE p.numero_piece = ?1",nativeQuery = true)
    Long findIdByNumeroPiece(String numPiece);
}
