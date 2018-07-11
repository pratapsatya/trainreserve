package com.hellokoding.auth.web;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.ticketService;
import com.hellokoding.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);	 
 	 
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private ticketService tkService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	//logger.debug("Registration called");
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	//logger.debug("Registration called");
    	userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	//logger.debug("Registration called");
    	if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	//logger.debug("Registration called");
    	return "Welcome";
    }
    @RequestMapping(value = {"/trains"}, method = RequestMethod.POST)
    public String Trains(Model model) {
    	//logger.debug("Registration called");
        return "Trainlist";
    }
    @RequestMapping(value = {"/payment"}, method = RequestMethod.GET)
    public String Payment(Model model) {
    	//logger.debug("Registration called");
        return "payment";
    }
    @RequestMapping(value = {"/ticketconfirmation"}, method = RequestMethod.POST)
    public String TicketConfirmation(Model model,@RequestParam(name="username") String name,@RequestParam(name="nooftickets") String tickets,@RequestParam(name="trainname") String tname) {
    	//logger.debug("Registration called");
    	tkService.insertData(name,tickets,tname);
        return "ticketconfirmation";
    }
    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String History(Model model) {
    	//logger.debug("Registration called");
        return "history";
    }
    
}
