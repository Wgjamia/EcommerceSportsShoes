package ly.algjamia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ly.algjamia.model.AddToCart;


@Repository
public interface AddToCartRepository extends CrudRepository<AddToCart, Long>{
	
	@Query(nativeQuery=true, value="SELECT sum(a.price) FROM add_to_cart a where a.user_id= :userId")
	public BigDecimal getSumOfPriceByUserId(@Param("userId") Long userId);

	@Query(nativeQuery=true, value="SELECT a.* FROM add_to_cart a where a.user_id= :userId")
 	public List<AddToCart> findAllAddToCartByUserId(@Param("userId") Long userId);

	@Query(nativeQuery=true, value="delete FROM add_to_cart  where user_id= :userId")
 	public void DeleteAllAddToCartByUserId(@Param("userId") Long userId);
	
}
