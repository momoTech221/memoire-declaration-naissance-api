package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.FormationSanitaireDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.FormationSanitaire;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface FormationSanitaireMapper {

    FormationSanitaire mapFormationSanitaireDtoToFormationSanitaire(FormationSanitaireDto formationSanitaireDto);

    FormationSanitaireDto mapFormationSanitaireToFormationSanitaireDto(FormationSanitaire formationSanitaire);

    List<FormationSanitaire> mapListFormationSanitaireDtoToListFormationSanitaire(List<FormationSanitaireDto> formationSanitaireDtos);
}
