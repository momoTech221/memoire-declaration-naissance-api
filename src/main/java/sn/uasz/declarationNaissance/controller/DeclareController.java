package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.DeclareService;
import sn.uasz.spi.declarationNaissanceApi.DeclaresApi;
import sn.uasz.spi.declarationNaissanceApi.model.Declare;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class DeclareController implements DeclaresApi {
    @Autowired
    DeclareService declareImpl;
    @Override
    @GetMapping("/declares/read")
    public ResponseEntity<List<Declare>> listDeclare() {
        List<Declare> declareList= declareImpl.list();
        return new ResponseEntity<>(declareList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/declares/delete/{id}")
    public ResponseEntity<String> removeDeclare(Long id) {
        String deletedDeclare = declareImpl.remove(id);
        return new ResponseEntity<>(deletedDeclare,HttpStatus.OK);
    }

    @Override
    @PostMapping("/declares/create")
    public ResponseEntity<String> saveDeclare(@Valid Declare declare) {
        String declare1 = declareImpl.save(declare);
        return new ResponseEntity<>(declare1,HttpStatus.OK);
    }

    @Override
    @GetMapping ("/declares/search/{id}")
    public ResponseEntity<Declare> searchDeclare(@PathVariable Long id) {
        Declare declare= declareImpl.search(id);
        return new ResponseEntity<>(declare, HttpStatus.OK);
    }

    @Override
    @PutMapping("/declares/update/{id}")
    public ResponseEntity<String> updateDeclare(@PathVariable Long id, @Valid Declare declare) {
        String declaredUpdate = declareImpl.update(id, declare);
        return new ResponseEntity<>(declaredUpdate,HttpStatus.OK);
    }
}
