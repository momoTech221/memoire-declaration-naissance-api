package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.JugementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugementRepository extends JpaRepository<JugementDto,Long> {
    @Query(value = "SELECT id_jugement FROM jugements j WHERE j.numero = ?1",nativeQuery = true)
    Long findIdByNumero(String annnee);
}
