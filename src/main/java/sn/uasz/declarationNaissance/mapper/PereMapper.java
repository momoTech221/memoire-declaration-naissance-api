package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.PereDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Pere;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface PereMapper {

    Pere mapPereDtoToPere(PereDto pereDto);

    PereDto mapPereToPereDto(Pere pere);

    List<Pere> mapListPereDtoToListPere(List<PereDto> pereDtos);
}
