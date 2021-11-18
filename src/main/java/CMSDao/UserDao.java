package CMSDao;

import CMSModel.UserModel;

public interface UserDao {
	void insert(UserModel user);
	
	void delete(int id);
	
	UserModel getusername(String name);
	
	UserModel getbyid(int id);
	
	
}
