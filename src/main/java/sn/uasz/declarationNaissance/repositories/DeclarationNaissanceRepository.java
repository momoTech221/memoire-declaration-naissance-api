package sn.uasz.declarationNaissance.repositories;

import org.springframework.data.jpa.repository.Query;
import sn.uasz.declarationNaissance.modele.DeclarationNaissanceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationNaissanceRepository extends JpaRepository<DeclarationNaissanceDto,Long> {
    @Query(value = "SELECT id_declaration FROM declaration_naissances d WHERE d.numero = ?1",nativeQuery = true)
   Long verifDeclaration(String numero);
}
