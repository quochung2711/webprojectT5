package pj.webt5.service.impl;

import pj.webt5.dao.UserDao;
import pj.webt5.dao.impl.UserDaoImpl;
import pj.webt5.model.UserModel;
import pj.webt5.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userdao = new UserDaoImpl();
	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getbyid(int id) {
		return userdao.getbyid(id);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = userdao.getusername(username);
		if(user != null && password.equals(user.getPassword()))
		{
			return user;
		}
		return null;
	}

}
