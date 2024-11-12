package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.DeclareDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Declare;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface DeclareMapper {
    Declare mapDeclareDtoToDeclare(DeclareDto declareDto);
    DeclareDto mapDeclareToDeclareDto(Declare declare);
    List<Declare> mapListDeclareDtoToListDeclare (List<DeclareDto> declareDtos);
}
