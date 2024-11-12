package sn.uasz.declarationNaissance.mapper;

import sn.uasz.declarationNaissance.modele.MentionDto;
import org.mapstruct.Mapper;
import sn.uasz.spi.declarationNaissanceApi.model.Mention;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public interface MentionMapper {
    Mention mapMentionDtoToMention(MentionDto mentionDto);

    MentionDto mapMentionToMentionDto(Mention mention);

    List<Mention> mapListMentionDtoToListMention(List<MentionDto> mentionDtos);
}
