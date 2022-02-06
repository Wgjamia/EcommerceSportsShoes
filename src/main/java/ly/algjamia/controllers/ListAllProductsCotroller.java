package ly.algjamia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ly.algjamia.model.ShoeProduct;
import ly.algjamia.services.CategoryService;
import ly.algjamia.services.ShoeProductService;

@Controller
@RequestMapping(value="/users/products")
public class ListAllProductsCotroller {
	@Autowired
	ShoeProductService shoeProductService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewShoeProductList(Model model, @Param("Keyword") String Keyword) {
		List<ShoeProduct>  listShoeProduct = shoeProductService.getAllShoeProduct(Keyword);
		model.addAttribute("listShoeProduct",listShoeProduct);
		model.addAttribute("Keyword", Keyword);
		return "index";
	}

}
