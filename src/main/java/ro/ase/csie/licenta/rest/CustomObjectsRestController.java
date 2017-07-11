package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.utils.CustomEchipa;
import ro.ase.csie.licenta.repository.EchipaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "custom")
public class CustomObjectsRestController {

    @Autowired
    private EchipaRepository echipaRepository;

    @RequestMapping(value = "/echipe" , method = RequestMethod.GET)
    public ResponseEntity<List<CustomEchipa>> geCustomEchipaObjectList() {
        List<CustomEchipa> result = new ArrayList();

        List<Echipa> echipe = echipaRepository.findAll();

        for(Echipa e : echipe) {
            int nrVictorii = e.getVictorii().get(0).getNumarVictorii();
            int nrInfrangeri = e.getInfrangeri().get(0).getNumarInfrangeri();

            CustomEchipa customEchipa = new CustomEchipa(e.getNumeEchipa(), e.getCosuriMarcate(), e.getCosuriPrimite(),
                   nrVictorii, nrInfrangeri, 2 * nrVictorii + nrInfrangeri);
            result.add(customEchipa);
        }

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Collections.sort(result, (s1, s2) ->
                Integer.compare(s2.getPunctaj(), s1.getPunctaj()));

        for(int i = 0; i < result.size(); i++) {
            result.get(i).setLoc(i + 1);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
