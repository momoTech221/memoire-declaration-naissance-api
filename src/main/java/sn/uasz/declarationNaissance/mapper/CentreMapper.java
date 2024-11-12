package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.CentreDto;
import org.mapstruct.Mapper;
import sn.uasz.declarationNaissance.modele.DeclarationNaissanceDto;
import sn.uasz.spi.declarationNaissanceApi.model.Centre;
import sn.uasz.spi.declarationNaissanceApi.model.DeclarationNaissance;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface CentreMapper {
    //Pour faire le mapping entre nom d'attribut Dto rt spi

    //CentreMapper s = Mappers.getMapper(CentreMapper.class);

    //pour faire la correspondance entre le jpa et le Dto
    //@Mapping(target="code", source="code")




    CentreDto mapperCentreToCentreDto(Centre centre);
    Centre mapperCentreDtoToCentre(CentreDto centre);

    List<Centre> mapListCentreDtoToListCentre(List<CentreDto> centreDtos);

    //List<DeclarationNaissanceDto>  map(List<DeclarationNaissance>  centreDtos);
}
