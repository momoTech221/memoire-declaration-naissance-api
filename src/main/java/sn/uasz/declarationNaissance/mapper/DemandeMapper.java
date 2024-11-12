package sn.uasz.declarationNaissance.mapper;

import org.mapstruct.Mapper;
import sn.uasz.declarationNaissance.modele.DeclareDto;
import sn.uasz.declarationNaissance.modele.DemandeDto;
import sn.uasz.spi.declarationNaissanceApi.model.Declare;
import sn.uasz.spi.declarationNaissanceApi.model.Demande;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface DemandeMapper {
    Demande mapDemandeDtoToDemande(DemandeDto demandeDto);
    DemandeDto mapDemandeToDemandeDto(Demande demande);
    List<Demande> mapListDemandeDtoToListDemande (List<DemandeDto> demandeDtos);
}
