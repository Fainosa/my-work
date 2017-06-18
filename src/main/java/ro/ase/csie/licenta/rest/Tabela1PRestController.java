package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Tabela1P;
import ro.ase.csie.licenta.repository.Tabela1PRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/tabela1p")
public class Tabela1PRestController {


    @Autowired
    private Tabela1PRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Tabela1P>> getAllTabela1P() {
        List<Tabela1P> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addTabela1P(@RequestBody Tabela1P tabela1P, UriComponentsBuilder ucBuilder) {

        repository.save(tabela1P);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("tabela1p/{id}").buildAndExpand(tabela1P.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Tabela1P> getTabela1pById(@PathVariable("id") long id) {
        Tabela1P result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tabela1P> deleteTabela1P(@PathVariable("id") long id) {
        Tabela1P result = repository.findOne(id);

        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Tabela1P> updateTabela1P(@RequestBody Tabela1P tabela1P) {
        Tabela1P result = repository.findOne(tabela1P.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(tabela1P);

        return new ResponseEntity<>(tabela1P, HttpStatus.OK);
    }

}
