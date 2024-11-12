package sn.uasz.declarationNaissance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.declarationNaissance.service.impl.MentionService;
import sn.uasz.spi.declarationNaissanceApi.MentionsApi;
import sn.uasz.spi.declarationNaissanceApi.model.Mention;

import javax.validation.Valid;
import java.util.List;
@Validated
@Controller
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class MentionController implements MentionsApi {

    @Autowired
    MentionService mentionImpl;

    @Override
    @GetMapping("/mentions/read")
    public ResponseEntity<List<Mention>> listMention() {
        List<Mention> mentionList = mentionImpl.list();
        return new ResponseEntity<>(mentionList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/mentions/delete/{id}")
    public ResponseEntity<String> removeMention(@PathVariable Long id) {
        String deletedMention = mentionImpl.remove(id);
        return new ResponseEntity<>(deletedMention,HttpStatus.OK);
    }

    @Override
    @GetMapping("/mentions/create")
    public ResponseEntity<String> saveMention(@Valid Mention mention) {
        String mention1 = mentionImpl.save(mention);
        return new ResponseEntity<>(mention1,HttpStatus.OK);
    }

    @Override
    @GetMapping("/mentions/search/{id}")
    public ResponseEntity<Mention> searchMention(@PathVariable Long id) {
        Mention mention = mentionImpl.search(id);
        return new ResponseEntity<>(mention,HttpStatus.OK);
    }

    @Override
    @PutMapping("/mentions/update/{id}")
    public ResponseEntity<String> updateMention(@PathVariable Long id, @Valid Mention mention) {
        String updatedMent = mentionImpl.update(id, mention);
        return new ResponseEntity<>(updatedMent,HttpStatus.OK);
    }
}
