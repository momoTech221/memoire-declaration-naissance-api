package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.PereService;
import sn.uasz.spi.declarationNaissanceApi.PeresApi;
import sn.uasz.spi.declarationNaissanceApi.model.Pere;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class PereController implements PeresApi {

    @Autowired
    PereService pereImpl;
    @Override
    @GetMapping("peres/read")
    public ResponseEntity<List<Pere>> listPere() {
        List<Pere> pereList= pereImpl.list();
        return new ResponseEntity<>(pereList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/peres/delete/{id}")
    public ResponseEntity<String> removePere(@PathVariable Long id) {
        String deleteDad = pereImpl.remove(id);
        return new ResponseEntity<>(deleteDad,HttpStatus.OK);
    }

    @Override
    @PostMapping("/peres/create")
    public ResponseEntity<String> savePere(@Valid Pere pere) {
        String pere1 = pereImpl.save(pere);
        return new ResponseEntity<>(pere1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/peres/search/{id}")
    public ResponseEntity<Pere> searchPere(@PathVariable Long id) {
        Pere pere = pereImpl.search(id);
        return new ResponseEntity<>(pere,HttpStatus.OK);
    }

    @Override
    @PutMapping("peres/update/{id}")
    public ResponseEntity<String> updatePere(@PathVariable Long id, @Valid Pere pere) {
        String updatedDad = pereImpl.update(id, pere);
        return new ResponseEntity<>(updatedDad,HttpStatus.OK);
    }
}
