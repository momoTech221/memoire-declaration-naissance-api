package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.FormationSanitaireDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationSanitaireRepository extends JpaRepository<FormationSanitaireDto,Long> {
    @Query(value = "SELECT id_formation FROM formation_sanitaires c WHERE c.libele = ?1",nativeQuery = true)
    Long findByLibele(String libele);
}
