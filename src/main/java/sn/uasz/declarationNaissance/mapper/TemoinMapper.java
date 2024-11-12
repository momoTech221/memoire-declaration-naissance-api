package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.TemoinDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Temoin;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface TemoinMapper {

    Temoin mapTemoinDtoToTemoin(TemoinDto temoinDto);

    TemoinDto mapTemoinToTemoinDto(Temoin temoin);

    List<Temoin> mapListTemoinDtoToListTemoin(List<TemoinDto> temoinDtos);
}
