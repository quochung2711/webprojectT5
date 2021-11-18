package pj.webt5.service;

import pj.webt5.model.UserModel;

public interface UserService {
	void insert(UserModel user);
	
	void delete(int id);
	
	UserModel login(String username, String password);
	
	UserModel getbyid(int id);
	
	
}
