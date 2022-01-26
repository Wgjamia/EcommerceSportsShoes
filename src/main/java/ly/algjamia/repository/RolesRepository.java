package ly.algjamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ly.algjamia.model.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long>{
	
	@Query(nativeQuery=true, value="SELECT r.* FROM roles r WHERE r.name like %:keyword%")
	public List<Roles> findAll(@Param("keyword") String keyword);
	
	@Query(nativeQuery=true, value="SELECT r.* FROM roles r")
	public List<Roles> findAll();
	
	@Query(nativeQuery=true, value="SELECT r.* FROM roles r where r.name=:role")
	public Roles findByRole(@Param("role") String role);
}