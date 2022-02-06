package ly.algjamia.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ly.algjamia.model.Category;
import ly.algjamia.model.ShoeProduct;
import ly.algjamia.model.SizeShoe;
import ly.algjamia.services.CategoryService;
import ly.algjamia.services.ShoeProductService;
import ly.algjamia.services.SizeShoeService;



@Controller
@RequestMapping(value="/admin/products")
public class ShoeProductController {
	
	@Autowired
	ShoeProductService shoeProductService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SizeShoeService sizeShoeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewShoeProductList(Model model, @Param("Keyword") String Keyword) {
		List<ShoeProduct>  listShoeProduct = shoeProductService.getAllShoeProduct(Keyword);
		model.addAttribute("listShoeProduct",listShoeProduct);
		model.addAttribute("Keyword", Keyword);
		return "product_list";
	}
	
	@RequestMapping(value = "/ShowFormProduct", method = RequestMethod.GET)
	public String ShowFormProduct(Model model) {
		List<Category> listCategory = categoryService.getAllCategories("");
		List<SizeShoe> listSizeShoes = sizeShoeService.getAllSizeShoe("");
		model.addAttribute("listSizeShoes", listSizeShoes);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("product", new ShoeProduct());
		return "product_form";
	}
	
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public String AddCategory(@ModelAttribute("product") ShoeProduct shoeProduct
			 ,@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		shoeProduct.setpPhoto(fileName);
		ShoeProduct saveShoeProduct = shoeProductService.addShoeProduct(shoeProduct);
		
		String uploadDir = "./product_images/" + saveShoeProduct.getPid();
		Path uploadpath = Paths.get(uploadDir);
		if(!Files.exists(uploadpath)) {
			Files.createDirectories(uploadpath);
		}
		
		try(InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadpath.resolve(fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		}catch (IOException e) {
			throw new IOException("Could not save uploaded file "+fileName);
		}
		
		return "redirect:/admin/products/list";
	}
	
	@RequestMapping(value = "/ShowFormProductUpdate/{pid}", method = RequestMethod.GET)
	public String ShowFormProductUpdate(@PathVariable(value = "pid") Long pid, Model model) {
		ShoeProduct shoeProduct = shoeProductService.getShoeProductById(pid);
		List<Category> listCategory = categoryService.getAllCategories("");
		List<SizeShoe> listSizeShoes = sizeShoeService.getAllSizeShoe("");
		model.addAttribute("listSizeShoes", listSizeShoes);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("product", shoeProduct);
		return "product_form_update";
	}
	
	@RequestMapping(value = "/DeleteProduct/{pid}", method = RequestMethod.GET)
	public String DeleteProduct(@PathVariable(value = "pid") Long pid) {
		 shoeProductService.deleteShoeProduct(pid);
		return "redirect:/admin/products/list";
	}
}
