package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.MereDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Mere;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface MereMapper {
    Mere mapMereDtoToMere(MereDto mereDto);

    MereDto mapMereToMereDto(Mere mere);

    List<Mere> mapListMereDtoToListMere(List<MereDto> mereDtos);
}
