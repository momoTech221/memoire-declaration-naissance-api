package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.FormationSanitaireService;
import sn.uasz.spi.declarationNaissanceApi.FormationSanitairesApi;
import sn.uasz.spi.declarationNaissanceApi.model.FormationSanitaire;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class FormationsanitaireController implements FormationSanitairesApi {
    @Autowired
    FormationSanitaireService formationSanitaireImpl;
    @Override
    @GetMapping("/formationSanitaires/read")
    public ResponseEntity<List<FormationSanitaire>> listFormationSanitaire() {
        List<FormationSanitaire> formationSanitaireList = formationSanitaireImpl.list();
        return new ResponseEntity<>(formationSanitaireList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/formationSanitaires/delete/{id}")
    public ResponseEntity<String> removeFormationSanitaire(@PathVariable Long id) {
        String removedFormSani = formationSanitaireImpl.remove(id);
        return new ResponseEntity<>(removedFormSani,HttpStatus.OK);
    }

    @Override
    @PostMapping("/formationSanitaires/create")
    public ResponseEntity<String> saveFormationSanitaire(@Valid FormationSanitaire formationSanitaire) {
        String formationSanitaire1 = formationSanitaireImpl.save(formationSanitaire);
        return new ResponseEntity<>(formationSanitaire1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/formationSanitaires/search/{id}")
    public ResponseEntity<FormationSanitaire> searchFormationSanitaire(@PathVariable Long id) {
        FormationSanitaire formationSanitaire= formationSanitaireImpl.search(id);
        return new ResponseEntity<>(formationSanitaire,HttpStatus.OK);
    }

    @GetMapping("/formationSanitaires/getIdByLibele/{libele}")
    public ResponseEntity<Long> getIdByLibele(@PathVariable String libele) {
        Long idFormation = formationSanitaireImpl.getIdByLibele(libele);
        return new ResponseEntity<>(idFormation,HttpStatus.OK);
    }

    @GetMapping("/formationSanitaires/allByLibele")
    public ResponseEntity<List<String>> listformationParLibele() {
        List<String> list = formationSanitaireImpl.allFormationByLibele();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Override
    @PutMapping("/formationSanitaires/update/{id}")
    public ResponseEntity<String> updateFormationSanitaire(@PathVariable Long id, @Valid FormationSanitaire formationSanitaire) {
        String updatedFormSan = formationSanitaireImpl.update(id, formationSanitaire);
        return new ResponseEntity<>(updatedFormSan,HttpStatus.OK);
    }
}
