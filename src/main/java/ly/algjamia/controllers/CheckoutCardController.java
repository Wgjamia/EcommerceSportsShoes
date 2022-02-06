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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ly.algjamia.model.AddToCart;
import ly.algjamia.model.CheckoutCart;
import ly.algjamia.model.ShoeProduct;
import ly.algjamia.model.SizeShoe;
import ly.algjamia.model.Users;
import ly.algjamia.services.AddToCardService;
import ly.algjamia.services.CheckoutCardService;
import ly.algjamia.services.ShoeProductService;
import ly.algjamia.services.SizeShoeService;
import ly.algjamia.services.UserService;



@Controller
@RequestMapping(value="/users/checkoutCard")
public class CheckoutCardController {
	
	@Autowired
	CheckoutCardService checkoutCardService;

	@Autowired
	AddToCardService addToCardService;
	@Autowired
	UserService userService;
	
	@Autowired
	ShoeProductService shoeProductService;

	@Autowired
	SizeShoeService sizeShoeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewCheckoutCardList(Model model, @Param("userId") Long userId
			,HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		List<AddToCart>  listAddToCard = addToCardService.findAllAddToCartByUserId(users.getId());
		model.addAttribute("listAddToCard",listAddToCard);
		BigDecimal countOfProudct = checkoutCardService.getCountOfProductByUserId(users.getId());
		model.addAttribute("countOfProudct", countOfProudct);
		BigDecimal sumOfPrice = addToCardService.getSumOfPriceByUserId(users.getId());
		model.addAttribute("sumOfPrice", sumOfPrice);
		List<ShoeProduct>  shoeProducts = shoeProductService.getAllShoeProduct("");
		model.addAttribute("shoeProducts", shoeProducts);
		List<SizeShoe> listSizeShoes = sizeShoeService.getAllSizeShoe("");
		model.addAttribute("listSizeShoes", listSizeShoes);
		return "payment_form";
	}
	
	@RequestMapping(value = "/SaveCheckoutCard", method = RequestMethod.POST)
	public String SaveAddToCard(@ModelAttribute("checkoutCart") CheckoutCart checkoutCart
					,HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		List<AddToCart> addToCart = addToCardService.findAllAddToCartByUserId(users.getId());
		
		for(AddToCart listaddtchar : addToCart) {
			checkoutCart.setOrderDate(new Date());
			checkoutCart.setOrderId(listaddtchar.getId().toString());
			checkoutCart.setDeliveryAddress(users.getUserProfile().getAddress());
			checkoutCart.setPaymentType("VISA");
			checkoutCart.setPrice(listaddtchar.getPrice());
			checkoutCart.setQuantity(listaddtchar.getQuantity());
			checkoutCart.setShoeProduct(listaddtchar.getShoeProduct());
			checkoutCart.setUsers(users);
			checkoutCardService.saveCheckoutCard(checkoutCart);
			addToCardService.DeleteAddToCardById(listaddtchar.getId());
		}
		
		return "redirect:/users/products/list";
	}

}
