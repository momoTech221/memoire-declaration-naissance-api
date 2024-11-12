package sn.uasz.declarationNaissance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import sn.uasz.declarationNaissance.service.impl.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.uasz.spi.declarationNaissanceApi.CentresApi;
import sn.uasz.spi.declarationNaissanceApi.model.Centre;

import javax.validation.Valid;
import java.util.List;
@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class CentreController implements CentresApi {
    @Autowired
    CentreService centreImpl;

    @Override
    @PostMapping("/centres/create")
    public ResponseEntity<String> saveCentre(@Valid Centre centre) {
        String center = centreImpl.save(centre);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }

    @Override
    @GetMapping("/centres/read")
    public ResponseEntity<List<Centre>> listCentre() {
        List<Centre> retour= centreImpl.list();
        return new ResponseEntity<>(retour,HttpStatus.OK);
    }
    @Override
    @DeleteMapping("/centres/delete/{id}")
    public ResponseEntity<String> removeCentre(@PathVariable Long id) {
        String deletedCenter = centreImpl.remove(id);
        return new ResponseEntity<>(deletedCenter, HttpStatus.OK);
    }

    @Override @GetMapping("/centres/search/{id}")
    public ResponseEntity<Centre> searchCentre(@PathVariable Long id) {
        Centre centre =centreImpl.search(id);
        return new ResponseEntity<>(centre,HttpStatus.OK);
    }

    @GetMapping("/centres/getIdByLibele/{libele}")
    public ResponseEntity<Long> getByLibele(@PathVariable String libele) {
        Long idCentre =centreImpl.getByLibele(libele);
        return new ResponseEntity<>(idCentre,HttpStatus.OK);
    }
    @GetMapping("/centres/allByLibele")
    public ResponseEntity<List<String>> listCentreByLibele() {
        List<String> retour= centreImpl.allCentreByLibele();
        return new ResponseEntity<>(retour,HttpStatus.OK);
    }
    @Override @PutMapping("/centres/update/{id}")
    public ResponseEntity<String> updateCentre(@PathVariable Long id, @Valid Centre centre) {
        String centreUpdate = centreImpl.update(id, centre);
        return new ResponseEntity<>(centreUpdate,HttpStatus.OK);
    }

}
