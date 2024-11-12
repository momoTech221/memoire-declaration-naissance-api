package sn.uasz.declarationNaissance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.mapper.*;
import sn.uasz.declarationNaissance.modele.*;
import sn.uasz.declarationNaissance.repositories.*;
import sn.uasz.declarationNaissance.service.impl.DeclarationNaissanceService;
import sn.uasz.spi.declarationNaissanceApi.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class DeclarationNaissanceServiceImplService implements DeclarationNaissanceService {
    @Autowired
    DeclarationNaissanceRepository repository;
    @Autowired
    RegistreRepository registreRepository;
    @Autowired
    RegistreServiceImplService registreService;
    @Autowired
    RegistreMapper registreMapper;
    @Autowired
    CentreRepository centreRepository;
    @Autowired
    CentreServiceImplService centreService;
    @Autowired
    CentreMapper centreMapper;
    @Autowired
    FormationSanitaireRepository sanitaireRepository;
    @Autowired
    FormationSanitaireImplService sanitaireService ;
    @Autowired
    FormationSanitaireMapper sanitaireMapper;
    @Autowired
    MereRepository mereRepository;
    @Autowired
    MereServiceImplService mereService;
    @Autowired
    MereMapper mereMapper;
    @Autowired
    PereRepository pereRepository;
    @Autowired
    PereServiceImplService pereService;
    @Autowired
    PereMapper pereMapper;
    @Autowired
    DeclarantRepository declarantRepository;
    @Autowired
    DeclarantServiceImplService declarantService;
    @Autowired
    DeclarantMapper declarantMapper;
    @Autowired
    DeclareRepository declareRepository;
    @Autowired
    DeclareServiceImplService declareService;
    @Autowired
    DeclareMapper declareMapper;
    @Autowired
    TemoinRepository temoinRepository;
    @Autowired
    TemoinServiceImplService temoinService;
    @Autowired
    TemoinMapper temoinMapper;
    @Autowired
    MentionRepository mentionRepository;
    @Autowired
    MentionServiceImplService mentionService;
    @Autowired
    MentionMapper mentionMapper;
    @Autowired
    DeclarationNaissanceMapper mapper;


    @Override
    public String save(DeclarationNaissance declarationNaissance) {
        DeclarationNaissanceDto dto= mapper.mapDeclarationNaissanceToDeclarationNaissanceDto(declarationNaissance);

        Long idRegistre = registreRepository.findByAnnee(declarationNaissance.getAnneeRegistre());
        Registre registre = registreService.search(idRegistre);
        RegistreDto registreDto = registreMapper.mapRegistreToRegistreDto(registre);

       // RegistreDto registreDto = registreRepository.getReferenceById(registreRepository.findByAnnee(declarationNaissance.getAnneeRegistre()));

        Long idCentre = centreRepository.findByLibele(declarationNaissance.getNomCentre());
        Centre centre = centreService.search(idCentre);
        CentreDto centreDto = centreMapper.mapperCentreToCentreDto(centre);

       // CentreDto centreDto= centreRepository.getReferenceById(centreRepository.findByLibele(declarationNaissance.getNomCentre()));

        Long idFormation = sanitaireRepository.findByLibele(declarationNaissance.getNomFormation());
        FormationSanitaire sanitaire = sanitaireService.search(idFormation);
        FormationSanitaireDto formationSanitaireDto = sanitaireMapper.mapFormationSanitaireToFormationSanitaireDto(sanitaire);

        //FormationSanitaireDto formationSanitaireDto= sanitaireRepository.getReferenceById(sanitaireRepository.findByLibele(declarationNaissance.getNomFormation()));

        Long idPere = pereRepository.findIdByNumeroPiece(declarationNaissance.getNumeroPiecePere());
        Pere pere = pereService.search(idPere);
        PereDto pereDto = pereMapper.mapPereToPereDto(pere);

      //  PereDto pereDto= pereRepository.getReferenceById(pereRepository.findIdByNumeroPiece(declarationNaissance.getNumeroPiecePere()));

        Long idMere = mereRepository.findIdByNumeroPiece(declarationNaissance.getNumeroPieceMere());
        Mere mere = mereService.search(idMere);
        MereDto mereDto = mereMapper.mapMereToMereDto(mere);
       // MereDto mereDto= mereRepository.getReferenceById(mereRepository.findIdByNumeroPiece(declarationNaissance.getNumeroPieceMere()));

        Long idDeclarant = declarantRepository.findIdByNumeroPiece(declarationNaissance.getNumeroPieceDeclarant());
        Declarant declarant = declarantService.search(idDeclarant);
        DeclarantDto declarantDto = declarantMapper.mapDeclarantToDeclarantDto(declarant);

        //DeclarantDto declarantDto= declarantRepository.getReferenceById(declarantRepository.findIdByNumeroPiece(declarationNaissance.getNumeroPieceDeclarant()));

        List<TemoinDto> temoinDtos = listTemoins(declarationNaissance.getListTemoin());

        Long idDeclare = declareService.getIdLastInsertion();
        Declare declare = declareService.search(idDeclare);
        DeclareDto declareDto = declareMapper.mapDeclareToDeclareDto(declare);

        //DeclareDto declareDto = declareRepository.getReferenceById(declareService.getIdLastInsertion());

        dto.setUserAdd(declarationNaissance.getUserAdd());
        dto.setNumero(String.valueOf(numeroCurrentDeclaration()));
        dto.setCentre(centreDto);
        dto.setRegistre(registreDto);
        dto.setFormationSanitaire(formationSanitaireDto);
        dto.setPere(pereDto);
        dto.setMere(mereDto);
        dto.setDeclarant(declarantDto);
        dto.setDeclare(declareDto);
        dto.setTemoin(temoinDtos);
        dto.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss")));

        repository.save(dto);
        return "Insertion reussie !!!";
    }

    @Override
    public List<DeclarationNaissance> list() {
        List<DeclarationNaissanceDto> naissanceDtos = repository.findAll();
        return mapper.mapListDeclaDtoToListDecla(naissanceDtos);
    }

    public Long numeroCurrentDeclaration(){
        Long num = 0L;
        List<DeclarationNaissanceDto> list = new ArrayList<>();
        list = repository.findAll();
        if(list.isEmpty()){
            num = 100L;
        }
        else{
            for(DeclarationNaissanceDto dto:list){
                num = Long.valueOf(dto.getNumero());
            }
            num = num +1;
        }
        return num;
    }
    public List<TemoinDto> listTemoins(List<String> listNumeroTemoin){
        List<TemoinDto> temoinList = new ArrayList<>();
        for(String num: listNumeroTemoin){
            String s = num;
            TemoinDto temoinDto = temoinRepository.findByNumeroPiece(s);
            if(temoinDto != null){
                temoinList.add(temoinDto);
            }
        }
        return temoinList;
    }

//    public List<MentionDto> listMentions(List<String> listNumeroMention){
//        List<MentionDto> mentionList = new ArrayList<>();
//        for(String num: listNumeroMention){
//            String s = num;
//            MentionDto mentionDto = mentionRepository.(s);
//            if(mentionDto != null){
//                mentionList.add(mentionDto);
//            }
//        }
//        return mentionList;
//    }
//
    @Override
    public DeclarationNaissance search(Long id) {
        DeclarationNaissanceDto declarationNaissanceDto= repository.findById(id).get();
        return mapper.mapDeclarationNaissanceDtoToDeclarationNaissance(declarationNaissanceDto);
    }

    @Override
    public String update(Long id, DeclarationNaissance declarationNaissance) {
        DeclarationNaissanceDto declarationNaissanceDto= mapper.mapDeclarationNaissanceToDeclarationNaissanceDto(declarationNaissance);
        DeclarationNaissanceDto existe = repository.findById(id).get();

        if(existe != null) {
            if(declarationNaissance.getCentre() != null) existe.setCentre(declarationNaissanceDto.getCentre());
            if(declarationNaissance.getDate() != null) existe.setDate(declarationNaissanceDto.getDate());
            if(declarationNaissance.getDateModification() != null) existe.setDateModification(declarationNaissanceDto.getDateModification());
            if(declarationNaissance.getDeclarant() != null) existe.setDeclarant(declarationNaissanceDto.getDeclarant());
            if(declarationNaissance.getDeclaration() != null) existe.setDeclaration(declarationNaissanceDto.getDeclaration());
            if(declarationNaissance.getDeclare() != null) existe.setDeclare(declarationNaissanceDto.getDeclare());
            if(declarationNaissance.getFormationSanitaire() != null) existe.setFormationSanitaire(declarationNaissanceDto.getFormationSanitaire());
            if(declarationNaissance.getJugement() != null) existe.setJugement(declarationNaissanceDto.getJugement());
            if(declarationNaissance.getMere() != null) existe.setMere(declarationNaissanceDto.getMere());
            if(declarationNaissance.getPere() != null) existe.setPere(declarationNaissanceDto.getPere());
            if(declarationNaissance.getReference() != null) existe.setReference(declarationNaissanceDto.getReference());
            if(declarationNaissance.getRegistre() != null) existe.setRegistre(declarationNaissanceDto.getRegistre());
            if(declarationNaissance.getScanAt() != null) existe.setScanAt(declarationNaissanceDto.getScanAt());

            repository.save(existe);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";

    }

    @Override
    public String remove(Long id) {
        repository.deleteById(id);
        return "supression reussie !!!";
    }

    @Override
    public DeclarationNaissance verifDeclaration(VerifDeclaration verifDeclaration) {
        Long id = repository.verifDeclaration(verifDeclaration.getNumero());
        DeclarationNaissance naissance = null;
        if(id == null){
            naissance = null;
        }
        else{
            if (search(id).getRegistre().getAnnee().equals(verifDeclaration.getAnnee())){
                naissance = search(id);
            }
        }
        return naissance;

    }

//    @Override
//    public DeclarationNaissance verifDeclaration(String numero) {
//        Long id = repository.verifDeclaration(numero);
//        DeclarationNaissance naissance = null;
//        if(id == null){
//            naissance = null;
//        }
//        else{
//           naissance = search(id);
//        }
//        return naissance;
//
//    }
//
//    @Override
//    public String update(Long id, DeclarationNaissanceDto declarationNaissance) {
//    }
//
//    @Override
//    public String remove(Long id) {
//        String resultat = null;
//        declarationNaissanceRepository.deleteById(id);
//        if(search(id) == null){
//            resultat ="Supression effectuée avec succée";
//        }
//        else{
//            resultat="Oups!!! la supression a échoué.";
//        }
//        return resultat;
//    }
}
