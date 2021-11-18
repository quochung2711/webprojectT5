package CMSService;

import java.util.List;

import CMSModel.ContentModel;

public interface ContentService {
	void insert(ContentModel content);
	
	void delete(int id);
	
	
	
	List<ContentModel> getall();
	
	List<ContentModel> search(String keyword);
}
