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
import ro.ase.csie.licenta.domain.Meci;
import ro.ase.csie.licenta.repository.AntrenorRepository;
import ro.ase.csie.licenta.repository.EchipaRepository;
import ro.ase.csie.licenta.repository.JucatorRepository;
import ro.ase.csie.licenta.repository.MeciRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/echipa")
public class EchipaRestController {

    @Autowired
    private EchipaRepository repository;

    @Autowired
    private JucatorRepository jucatorRepository;

    @Autowired
    private AntrenorRepository antrenorRepository;

    @Autowired
    private MeciRepository meciRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Echipa>> getAllEchipe() {
        List<Echipa> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addEchipa(@RequestBody Echipa echipa, UriComponentsBuilder ucBuilder) {

        repository.save(echipa);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("echipa/{id}").buildAndExpand(echipa.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Echipa> getEchipaById(@PathVariable("id") long id) {
        Echipa result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Echipa> deleteEchipa(@PathVariable("id") long id) {
        Echipa result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Echipa> updateEchipa(@RequestBody Echipa echipa) {
        Echipa result = repository.findOne(echipa.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(echipa);

        return new ResponseEntity<>(echipa, HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Echipa>> getEchipaByName( @PathVariable("name") String name) {
        List<Echipa> result = repository.findByNumeEchipa(name);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/meci/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Echipa>> getEchipeByMeci(@PathVariable("id") long id) {
        Meci meci = meciRepository.findOne(id);

        if (meci == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Echipa> result = repository.findByMeci(meci);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/jucator/{id}", method = RequestMethod.GET)
    public ResponseEntity<Echipa> getByJucator(@PathVariable("id") long id) {
        Jucator jucator = jucatorRepository.findOne(id);

        if (jucator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Echipa result = repository.findByJucatori(jucator).get(0);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @RequestMapping(value = "/antrenor/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Echipa> getByAntrenor(@PathVariable("id") long id) {
//       Antrenor antrenor = antrenorRepository.findOne(id);
//
//        if (antrenor == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        Echipa result = repository.findByAntrenor(antrenor).get(0);
//
//        if (result == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

}
