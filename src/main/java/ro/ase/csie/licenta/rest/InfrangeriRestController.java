package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Infrangeri;
import ro.ase.csie.licenta.repository.EchipaRepository;
import ro.ase.csie.licenta.repository.InfrangeriRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/infrangeri")
public class InfrangeriRestController {


    @Autowired
    private InfrangeriRepository repository;

    @Autowired
    private EchipaRepository echipaRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Infrangeri>> getInfrangeri() {
        List<Infrangeri> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addInfrangeri(@RequestBody Infrangeri infrangeri, UriComponentsBuilder ucBuilder) {

        repository.save(infrangeri);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("infrangeri/{id}").buildAndExpand(infrangeri.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Infrangeri> getInfrangeriById(@PathVariable("id") long id) {
        Infrangeri result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Infrangeri> deleteInfrangeri(@PathVariable("id") long id) {
        Infrangeri result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Infrangeri> updateInfrangeri(@RequestBody Infrangeri infrangeri) {
        Infrangeri result = repository.findOne(infrangeri.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(infrangeri);

        return new ResponseEntity<>(infrangeri, HttpStatus.OK);
    }

    @RequestMapping(value = "/echipa/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Infrangeri>> getInfrangeriByEchipa(@PathVariable("id") long id) {
        Echipa echipa = echipaRepository.findOne(id);

        if (echipa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Infrangeri> result = (List<Infrangeri>) repository.findByEchipa(echipa);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
