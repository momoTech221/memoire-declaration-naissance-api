package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.MentionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.declarationNaissance.modele.TemoinDto;

@Repository
public interface MentionRepository extends JpaRepository<MentionDto,Long> {
//    @Query(value = "SELECT id_mention FROM mentions m WHERE m.numero_piece = ?1",nativeQuery = true)
//    Long findIdByNumeroPiece(String numPiece);
//    @Query(value = "SELECT * FROM mentions m WHERE m.numero_piece = ?1",nativeQuery = true)
//    MentionDto findByNumeroPiece(String numpiece);
}
