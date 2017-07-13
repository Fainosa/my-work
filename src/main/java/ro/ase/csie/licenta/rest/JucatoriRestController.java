package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Jucator;
import ro.ase.csie.licenta.repository.EchipaRepository;
import ro.ase.csie.licenta.repository.JucatorRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/jucator")
public class JucatoriRestController {

    @Autowired
    private JucatorRepository repository;

    @Autowired
    private EchipaRepository echipaRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Jucator>> getAllEmployees() {
        List<Jucator> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Collections.sort(result, new Comparator<Jucator>() {
                    @Override
                    public int compare(Jucator o1, Jucator o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }
        );

        for(int i=0; i<result.size(); i++){
            result.get(i).setNumarJucator(i+1);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addJucatori(@RequestBody Jucator jucator, UriComponentsBuilder ucBuilder) {

        repository.save(jucator);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("jucator/{id}").buildAndExpand(jucator.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Jucator> getJucatorById(@PathVariable("id") long id) {
        Jucator result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Jucator>> getJucatorByName(@PathVariable("name") String name) {
        List<Jucator> result = repository.findByNume(name);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Jucator> deleteJucator(@PathVariable("id") long id) {
        Jucator result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Jucator> updateJucator(@RequestBody Jucator jucator) {
        Jucator result = repository.findOne(jucator.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(jucator);

        return new ResponseEntity<>(jucator, HttpStatus.OK);
    }

    @RequestMapping(value = "/echipa/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Jucator>> getJucatoriByEchipa(@PathVariable("id") long id) {
        Echipa echipa = echipaRepository.findOne(id);

        if (echipa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Jucator> result = (List<Jucator>) repository.findByEchipa(echipa);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
