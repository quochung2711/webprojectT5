package pj.webt5.dao;

import pj.webt5.model.UserModel;

public interface UserDao {
	void insert(UserModel user);
	
	void delete(int id);
	
	UserModel getusername(String name);
	
	UserModel getbyid(int id);
	
	
}
