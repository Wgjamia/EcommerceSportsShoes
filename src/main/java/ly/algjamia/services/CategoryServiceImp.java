package ly.algjamia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ly.algjamia.model.Category;
import ly.algjamia.repository.CategoryRepository;


@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> getAllCategories(String Keyword) {
		if (Keyword != null) {
			return categoryRepository.findByLikeCategory(Keyword);
		}
			return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		Category category = null;
		if (optional.isPresent()) {
			category = optional.get();
		} else {
			throw new RuntimeException("Category not found by ID " + id);
		}
		return  category;
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Category findByCategory(String nameOfCategory) {
		return categoryRepository.findBCategoryName(nameOfCategory);
	}

	

	

	

}