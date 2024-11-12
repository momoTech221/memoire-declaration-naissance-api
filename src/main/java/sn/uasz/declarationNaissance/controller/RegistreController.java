package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.RegistreService;
import sn.uasz.spi.declarationNaissanceApi.RegistresApi;
import sn.uasz.spi.declarationNaissanceApi.model.Registre;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class RegistreController implements RegistresApi {
    @Autowired
    RegistreService registreImpl;
    @Override
    @GetMapping("/registres/read")
    public ResponseEntity<List<Registre>> listRegistre() {
        List<Registre>registreList = registreImpl.list();
        return new ResponseEntity<>(registreList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/registres/delete/{id}")
    public ResponseEntity<String> removeRegistre(@PathVariable Long id) {
        String deletedRegistre = registreImpl.remove(id);
        return new ResponseEntity<>(deletedRegistre,HttpStatus.OK);
    }
    @Override
    @PostMapping("/registres/create")
    public ResponseEntity<String> saveRegistre(@Valid Registre registre) {
        String registre1 = registreImpl.save(registre);
        return new ResponseEntity<>(registre1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/registres/search/{id}")
    public ResponseEntity<Registre> searchRegistre(@PathVariable Long id) {
        Registre registre = registreImpl.search(id);
        return new ResponseEntity<>(registre,HttpStatus.OK);
    }

    @GetMapping("/registres/getIdByAnnee/{annee}")
    public ResponseEntity<Long> getIdByAnnee(@PathVariable String annee) {
        Long idRegistre = registreImpl.getByAnnee(annee);
        return new ResponseEntity<>(idRegistre,HttpStatus.OK);
    }
    @GetMapping("/registres/allByAneee")
    public ResponseEntity<List<String>> listRegistreParAneee() {
        List<String> list = registreImpl.allRegistreByAneee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Override
    @PutMapping("/registres/update/{id}")
    public ResponseEntity<String> updateRegistre(@PathVariable Long id, @Valid Registre registre) {
        String newRegistre = registreImpl.update(id, registre);
        return new ResponseEntity<>(newRegistre,HttpStatus.OK);
    }
}
