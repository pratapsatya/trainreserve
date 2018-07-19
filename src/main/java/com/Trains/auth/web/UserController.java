package com.Trains.auth.web;

import com.Trains.auth.model.Tickets;
import com.Trains.auth.model.Trains;
import com.Trains.auth.model.User;
import com.Trains.auth.service.SecurityService;
import com.Trains.auth.service.TicketService;
import com.Trains.auth.service.TrainService;
import com.Trains.auth.service.UserService;
import com.Trains.auth.validator.UserValidator;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
 * @author laharipratap
 *
 */
@Controller
public class UserController {
		 
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private TicketService tkService;
    @Autowired 
	private TrainService trainService;
    
    private String debug="debug level log";
    private String info="info level log";
    private String error="error level log";

    /**
     * 
     * @param model holds the model object
     * @return this controller returns the registration page
     */
   
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	
        model.addAttribute("userForm", new User());
        log.debug(debug);
        log.info(info);
        log.error(error);

        return "registration";
    }

    /**
     * This method is responsible for handling the user registration
     * @param userForm consists of data entered by the user
     * @param bindingResult has the errors resulted due to information submitted by the user
     * @param model holds the model object
     * @return returns registration view with message whether user is registered successfully or not
     */

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	
    	userValidator.validate(userForm, bindingResult);
    	log.debug(debug);
        log.info(info);
        log.error(error);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	
    	log.debug(debug);
        log.info(info);
        log.error(error);
    	if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	log.debug(debug);
        log.info(info);
        log.error(error);
    	return "Welcome";
    }
    /**
     * This is used to show the trains list
     * @param source is the place from which journey begins
     * @param destination is the place where the journey ends
     * @param dae is the date of journey
     * @return returns the jsp page where the list of trains will be displayed
     * */
    @RequestMapping(value = {"/trains"}, method = RequestMethod.POST)
    public String trains(Model model,@RequestParam(name="source") String source,@RequestParam(name="destiny") String destination,@RequestParam(name="date") String date) {
    	
    	List<Trains> trainlist=trainService.getTrains(source, destination);
    	model.addAttribute("trains",trainlist);
        return "Trainlist";
    }
    @RequestMapping(value = {"/payment"})
    public String payment(Model model) {
    	
        return "payment";
    }
    /**
     * This is used to display the ticket 
     * @param principal is the user logged in
     * @param tickets is the number of tickets booked by the user
     * @param tname is the train name 
     * @param date is the date of journey
     * @return returns the jsp page where the ticket will be displayed
     * */
    @RequestMapping(value = {"/ticketconfirmation"}, method = RequestMethod.POST)
    public String ticketConfirmation(Model model,Principal p,@RequestParam(name="nooftickets") String tickets,@RequestParam(name="trainname") String tname,@RequestParam(name="date") String date) throws ParseException {
    	String name=p.getName();
    	/*Tickets t=new Tickets();
		Date d=new Date();
		t.setDate(date);
		t.setTickets(tickets);
		t.setTrainname(tname);
		t.setUname(name);
		tkService.save(t);*/
        
    	tkService.insertData(name,tickets,tname,date);
        return "ticketconfirmation";
    }
    /**
     * This is used to display the list of tickets booked by the user 
     * @param principal is the user logged in
     * @return returns the jsp page that contains the list of tickets booked by the user
     * */
    @RequestMapping(value = {"/history"})
    public String history(Model model,Principal p) {
    	
    	List<Tickets> list=tkService.findByName(p.getName());
    	model.addAttribute("list", list);
        return "history";
    }
    

    
}
