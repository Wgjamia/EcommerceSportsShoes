package ly.algjamia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ly.algjamia.model.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(nativeQuery=true, value="SELECT u.* FROM users u where u.username = :username ")
	public Users findByUsername(@Param("username") String username);
	
	@Query(nativeQuery=true, value="SELECT u.id FROM users u  where u.username = :username and u.enabled=1 ")
	public Long GetIdByUsername(@Param("username") String username);
	
	@Query(nativeQuery=true, value="SELECT u.* FROM users u WHERE u.username like %:username%")
	public List<Users> findAll(@Param("username") String username);
	
	@Query(value= "select u.password from users u where u.id=:id",nativeQuery = true)
	public String getPassOfUser(@Param("id") Long id);
}
