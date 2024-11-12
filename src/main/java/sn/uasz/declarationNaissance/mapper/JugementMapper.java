package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.JugementDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Jugement;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface JugementMapper{

    Jugement mapJugementDtoToJugement(JugementDto jugementDto);

    JugementDto mapJugementToJugementDto(Jugement jugement);

    List<Jugement> mapListJugementDtoToListJugement(List<JugementDto> jugementDtos);
}
