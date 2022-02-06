package ly.algjamia.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ly.algjamia.model.AddToCart;
import ly.algjamia.model.ShoeProduct;
import ly.algjamia.model.SizeShoe;
import ly.algjamia.model.Users;
import ly.algjamia.services.AddToCardService;
import ly.algjamia.services.ShoeProductService;
import ly.algjamia.services.SizeShoeService;
import ly.algjamia.services.UserService;



@Controller
@RequestMapping(value="/users/addToCard")
public class AddToCardController {
	
	@Autowired
	AddToCardService addToCardService;
	@Autowired
	UserService userService;
	
	@Autowired
	ShoeProductService shoeProductService;

	@Autowired
	SizeShoeService sizeShoeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewCategoryList(Model model, @Param("userId") Long userId
			,HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		List<AddToCart>  listAddToCard = addToCardService.findAllAddToCartByUserId(users.getId());
		model.addAttribute("listAddToCard",listAddToCard);
		BigDecimal sumOfPrice = addToCardService.getSumOfPriceByUserId(users.getId());
		model.addAttribute("sumOfPrice", sumOfPrice);
		List<ShoeProduct>  shoeProducts = shoeProductService.getAllShoeProduct("");
		
		model.addAttribute("shoeProducts", shoeProducts);
		List<SizeShoe> listSizeShoes = sizeShoeService.getAllSizeShoe("");
		model.addAttribute("listSizeShoes", listSizeShoes);
		return "shopping_form";
	}
	
	@RequestMapping(value = "/SaveAddToCard/{pid}", method = RequestMethod.GET)
	public String SaveAddToCard(@ModelAttribute("addToCard") AddToCart addToCart
			,@PathVariable(value = "pid") Long pid,
			HttpServletRequest request) {
		
		ShoeProduct shoeProduct = shoeProductService.getShoeProductById(pid);
		addToCart.setPrice(shoeProduct.getPrice());
		addToCart.setQuantity(1);
		addToCart.setAdded_date(new Date());
		addToCart.setShoeProduct(shoeProduct);
		String username=request.getUserPrincipal().getName();
		Users users = userService.findByUsername(username);
		addToCart.setUsers(users);
		addToCardService.saveAddToChard(addToCart);
		return "redirect:/users/addToCard/list";
	}
	@RequestMapping(value = "/updateAddToCard", method = RequestMethod.GET)
	public String updateAddToCard(@ModelAttribute("addToCard") AddToCart addToCart, Model model) {
		addToCardService.saveAddToChard(addToCart); 
		return "redirect:/users/addToCard/list";
	}
	@RequestMapping(value = "/DeleteAddToCard/{id}", method = RequestMethod.GET)
	public String DeleteCategory(@PathVariable(value = "id") Long id) {
		addToCardService.DeleteAddToCardById(id);
		return "redirect:/users/addToCard/list";
	}
}
