package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Competitie;
import ro.ase.csie.licenta.domain.Jucator;
import ro.ase.csie.licenta.domain.Meci;
import ro.ase.csie.licenta.repository.CompetitieRepository;
import ro.ase.csie.licenta.repository.MeciRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/meci")
public class MeciRestController {

    @Autowired
    private MeciRepository repository;

    @Autowired
    private CompetitieRepository competitieRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Meci>> getAllMeciuri() {
        List<Meci> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addMeci(@RequestBody Meci meci, UriComponentsBuilder ucBuilder) {

        repository.save(meci);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("meci/{id}").buildAndExpand(meci.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Meci> getMeciById(@PathVariable("id") long id) {
        Meci result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Jucator> deleteMeci(@PathVariable("id") long id) {
        Meci result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Meci> updateMeci(@RequestBody Meci meci) {
        Meci result = repository.findOne(meci.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(meci);

        return new ResponseEntity<>(meci, HttpStatus.OK);
    }

    @RequestMapping(value = "/competitie/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Meci>> getMeciuriByCompetitie(@PathVariable("id") long id) {
        Competitie competitie = competitieRepository.findOne(id);

        if(competitie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Meci> result = (List<Meci>) repository.findByCompetitie(competitie);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
