package ma.tetouan.factoryrest.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private String ADMIN_USERNAME = System.getenv().get("ADMIN_USERNAME");
	
	private String ADMIN_PASSWORD = System.getenv().get("ADMIN_PASSWORD");
	
	public String getAdminAuth() {
		return ADMIN_USERNAME+"--"+ADMIN_PASSWORD;
	}
	
}
