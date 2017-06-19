package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Antrenor;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Jucator;
import ro.ase.csie.licenta.repository.AntrenorRepository;
import ro.ase.csie.licenta.repository.EchipaRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/antrenor")
public class AntrenoriRestController {

    @Autowired
    private AntrenorRepository repository;

    @Autowired
    private EchipaRepository echipaRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Antrenor>> getAllAntrenori() {
        List<Antrenor> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addAntrenor(@RequestBody Antrenor antrenor, UriComponentsBuilder ucBuilder) {

        repository.save(antrenor);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("antrenor/{id}").buildAndExpand(antrenor.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Antrenor> getAntrenorById(@PathVariable("id") long id) {
        Antrenor result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Antrenor>> getAntrenorByNume(@PathVariable("name") String name) {
        List<Antrenor> result = repository.findByNume(name);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Antrenor> deleteAntrenor(@PathVariable("id") long id) {
        Antrenor result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Antrenor> updateAntrenor(@RequestBody Antrenor antrenor) {
        Antrenor result = repository.findOne(antrenor.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(antrenor);

        return new ResponseEntity<>(antrenor, HttpStatus.OK);
    }

    @RequestMapping(value = "/echipa/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Antrenor>> getJucatoriByEchipa(@PathVariable("id") long id) {
        Echipa echipa = echipaRepository.findOne(id);

        if(echipa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Antrenor> result = (List<Antrenor>) repository.findByEchipa(echipa);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
