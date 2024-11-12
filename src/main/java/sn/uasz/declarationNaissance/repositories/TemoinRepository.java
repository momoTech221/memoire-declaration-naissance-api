package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.TemoinDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemoinRepository extends JpaRepository<TemoinDto,Long> {
    @Query(value = "SELECT id_temoin FROM temoins t WHERE t.numero_piece = ?1",nativeQuery = true)
    Long findIdByNumeroPiece(String numPiece);
    @Query(value = "SELECT * FROM temoins t WHERE t.numero_piece = ?1",nativeQuery = true)
    TemoinDto findByNumeroPiece(String numpiece);
}
