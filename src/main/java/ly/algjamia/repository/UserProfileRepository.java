package ly.algjamia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;

public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {
	@Query(value= "select p.* from users u  left JOIN user_profiles p on u.id=p.user_id where u.id=:id",nativeQuery = true)
	public UserProfile getUserProfile(@Param("id") Long id);
	
	@Query(value= "select u.* from users u where u.id=:id",nativeQuery = true)
	public Users getUsers(@Param("id") Long id);
	
	
}