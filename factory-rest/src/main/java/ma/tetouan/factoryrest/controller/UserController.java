package ma.tetouan.factoryrest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.tetouan.factoryrest.config.ConnectedUser;
import ma.tetouan.factoryrest.service.UserService;

@RestController
@RequestMapping({ "/api/user" })
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public ConnectedUser getConnectedUser() {
		return userService.getConnectedUser();
	}
	
}
