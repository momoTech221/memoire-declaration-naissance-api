package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.RegistreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistreRepository extends JpaRepository<RegistreDto,Long> {
    @Query(value = "SELECT id_registre FROM registres r WHERE r.annee = ?1",nativeQuery = true)
    Long findByAnnee(String annnee);
}
