package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.MereDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MereRepository extends JpaRepository<MereDto,Long> {
    @Query(value = "SELECT id_mere FROM meres m WHERE m.numero_piece = ?1",nativeQuery = true)
    Long findIdByNumeroPiece(String numPiece);
}
