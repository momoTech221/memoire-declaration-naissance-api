package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.DeclarationNaissanceDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.DeclarationNaissance;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface DeclarationNaissanceMapper {
    DeclarationNaissance mapDeclarationNaissanceDtoToDeclarationNaissance(DeclarationNaissanceDto declarationNaissanceDto);

    DeclarationNaissanceDto mapDeclarationNaissanceToDeclarationNaissanceDto(DeclarationNaissance declarationNaissanceDto );

    List<DeclarationNaissance> mapListDeclaDtoToListDecla(List<DeclarationNaissanceDto> declarationNaissanceDto);


//    DeclarationNaissance mapOptDeclarationNaissanceDtoToDeclarationNaissance(Optional<DeclarationNaissanceDto > declarationNaissanceDto);

}
