package fr.skytech.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ErrorController {

	@RequestMapping(value="/errors/404", method=RequestMethod.GET)
    public String sendError404() {
        return "error404";
    }
	
	@RequestMapping(value="/errors/technical", method=RequestMethod.GET)
    public String sendTechnicalException() {
        return "errorTechnical";
    }
	
}
