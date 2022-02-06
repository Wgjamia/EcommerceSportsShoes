package ly.algjamia.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ly.algjamia.model.AddToCart;
import ly.algjamia.repository.AddToCartRepository;



@Service
public class AddToCardServiceImp implements AddToCardService {
	@Autowired
	AddToCartRepository addToCartRepository;

	@Override
	public BigDecimal getSumOfPriceByUserId(Long userId) {
		return addToCartRepository.getSumOfPriceByUserId(userId);
	}

	@Override
	public List<AddToCart> findAllAddToCartByUserId(Long userId) {
		return addToCartRepository.findAllAddToCartByUserId(userId);
	}

	@Override
	public void saveAddToChard(AddToCart addToCart) {
		addToCartRepository.save(addToCart);
		
	}

	@Override
	public void DeleteAllAddToCartByUserId(Long userId) {
		addToCartRepository.DeleteAllAddToCartByUserId(userId);
		
	}

	@Override
	public void DeleteAddToCardById(Long id) {
		addToCartRepository.deleteById(id);
		
	}

	

	

	

	

}