package ly.algjamia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ly.algjamia.model.Category;
import ly.algjamia.services.CategoryService;



@Controller
@RequestMapping(value="/admin/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewCategoryList(Model model, @Param("Keyword") String Keyword) {
		List<Category>  listCategory = categoryService.getAllCategories(Keyword);
		model.addAttribute("listCategory",listCategory);
		model.addAttribute("Keyword", Keyword);
		return "category_list";
	}
	
	@RequestMapping(value = "/ShowFormCategory", method = RequestMethod.GET)
	public String ShowFormCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category_form";
	}
	
	@RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	public String AddCategory(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/category/list";
	}
	
	@RequestMapping(value = "/ShowFormCategoryUpdate/{id}", method = RequestMethod.GET)
	public String ShowFormCategoryUpdate(@PathVariable(value = "id") Long id, Model model) {
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "category_form_update";
	}
	
	@RequestMapping(value = "/DeleteCategory/{id}", method = RequestMethod.GET)
	public String DeleteCategory(@PathVariable(value = "id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/category/list";
	}
}
