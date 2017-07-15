package ro.ase.csie.licenta.rest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorRestController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "We have some error here. Sorry for the inconvenience";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
