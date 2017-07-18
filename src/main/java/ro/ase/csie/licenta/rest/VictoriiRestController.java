package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Infrangeri;
import ro.ase.csie.licenta.domain.Victorii;
import ro.ase.csie.licenta.repository.EchipaRepository;
import ro.ase.csie.licenta.repository.VictoriiRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/victorii")
public class VictoriiRestController {


    @Autowired
    private VictoriiRepository repository;

    @Autowired
    private EchipaRepository echipaRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Victorii>> getAllVictorii() {
        List<Victorii> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addVictorii(@RequestBody Victorii victorii, UriComponentsBuilder ucBuilder) {

        repository.save(victorii);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("victorii/{id}").buildAndExpand(victorii.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Victorii> getVictoriiById(@PathVariable("id") long id) {
        Victorii result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Victorii> deleteVictorii(@PathVariable("id") long id) {
        Victorii result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Victorii> updateVictorii(@RequestBody Victorii victorii) {
        Victorii result = repository.findOne(victorii.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(victorii);

        return new ResponseEntity<>(victorii, HttpStatus.OK);
    }

    @RequestMapping(value = "/echipa/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Victorii>> getVictoriiByEchipa(@PathVariable("id") long id) {
        Echipa echipa = echipaRepository.findOne(id);

        if(echipa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Victorii> result = (List<Victorii>) repository.findByEchipa(echipa);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "addEchipa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Victorii> addEchipaPentruVictorie(@RequestBody Victorii victorii, @PathVariable("id") long id) {
        Echipa echipa = echipaRepository.findOne(id);
        if(echipa != null) {
            victorii.setEchipa(echipa);
        }

        repository.save(victorii);

        return new ResponseEntity<>(victorii, HttpStatus.CREATED);
    }

}