package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.DemandeService;
import sn.uasz.spi.declarationNaissanceApi.DemandesApi;
import sn.uasz.spi.declarationNaissanceApi.model.Declare;
import sn.uasz.spi.declarationNaissanceApi.model.Demande;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeController implements DemandesApi {

    @Autowired
    DemandeService service;
    @Override
    @GetMapping("/demandes/read")
    public ResponseEntity<List<Demande>> listDemande() {
        List<Demande> demandeList= service.list();
        return new ResponseEntity<>(demandeList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/demandes/delete/{id}")
    public ResponseEntity<String> removeDemande(Long id) {
        String deletedDmande = service.remove(id);
        return new ResponseEntity<>(deletedDmande,HttpStatus.OK);
    }

    @Override
    @PostMapping("/demandes/create")
    public ResponseEntity<String> saveDemande(@Valid Demande demande) {
        String demande1 = service.save(demande);
        return new ResponseEntity<>(demande1,HttpStatus.OK);
    }

    @Override
    @GetMapping ("/demandes/search/{id}")
    public ResponseEntity<Demande> searchDemande(Long id) {
        Demande demande= service.search(id);
        return new ResponseEntity<>(demande, HttpStatus.OK);
    }

    @Override
    @PutMapping("/demandes/update/{id}")
    public ResponseEntity<String> updateDemande(Long id, @Valid Demande demande) {
        String demandedUpdate = service.update(id, demande);
        return new ResponseEntity<>(demandedUpdate,HttpStatus.OK);
    }
}
