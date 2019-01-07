package ma.tetouan.factoryrest.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ma.tetouan.factoryrest.config.ConnectedUser;

@Service
public class UserService {
	
	private UserDetails userDetails;
	
	public ConnectedUser getConnectedUser() {
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ConnectedUser connectedUser = new ConnectedUser();
		connectedUser.setUserName(userDetails.getUsername());
//		connectedUser.setRoles(userDetails.getAuthorities().toArray());
		connectedUser.setIsAdmin(hasAdminRole());
		return connectedUser;
	}
	
	public Boolean hasAdminRole() {
		boolean hasRole = false;
		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			hasRole = authority.getAuthority().equals("ROLE_ADMIN");
			if (hasRole) {
				break;
			}
		}
		return hasRole;
	}
	
}
