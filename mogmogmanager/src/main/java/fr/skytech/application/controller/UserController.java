package fr.skytech.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.skytech.application.controller.dto.UserDTO;
import fr.skytech.application.services.IUserService;

@Controller
@RequestMapping("/api/users")
public class UserController  {

	@Autowired
	IUserService service;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public  @ResponseBody UserDTO findUserById(@PathVariable Integer userId	) {
		UserDTO dto = service.findUserById(userId);
        return dto;
    }
	
	@RequestMapping(value="/id/{userId}", method=RequestMethod.GET)
    public  @ResponseBody UserDTO moreFindUserById(@PathVariable Integer userId	) {
		UserDTO dto = service.findUserById(userId);
        return dto;
    }
	
	@RequestMapping(value="/username/{userName}", method=RequestMethod.GET)
    public  @ResponseBody UserDTO moreFindUserByUsername(@PathVariable String userName	) {
		UserDTO dto = service.findUserByUsername(userName);
        return dto;
    }
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public  @ResponseBody List<UserDTO> findAll() {
		List<UserDTO> dtos = service.findAll();
        return dtos;
    }
	
}
