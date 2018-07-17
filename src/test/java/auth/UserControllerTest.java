package auth;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;



import javax.servlet.Filter;


@WithMockUser
@Transactional
public class UserControllerTest extends AbstractControllerTest {
	


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Autowired
    private Filter springSecurityFilterChain;
    @Before
    public void setUp() {
      mockMvc = MockMvcBuilders
              .webAppContextSetup(context)
              .addFilters(springSecurityFilterChain)
              .defaultRequest(get("/").with(testSecurityContext()))
              .build();
      //this.authentication = new UsernamePasswordAuthenticationToken("lahari", "Satya@977");
    }

    @Test
    public void testLogin() throws Exception {

        String uri = "/login";
     
        
        
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
        		            .andExpect(status().isOk())
        		            .andExpect(view().name("login"));
        


    }
    @Test
	public void testRegistrationPageLoading() throws Exception 
	{
    	mockMvc.perform(MockMvcRequestBuilders.get("/registration"))
		                  .andExpect(status().isOk())
		                 
		                  .andExpect(view().name("registration"));
	}
   
 
      @Test
      public void invalidLoginDenied() throws Exception {
        String loginErrorUrl = "/login?error";
        mockMvc
                .perform(formLogin().password("invalid"))
                .andExpect(redirectedUrl(loginErrorUrl))
                .andExpect(unauthenticated());

     
    } 
    
      @Test
    	public void testLoginSuccess() throws Exception {
    	  mockMvc
      .perform(formLogin().user("lahari").password("Satya@977"))
      .andExpect(authenticated());
      
      }
     
    	  @Test
    	  	public void testUserLoginSuccess() throws Exception {
    	    	mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/login")
    	  	            .param("username", "lahari")
    	  	            .param("password", "Satya@977"))
    	  		        .andDo(print())
    	  	            .andExpect(redirectedUrl("/"));	
    	  	    		 
    	      } 
    	  
    	  
    		  @Test
    		  
    		  	public void testgetwelcomeSuccess() throws Exception {
    		  	  mockMvc.perform(get("/payment"))
    		     .andExpect(status().isOk())
    		    .andDo(print())
    		       		    .andExpect(view().name("payment"));
    		    
    		    }   

    	



}