package ly.algjamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ly.algjamia.model.Category;



@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
	
	@Query(nativeQuery=true, value="SELECT c.* FROM category c WHERE c.category_name like %:keyword%")
	public List<Category> findByLikeCategory(@Param("keyword") String keyword);
	
	@Query(nativeQuery=true, value="SELECT c.* FROM category c WHERE c.category_name= :categoryName")
	public Category findBCategoryName(@Param("categoryName") String categoryName);


}
