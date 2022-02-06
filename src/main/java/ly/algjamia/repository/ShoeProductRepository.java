package ly.algjamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ly.algjamia.model.ShoeProduct;


@Repository
public interface ShoeProductRepository extends CrudRepository<ShoeProduct,Long> {
	
	@Query(nativeQuery=true, value="SELECT p.* FROM shoe_product p WHERE p.product_name like %:keyword%")
	public List<ShoeProduct> findByLikeShoeProduct(@Param("keyword") String keyword);
	
	@Query(nativeQuery=true, value="SELECT p.* FROM shoe_product p WHERE p.product_name=:productName")
	public ShoeProduct findBShoeProductName(@Param("productName") String productName);


}
