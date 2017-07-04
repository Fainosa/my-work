package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.User;
import ro.ase.csie.licenta.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {


    @Autowired
    private UserRepository repository;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> result = repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

        repository.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        User result = repository.findOne(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User infrangeri) {
        User result = repository.findOne(infrangeri.getId());

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.save(infrangeri);

        return new ResponseEntity<>(infrangeri, HttpStatus.OK);
    }

}
