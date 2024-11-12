package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.RegistreDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Registre;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface RegistreMapper {
    Registre mapRegistreDtoToRegistre(RegistreDto registreDto);

    RegistreDto mapRegistreToRegistreDto(Registre registre);

    List<Registre> mapListRegistreDtoToListRegistre(List<RegistreDto> registreDtos);
}
