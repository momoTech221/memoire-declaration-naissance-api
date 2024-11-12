package sn.uasz.declarationNaissance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import sn.uasz.declarationNaissance.service.impl.DeclarantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.uasz.spi.declarationNaissanceApi.DeclarantsApi;
import sn.uasz.spi.declarationNaissanceApi.model.Declarant;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class DeclarantController implements DeclarantsApi {
    @Autowired
    DeclarantService declarantImpl;

    @Override
    @GetMapping("/declarants/read")
    public ResponseEntity<List<Declarant>> listDeclarant() {
        List<Declarant> declarantList = declarantImpl.list();
        return new ResponseEntity<>(declarantList, HttpStatus.OK);
    }

    @Override @DeleteMapping("/declarants/delete/{id}")
    public ResponseEntity<String> removeDeclarant(@PathVariable Long id) {
        String declarantRemove = declarantImpl.remove(id);
        return new ResponseEntity<>(declarantRemove,HttpStatus.OK);
    }

    @Override @PostMapping("/declarants/create")
    public ResponseEntity<String> saveDeclarant(@Valid Declarant declarant) {
        String declarant1 = declarantImpl.save(declarant);
        return new ResponseEntity<>(declarant1,HttpStatus.OK);
    }

    @Override @GetMapping("/declarants/search/{id}")
    public ResponseEntity<Declarant> searchDeclarant(@PathVariable Long id) {
        Declarant searchDeclarant = declarantImpl.search(id);
        return new ResponseEntity<>(searchDeclarant,HttpStatus.OK);
    }

    @Override @PutMapping("/declarants/update/{id}")
    public ResponseEntity<String> updateDeclarant(@PathVariable Long id, @Valid Declarant declarant) {
        String updateDeclarant = declarantImpl.update(id,declarant);
        return new ResponseEntity<>(updateDeclarant,HttpStatus.OK);
    }
}

