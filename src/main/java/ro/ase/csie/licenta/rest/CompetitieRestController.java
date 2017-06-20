package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Competitie;
import ro.ase.csie.licenta.domain.Jucator;
import ro.ase.csie.licenta.repository.CompetitieRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/competitie")
public class CompetitieRestController {

    @Autowired
    private CompetitieRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Competitie>> getAllCompetitii() {
        List<Competitie> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addCompetitie(@RequestBody Competitie competitie, UriComponentsBuilder ucBuilder) {

        repository.save(competitie);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("competitie/{id}").buildAndExpand(competitie.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Competitie> getCompetitieById(@PathVariable("id") long id) {
        Competitie result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Jucator> deleteCompetitie(@PathVariable("id") long id) {
        Competitie result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Competitie> updateCompetitie(@RequestBody Competitie competitie) {
        Competitie result = repository.findOne(competitie.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(competitie);

        return new ResponseEntity<>(competitie, HttpStatus.OK);
    }

}
