package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.MereService;
import sn.uasz.spi.declarationNaissanceApi.MeresApi;
import sn.uasz.spi.declarationNaissanceApi.model.Mere;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class MereController implements MeresApi {

    @Autowired
    MereService mereImpl;

    @Override
    @GetMapping("/meres/read")
    public ResponseEntity<List<Mere>> listMere() {
        List<Mere> mereList= mereImpl.list();
        return new ResponseEntity<>(mereList,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/meres/delete/{id}")
    public ResponseEntity<String> removeMere(Long id) {
        String deleteMum = mereImpl.remove(id);
        return new ResponseEntity<>(deleteMum,HttpStatus.OK);
    }

    @Override
    @PostMapping("/meres/create")
    public ResponseEntity<String> saveMere(@Valid Mere mere) {
        String mere1 = mereImpl.save(mere);
        return new ResponseEntity<>(mere1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/meres/search/{id}")
    public ResponseEntity<Mere> searchMere(Long id) {
        Mere mere = mereImpl.search(id);
        return new ResponseEntity<>(mere,HttpStatus.OK);
    }

    @Override
    @PutMapping("/meres/update/{id}")
    public ResponseEntity<String> updateMere(Long id, @Valid Mere mere) {
        String updatedMum = mereImpl.update(id, mere);
        return new ResponseEntity<>(updatedMum, HttpStatus.OK);
    }
}
