package ly.algjamia.repostoryroles;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ly.algjamia.model.Roles;
import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;
import ly.algjamia.repository.RolesRepository;
import ly.algjamia.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserProfileRepostoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RolesRepository rolesRepository;
	
	@Autowired
	
	
	@Test
	public void testInsertUserProfileAdmin() {
		/*
		 * UserProfile userspProfile = new UserProfile();
		 * userspProfile.setAddress("Sooq"); userspProfile.setCity("Tripoli");
		 * userspProfile.setCountry("Libya"); userspProfile.setJob("Sales");
		 * userspProfile.setJob("Sales");
		 * 
		 * Roles roleAdmin = rolesRepository.findByRole("ADMIN_USER");
		 * users.addRoles(roleAdmin); Users svaeUser = userRepository.save(users);
		 * assertThat(svaeUser.getRoles().size()).isEqualTo(1);
		 */
	}

}
