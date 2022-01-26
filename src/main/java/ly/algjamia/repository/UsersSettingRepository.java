package ly.algjamia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ly.algjamia.model.Users;
import ly.algjamia.model.UsersSetting;

public interface UsersSettingRepository extends CrudRepository<UsersSetting, Long> {
	
	@Query(value= "select s.* from users u  left JOIN users_setting s on u.id=s.user_id where u.id=:userid",nativeQuery = true)
	public UsersSetting getUserSetting(@Param("userid") Long id);
	
	@Query(value= "select u.* from users u where u.id=:userid",nativeQuery = true)
	public Users getUsers(@Param("userid") Long id);
	

}
