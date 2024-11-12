package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.MereMapper;
import sn.uasz.declarationNaissance.modele.MereDto;
import sn.uasz.declarationNaissance.service.impl.MereService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.MereRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Mere;

import java.util.List;

@Data
@Service
public class MereServiceImplService implements MereService {
    @Autowired
    MereRepository mereRepository;

    @Autowired
    MereMapper mereMapper;

    @Override
    public String save(Mere mere) {
        String  s = "";
        if(mereRepository.findIdByNumeroPiece(mere.getNumeroPiece())==null){
            MereDto dto = mereMapper.mapMereToMereDto(mere);
            mereRepository.save(dto);
            s="Insertion reussie !!!";
        }
        else{
            s="Informations deja existantes !!!";
        }
        return s;
    }

    @Override
    public List<Mere> list() {
        List<MereDto> mereDtos = mereRepository.findAll();
        return mereMapper.mapListMereDtoToListMere(mereDtos);
    }

    @Override
    public Mere search(Long id) {
        MereDto mereDto = mereRepository.findById(id).get();
        return mereMapper.mapMereDtoToMere(mereDto);
    }

    @Override
    public String update(Long id, Mere mere) {
        MereDto mereDto = mereMapper.mapMereToMereDto(mere);
        MereDto mum = mereRepository.findById(id).get();

        if(mum != null) {
            if(mere.getNom() != null) mum.setNom(mereDto.getNom());
            if(mere.getPrenom() != null) mum.setPrenom(mereDto.getPrenom());
            if(mere.getProfession() != null) mum.setProfession(mereDto.getProfession());
            if(mere.getAdresse() != null) mum.setAdresse(mereDto.getAdresse());
            if(mere.getTypePiece() != null) mum.setTypePiece(mereDto.getTypePiece());
            if(mere.getNumeroPiece() != null) mum.setNumeroPiece(mereDto.getNumeroPiece());
            if(mere.getDateNaiss() != null) mum.setDateNaiss(mereDto.getDateNaiss());
            if(mere.getLieuNaiss() != null) mum.setLieuNaiss(mereDto.getLieuNaiss());

            mereRepository.save(mum);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
        mereRepository.deleteById(id);
        return "supression reussie !!!";
    }

}
