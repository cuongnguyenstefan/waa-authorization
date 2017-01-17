package edu.mum.waa.service;


import edu.mum.waa.model.User;

public class LoginServiceImpl implements LoginService {
	
	public boolean login(User user) {
		if ("admin".equals(user.getUsername()) && "test123".equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
}
