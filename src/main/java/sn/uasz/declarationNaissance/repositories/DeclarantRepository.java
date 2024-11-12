package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.DeclarantDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarantRepository extends JpaRepository<DeclarantDto,Long> {
    @Query(value = "SELECT id_declarant FROM declarants d WHERE d.numero_piece = ?1",nativeQuery = true)
    Long findIdByNumeroPiece(String numPiece);
}
