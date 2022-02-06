package ly.algjamia.services;

import java.math.BigDecimal;
import java.util.List;
import ly.algjamia.model.AddToCart;

public interface AddToCardService {
	
	public BigDecimal getSumOfPriceByUserId(Long userId);

	public  List<AddToCart> findAllAddToCartByUserId(Long userId);
	
	public void saveAddToChard(AddToCart addToCart);
	
	public void DeleteAllAddToCartByUserId(Long userId);
	
	public void DeleteAddToCardById(Long id);
	


}
