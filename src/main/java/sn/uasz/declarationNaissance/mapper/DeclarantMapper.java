package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.DeclarantDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Declarant;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface DeclarantMapper {
    DeclarantDto mapDeclarantToDeclarantDto(Declarant declarant);
    Declarant mapDeclarantDtoToDeclarant(DeclarantDto declarantDto);
    List<Declarant> mapListDeclarantDtoToListDeclarant(List<DeclarantDto> declarantDtos);
}
