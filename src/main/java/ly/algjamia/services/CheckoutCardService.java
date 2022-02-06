package ly.algjamia.services;

import java.math.BigDecimal;
import ly.algjamia.model.CheckoutCart;

public interface CheckoutCardService {
	
	public BigDecimal getCountOfProductByUserId(Long userId);

	public void saveCheckoutCard(CheckoutCart checkoutCart);
	

}
