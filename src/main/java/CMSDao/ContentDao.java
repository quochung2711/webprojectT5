package CMSDao;

import java.util.List;

import CMSModel.ContentModel;

public interface ContentDao {
	void insert(ContentModel content);
	
	void delete(int id);
	
	List<ContentModel> getall();
}
