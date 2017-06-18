package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Tabela2P;
import ro.ase.csie.licenta.repository.Tabela2PRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/tabela2p")
public class Tabela2PRestController {


    @Autowired
    private Tabela2PRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Tabela2P>> getAllTabela2P() {
        List<Tabela2P> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addTabela2P(@RequestBody Tabela2P tabela2P, UriComponentsBuilder ucBuilder) {

        repository.save(tabela2P);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("tabela2p/{id}").buildAndExpand(tabela2P.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Tabela2P> getTabela1pById(@PathVariable("id") long id) {
        Tabela2P result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tabela2P> deleteTabela2P(@PathVariable("id") long id) {
        Tabela2P result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Tabela2P> updateTabela2P(@RequestBody Tabela2P tabela2P) {
        Tabela2P result = repository.findOne(tabela2P.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(tabela2P);

        return new ResponseEntity<>(tabela2P, HttpStatus.OK);
    }
}