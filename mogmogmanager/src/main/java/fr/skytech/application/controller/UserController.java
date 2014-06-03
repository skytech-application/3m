package fr.skytech.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.services.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController  {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public  @ResponseBody UserDto findUserById(@PathVariable Long userId) {
        return moreFindUserById(userId);
    }
	
	@RequestMapping(value="/id/", method=RequestMethod.GET)
    public  @ResponseBody UserDto moreFindUserByIdEmpty() throws TechnicalException,FunctionalException {
		throw new FunctionalException("ID is mandatory");
    }
	
	@RequestMapping(value="/id/{userId}", method=RequestMethod.GET)
    public  @ResponseBody UserDto moreFindUserById(@PathVariable Long userId) throws TechnicalException,FunctionalException {
		if (userId < 0 ) throw new FunctionalException("ID must be positive");
		UserDto dto = service.findUserById(userId);
        return dto;
    }
	
	@RequestMapping(value="/username/", method=RequestMethod.GET)
    public  @ResponseBody UserDto moreFindUserByUsernameEmpty() {
		throw new FunctionalException("Username is mandatory");
    }
	
	@RequestMapping(value="/username/{userName}", method=RequestMethod.GET)
    public  @ResponseBody UserDto moreFindUserByUsername(@PathVariable String userName	) {
		UserDto dto = service.findUserByUsername(userName);
        return dto;
    }
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public  @ResponseBody List<UserDto> findAll() {
		List<UserDto> dtos = service.findAll();
        return dtos;
    }
		
}