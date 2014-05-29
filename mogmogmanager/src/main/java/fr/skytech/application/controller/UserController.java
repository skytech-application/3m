package fr.skytech.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.services.IUserService;

@Controller
@RequestMapping("/api/users")
public class UserController  {

	@Autowired
	IUserService service;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public  @ResponseBody UserDto findUserById(@PathVariable Long userId	) {
		UserDto dto = service.findUserById(userId);
        return dto;
    }
	
	@RequestMapping(value="/id/{userId}", method=RequestMethod.GET)
    public  @ResponseBody UserDto moreFindUserById(@PathVariable Long userId	) {
		UserDto dto = service.findUserById(userId);
        return dto;
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
