package ly.algjamia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ly.algjamia.model.ShoeProduct;
import ly.algjamia.repository.ShoeProductRepository;


@Service
public class ShoeProductServiceImp implements ShoeProductService {

	@Autowired
	ShoeProductRepository shoeProductRepository;
	
	@Override
	public List<ShoeProduct> getAllShoeProduct(String Keyword) {
		if (Keyword != null) {
			return shoeProductRepository.findByLikeShoeProduct(Keyword);
		}
			return (List<ShoeProduct>) shoeProductRepository.findAll();
		
	}

	@Override
	public ShoeProduct getShoeProductById(Long id) {
		Optional<ShoeProduct> optional = shoeProductRepository.findById(id);
		ShoeProduct shoeProduct = null;
		if (optional.isPresent()) {
			shoeProduct = optional.get();
		} else {
			throw new RuntimeException("Category not found by ID " + id);
		}
		return  shoeProduct;
	}

	@Override
	public ShoeProduct  addShoeProduct(ShoeProduct shoeProduct) {
		shoeProductRepository.save(shoeProduct);
		return shoeProduct;
	}

	@Override
	public void deleteShoeProduct(Long id) {
		shoeProductRepository.deleteById(id);
		
	}

	@Override
	public ShoeProduct findByShoeProductName(String productName) {
		return shoeProductRepository.findBShoeProductName(productName);
	}


}