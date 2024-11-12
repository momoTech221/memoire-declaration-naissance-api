package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.MentionMapper;
import sn.uasz.declarationNaissance.modele.MentionDto;
import sn.uasz.declarationNaissance.service.impl.MentionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.MentionRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Mention;

import java.util.List;
@Data
@Service
public class MentionServiceImplService implements MentionService {
    @Autowired
    MentionRepository mentionRepository;

    @Autowired
    MentionMapper mentionMapper;

    @Override
    public String save(Mention mention) {
        MentionDto mentionDto = mentionMapper.mapMentionToMentionDto(mention);
        mentionRepository.save(mentionDto);
        return "Insertion reussie !!!";
    }

    @Override
    public List<Mention> list() {
        List<MentionDto> mentionDtos= mentionRepository.findAll();
        return mentionMapper.mapListMentionDtoToListMention(mentionDtos);
    }

    @Override
    public Mention search(Long id) {
        MentionDto mentionDto = mentionRepository.findById(id).get();
        return mentionMapper.mapMentionDtoToMention(mentionDto);
    }

    @Override
    public String update(Long id, Mention mention) {
        MentionDto mentionDto =mentionMapper.mapMentionToMentionDto(mention);
        MentionDto existe = mentionRepository.findById(id).get();
        if(existe != null) {
            if(mention.getApposition() != null) existe.setApposition(mentionDto.getApposition());
            if(mention.getLibele() != null) existe.setLibele(mentionDto.getLibele());

            mentionRepository.save(existe);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
        mentionRepository.deleteById(id);
        return "supression reussie !!!";
    }

}
