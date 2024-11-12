package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.TemoinService;
import sn.uasz.spi.declarationNaissanceApi.TemoinsApi;
import sn.uasz.spi.declarationNaissanceApi.model.Temoin;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class TemoinController implements TemoinsApi {

    @Autowired
    TemoinService temoinImpl;
    @Override
    @GetMapping("/temoins/read")
    public ResponseEntity<List<Temoin>> listTemoin() {
        List<Temoin> temoins= temoinImpl.list();
        return new ResponseEntity<>(temoins, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/temoins/delete/{id}")
    public ResponseEntity<String> removeTemoin(@PathVariable Long id) {
        String deletedTemoin = temoinImpl.remove(id);
        return new ResponseEntity<>(deletedTemoin,HttpStatus.OK);
    }

    @Override
    @PostMapping("/temoins/create")
    public ResponseEntity<String> saveTemoin(@Valid Temoin temoin) {
        String temoin1 = temoinImpl.save(temoin);
        return new ResponseEntity<>(temoin1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/temoins/search/{id}")
    public ResponseEntity<Temoin> searchTemoin(@PathVariable Long id) {
        Temoin temoin = temoinImpl.search(id);
        return new ResponseEntity<>(temoin,HttpStatus.OK);
    }

    @Override
    @PutMapping("/temoins/update/{id}")
    public ResponseEntity<String> updateTemoin(@PathVariable Long id, @Valid Temoin temoin) {
        String newTemoin = temoinImpl.update(id, temoin);
        return new ResponseEntity<>(newTemoin,HttpStatus.OK);
    }
}
