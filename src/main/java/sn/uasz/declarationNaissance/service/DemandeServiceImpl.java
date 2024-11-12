package sn.uasz.declarationNaissance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.mapper.DemandeMapper;
import sn.uasz.declarationNaissance.modele.DemandeDto;
import sn.uasz.declarationNaissance.repositories.DemandeRepository;
import sn.uasz.declarationNaissance.service.impl.DemandeService;
import sn.uasz.spi.declarationNaissanceApi.model.Demande;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DemandeServiceImpl implements DemandeService {
    @Autowired
    DemandeRepository repository;
    @Autowired
    DemandeMapper mapper;

    @Override
    public String save(Demande demande) {
        DemandeDto demandeDto= mapper.mapDemandeToDemandeDto(demande);
        demandeDto.setDateDemande(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss")));
        repository.save(demandeDto);
        return "Insertion reussie !!!";
    }

    @Override
    public List<Demande> list() {
        List<DemandeDto> list = repository.findAll();
        return mapper.mapListDemandeDtoToListDemande(list);
    }

    @Override
    public Demande search(Long id) {
        DemandeDto demandeDto = repository.findById(id).get();
        return mapper.mapDemandeDtoToDemande(demandeDto);
    }

    @Override
    public String update(Long id, Demande demande) {
        DemandeDto dto = mapper.mapDemandeToDemandeDto(demande);
        DemandeDto existe = repository.findById(id).get();
        if(existe != null){

        }
        return null;
    }

    @Override
    public String remove(Long id) {
        repository.deleteById(id);
        return "supression reussie !!!";
    }
}
