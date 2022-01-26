package ly.algjamia.repostoryroles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ly.algjamia.model.Roles;
import ly.algjamia.repository.RolesRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RolesRepostoryTestInsert {
	@Autowired
	RolesRepository rolesRepository;
	
	@Test
	public void testInsertRoles() {
		Roles roleAdmin = new Roles("ADMIN_USER");
		Roles roleSuberAdmin = new Roles("SUPER_USER");
		Roles roleSite = new Roles("SITE_USER");
		
		List<Roles> roles_list = new ArrayList<Roles>(); 
		roles_list.add(roleAdmin);
		roles_list.add(roleSuberAdmin);
		roles_list.add(roleSite);
		
		rolesRepository.saveAll(roles_list);
		
		List<Roles> listRoles = rolesRepository.findAll();
		assertThat(listRoles.size()).isEqualTo(3);
	}

}
