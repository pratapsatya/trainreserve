package auth;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Trains.auth.model.User;
import com.Trains.auth.repository.UserRepository;
import com.Trains.auth.service.UserService;

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
User user=new User("testuser");
		
        userRepo.save(user);
        String username="testuser";
        User entity = userService.findByUsername(username);
Assert.assertNotNull("failure- expected entitiy", entity);
Assert.assertEquals("expected attribute string doesnot match","testuser", entity.getUsername());
   
}
	
	

}
