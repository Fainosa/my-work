package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.repository.EchipaRepository;

import java.util.List;

@RequestMapping( value = "/graph")
@RestController
public class GraphRestController {

    @Autowired
    EchipaRepository echipaRepository;

    @RequestMapping(value = "/team-statistics", method = RequestMethod.GET)
    public String getTeamStatistics() {
        List<Echipa> listaEchipe = echipaRepository.findAll();
        String linie = "";

        StringBuilder builder = new StringBuilder();

        for(Echipa echipa : listaEchipe) {

        }


        return null;

    }
}
