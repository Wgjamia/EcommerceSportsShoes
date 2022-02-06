package ly.algjamia.services;

import java.util.List;
import ly.algjamia.model.Category;


public interface CategoryService {
	public List<Category> getAllCategories(String Keyword);

	public Category getCategoryById(Long id);
	
	public void addCategory(Category category);
	
	public void deleteCategory(Long id);
	
	public Category findByCategory(String nameOfCategory);

}
