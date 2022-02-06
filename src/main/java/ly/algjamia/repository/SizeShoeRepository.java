package ly.algjamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ly.algjamia.model.SizeShoe;



@Repository
public interface SizeShoeRepository extends CrudRepository<SizeShoe,Long> {
	
	@Query(nativeQuery=true, value="SELECT s.* FROM size_shoe s WHERE s.size_name like %:keyword%")
	public List<SizeShoe> findByLikeSizeShoe(@Param("keyword") String keyword);
	
	@Query(nativeQuery=true, value="SELECT s.* FROM size_shoe s WHERE s.size_name= :sizeName")
	public SizeShoe findBySizeShoeName(@Param("sizeName") String sizeName);


}
