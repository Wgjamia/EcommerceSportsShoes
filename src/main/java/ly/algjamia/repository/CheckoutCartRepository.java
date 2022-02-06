package ly.algjamia.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ly.algjamia.model.CheckoutCart;

@Repository
public interface CheckoutCartRepository extends CrudRepository<CheckoutCart, Long>{
	@Query(nativeQuery=true, value="SELECT count(a.id) FROM add_to_cart a where a.user_id= :userId")
	public BigDecimal getCountOfProductByUserId(@Param("userId") Long userId);

	
}
