package auth;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
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

import com.Trains.auth.model.Tickets;
import com.Trains.auth.model.Trains;
import com.Trains.auth.model.User;
import com.Trains.auth.service.TicketService;
import com.Trains.auth.service.TrainService;
import com.Trains.auth.service.UserService;

import javax.servlet.Filter;


@WithMockUser
@Transactional
public class UserControllerTest extends AbstractControllerTest {
	
	@Autowired 
	private TrainService trainService;
	@Autowired 
	private UserService userService;
	@Autowired
    private TicketService tkService;
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
    	  User u=new User();
    	  u.setUsername("laharip");
    	  u.setPassword("Satya@977");
    	  userService.save(u);
    	  
    	  mockMvc
      .perform(formLogin().user("laharip").password("Satya@977"))
      .andExpect(authenticated());
      
      }
     
    	  @Test
    	  	public void testUserLoginSuccess() throws Exception {
    	    	
    		  User u=new User();
        	  u.setUsername("laharip");
        	  u.setPassword("Satya@977");
        	  userService.save(u);
        	  System.out.println("................."+u.getPassword());
    		  mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/login")
    	  	            .param("username", u.getUsername())
    	  	            .param("password", "Satya@977"))
    	  		        .andDo(print())
    	  	            .andExpect(redirectedUrl("/"));	
    	  	    		 
    	      } 
    	  
    	  
    		  @Test
      		  	public void testgetwelcomeSuccess() throws Exception {
    		  	  mockMvc.perform(get("/welcome"))
    		     .andExpect(status().isOk())
    		    .andDo(print())
    		       		    .andExpect(view().name("Welcome"));
    		    
    		    }   
    		  @Test
    		  	public void testgetpaymentSuccess() throws Exception {
  		  	  mockMvc.perform(get("/payment"))
  		     .andExpect(status().isOk())
  		    .andDo(print())
  		       		    .andExpect(view().name("payment"));
  		    
  		    }
    		  @Test
    		  	public void testgethistorySuccess() throws Exception {
    			  Tickets t=new Tickets();
      			Date d=new Date();
      			t.setDate(d);
      			t.setTickets("2");
      			t.setTrainname("hyderabadsuperfast");
      			t.setUname("lahari79");
      			tkService.save(t);
      			
    			  List<Tickets> list=tkService.findByName("lahari79");
    			  List<Tickets> list1=tkService.findByName("lahari98");
    			  System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"+list.toString());
  		  	  mockMvc.perform(get("/history"))
  		     .andExpect(status().isOk())
  		    .andDo(print())
  		       		    .andExpect(view().name("history"));
  		  	//Assert.assertNotNull("failure- expected entitiy", list);
  		  	assertFalse(list.isEmpty());
  		  assertTrue(list1.isEmpty());
  		    }   
    		  @Test
    		  	public void testgettrainsSuccess() throws Exception {
    			  
    			  List<Trains> trainlist=trainService.getTrains("vijayawada", "tirupathi");
  		  	  mockMvc.perform(post("/trains").param("source","vijayawada").param("destiny","tirupathi").param("date","2018-07-17"))
  		     .andExpect(status().isOk())
  		    		.andExpect(model().attribute("trains", trainlist))
  		    .andDo(print())
  		       		    .andExpect(view().name("Trainlist"));
  		    System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"+trainlist.toString());
  		  	 Assert.assertNotNull("failure- expected entitiy", trainlist);
  		    }   

    		  @Test
  		  	public void testgetticketConfirmSuccess() throws Exception {
    		  
    			Tickets t=new Tickets();
    			Date d=new Date();
    			t.setDate(d);
    			t.setTickets("2");
    			t.setTrainname("hyderabadsuperfast");
    			t.setUname("lahari79");
    			tkService.save(t);
    			
    			String name = t.getUname();
    			Assert.assertNotNull(name);
    			
    			List<Tickets> t1 = tkService.findByName(name);

    		        Assert.assertEquals("lahari79", t1.get(0).getUname());
    		        Assert.assertEquals("hyderabadsuperfast", t1.get(0).getTrainname());
    		        Assert.assertEquals("2",t1.get(0).getTickets());
    			
    			
    			
   		  	  mockMvc.perform(post("/ticketconfirmation").param("nooftickets","2").param("trainname","hyderabadsuperfast").param("date","2018-07-17"))
		     .andExpect(status().isOk())
		    				    .andDo(print())
		       		    .andExpect(view().name("ticketconfirmation"));
		  	
		    }   



}