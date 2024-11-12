package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.JugementService;
import sn.uasz.spi.declarationNaissanceApi.JugementsApi;
import sn.uasz.spi.declarationNaissanceApi.model.Jugement;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class JugementController implements JugementsApi {

    @Autowired
    JugementService jugementImpl;
    @Override
    @GetMapping("/jugements/read")
    public ResponseEntity<List<Jugement>> listJugement() {
        List<Jugement> jugementList = jugementImpl.list();
        return new ResponseEntity<>(jugementList,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/jugements/delete/{id}")
    public ResponseEntity<String> removeJugement(Long id) {
        String deletedJud = jugementImpl.remove(id);
        return new ResponseEntity<>(deletedJud,HttpStatus.OK);
    }

    @Override
    @GetMapping("jugements/create")
    public ResponseEntity<String> saveJugement(@Valid Jugement jugement) {
        String jugement1 = jugementImpl.save(jugement);
        return new ResponseEntity<>(jugement1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/jugements/search/{id}")
    public ResponseEntity<Jugement> searchJugement(@PathVariable Long id) {
        Jugement jugement = jugementImpl.search(id);
        return new ResponseEntity<>(jugement,HttpStatus.OK);
    }

    @Override
    @PutMapping("/jugements/update/{id}")
    public ResponseEntity<String> updateJugement(@PathVariable Long id, @Valid Jugement jugement) {
        String updatedJud = jugementImpl.update(id, jugement);
        return new ResponseEntity<>(updatedJud, HttpStatus.OK);
    }
}
