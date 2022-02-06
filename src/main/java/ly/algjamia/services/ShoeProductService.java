package ly.algjamia.services;

import java.util.List;
import ly.algjamia.model.ShoeProduct;


public interface ShoeProductService {
	public List<ShoeProduct> getAllShoeProduct(String Keyword);

	public ShoeProduct getShoeProductById(Long id);
	
	public ShoeProduct addShoeProduct(ShoeProduct shoeProduct);
	
	public void deleteShoeProduct(Long id);
	
	public ShoeProduct findByShoeProductName(String productName);

}
