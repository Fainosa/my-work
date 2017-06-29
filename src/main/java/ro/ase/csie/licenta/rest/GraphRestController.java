package ro.ase.csie.licenta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ase.csie.licenta.domain.Echipa;
import ro.ase.csie.licenta.domain.Infrangeri;
import ro.ase.csie.licenta.domain.Victorii;
import ro.ase.csie.licenta.repository.EchipaRepository;
import ro.ase.csie.licenta.repository.InfrangeriRepository;
import ro.ase.csie.licenta.repository.VictoriiRepository;

import java.util.List;

@RequestMapping(value = "/graph-echipa")
@RestController
public class GraphRestController {

    @Autowired
    EchipaRepository echipaRepository;

    @Autowired
    VictoriiRepository victoriiRepository;

    @Autowired
    InfrangeriRepository infrangeriRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String getSkillStatistics() {
        String result = " [ ";

        List<Echipa> echipe = echipaRepository.findAll();
        Infrangeri infrangeri;
        Victorii victorii;

        for (Echipa echipa : echipe) {
            result = result + " {\"\" : " + " \" " + echipa.getNumeEchipa() + " \"" + " , \"data\" : [ ";

            infrangeri = infrangeriRepository.findByEchipa(echipa).get(0);
            victorii = victoriiRepository.findByEchipa(echipa).get(0);

            result = result + " { \"x\" : " + " \"" + echipa.getNumeEchipa() + "\" , " + " \"y\" : "
                    + 2 * victorii.getNumarVictorii() + infrangeri.getNumarInfrangeri() + " } , ";

        }

        result = result.substring(0, result.length() - 4);
        result = result + " } ]";

        return result;
    }
}
