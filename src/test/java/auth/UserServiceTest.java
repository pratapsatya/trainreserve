package auth;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.service.UserService;

import junit.framework.Assert;
@SuppressWarnings("deprecation")
@Transactional
public class UserServiceTest extends AbstractTest {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepo;
	
	@Test
    public void testGetByUsername() throws Exception {

        String username="lahari";
        User entity = userService.findByUsername(username);
Assert.assertNotNull("failure- expected entitiy", entity);
Assert.assertEquals("expected attribute string doesnot match","lahari", entity.getUsername());
   
}
	@Test
    public void saveUser() throws Exception {
		User user=new User("testuser");
		
        userRepo.save(user);
		
Assert.assertNotNull("failure- expected entitiy", userService.findByUsername("testuser"));
Assert.assertEquals("expected attribute string doesnot match","testuser", user.getUsername());
   
}
	

}