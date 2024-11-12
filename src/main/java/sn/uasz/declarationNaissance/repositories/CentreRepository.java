package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.CentreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<CentreDto,Long> {
    @Query(value = "SELECT id_centre FROM centres c WHERE c.libele = ?1",nativeQuery = true)
    Long findByLibele(String libele);
}
