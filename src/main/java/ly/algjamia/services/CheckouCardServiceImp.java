package ly.algjamia.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ly.algjamia.model.CheckoutCart;
import ly.algjamia.repository.CheckoutCartRepository;



@Service
public class CheckouCardServiceImp implements CheckoutCardService {
	
	@Autowired
	CheckoutCartRepository checkoutCartRepository;

	@Override
	public BigDecimal getCountOfProductByUserId(Long userId) {
		return checkoutCartRepository.getCountOfProductByUserId(userId);
	}

	@Override
	public void saveCheckoutCard(CheckoutCart checkoutCart) {
		checkoutCartRepository.save(checkoutCart);
		
	}


	

	

	

	

}