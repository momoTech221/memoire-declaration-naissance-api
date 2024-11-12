package sn.uasz.declarationNaissance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import sn.uasz.declarationNaissance.service.impl.DeclarationNaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.uasz.spi.declarationNaissanceApi.DeclarationNaissancesApi;
import sn.uasz.spi.declarationNaissanceApi.model.DeclarationNaissance;
import sn.uasz.spi.declarationNaissanceApi.model.VerifDeclaration;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class DeclarationNaissanceController implements DeclarationNaissancesApi {
    @Autowired
    DeclarationNaissanceService declarationNaissanceImpl;
//    @Autowired
//    DeclarationNaissanceRepository repository;

    @Override
    @GetMapping("/declarationNaissances/read")
    public ResponseEntity<List<DeclarationNaissance>> listDeclarationNaissance() {
        List<DeclarationNaissance> declarationNaissanceList = declarationNaissanceImpl.list();
        return new ResponseEntity<>(declarationNaissanceList, HttpStatus.OK);
    }
    @Override
    @PostMapping("/declarationNaissances/verifDeclaration")
    public ResponseEntity<DeclarationNaissance> verifDeclarationd(@RequestBody @Valid VerifDeclaration verifDeclaration){
//        VerifDeclaration verifDeclaration = new VerifDeclaration();
//        verifDeclaration.setNumero();
        DeclarationNaissance d = declarationNaissanceImpl.verifDeclaration(verifDeclaration);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

//    @GetMapping("/declarationNaissances/verifDeclaration/{numero}")
//    public ResponseEntity<DeclarationNaissance> verifDeclaration(@PathVariable String numero){
//        DeclarationNaissance d = declarationNaissanceImpl.verifDeclaration(numero);
//        return new ResponseEntity<>(d,HttpStatus.OK);
//    }
    @Override
    @DeleteMapping("/declarationNaissances/delete/{id}")
    public ResponseEntity<String> removeDeclarationNaissance(@PathVariable Long id) {
        String removeDeclarant = declarationNaissanceImpl.remove(id);
        return new ResponseEntity<>(removeDeclarant,HttpStatus.OK);
    }

    @Override
    @PostMapping("/declarationNaissances/create")
    public ResponseEntity<String> saveDeclarationNaissance(@Valid DeclarationNaissance declarationNaissance) {
        String declarationNaissance1 = declarationNaissanceImpl.save(declarationNaissance);
        return new ResponseEntity<>(declarationNaissance1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/declarationNaissances/search/{id}")
    public ResponseEntity<DeclarationNaissance> searchDeclarationNaissance(@PathVariable Long id) {
        DeclarationNaissance declarationNaissance = declarationNaissanceImpl.search(id);
        return new ResponseEntity<>(declarationNaissance,HttpStatus.OK);
    }

    @Override
    @PutMapping("/declarationNaissances/update/{id}")
    public ResponseEntity<String> updateDeclarationNaissance(@PathVariable Long id, @Valid DeclarationNaissance declarationNaissance) {
        String updatedDeclNaiss = declarationNaissanceImpl.update(id, declarationNaissance);
        return new ResponseEntity<>(updatedDeclNaiss,HttpStatus.OK);
    }

}
