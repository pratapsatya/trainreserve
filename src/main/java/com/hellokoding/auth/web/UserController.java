package com.hellokoding.auth.web;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.Tickets;

import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.TrainService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.TicketService;
import com.hellokoding.auth.validator.UserValidator;

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
import com.hellokoding.auth.model.Trains;

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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	
        model.addAttribute("userForm", new User());
        log.debug("debug level log");
        log.info("info level log");
        log.error("error level log");

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	
    	userValidator.validate(userForm, bindingResult);
    	 log.debug("debug level log");
    	    log.info("info level log");
    	    log.error("error level log");

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	
    	 log.debug("debug level log");
    	    log.info("info level log");
    	    log.error("error level log");
    	if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	 log.debug("debug level log");
    	    log.info("info level log");
    	    log.error("error level log");
    	
    	return "Welcome";
    }
    @RequestMapping(value = {"/trains"}, method = RequestMethod.POST)
    public String trains(Model model,@RequestParam(name="source") String source,@RequestParam(name="destiny") String destination,@RequestParam(name="date") String date) {
    	
    	List<Trains> trainlist=trainService.getTrains(source, destination);
    	model.addAttribute("trains",trainlist);
        return "Trainlist";
    }
    @RequestMapping(value = {"/payment"}, method = RequestMethod.GET)
    public String payment(Model model) {
    	
        return "payment";
    }
    @RequestMapping(value = {"/ticketconfirmation"}, method = RequestMethod.POST)
    public String ticketConfirmation(Model model,Principal p,@RequestParam(name="nooftickets") String tickets,@RequestParam(name="trainname") String tname,@RequestParam(name="date") String date) throws ParseException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date startDate = sdf.parse(date);
        String name=p.getName();
    	tkService.insertData(name,tickets,tname,startDate);
        return "ticketconfirmation";
    }
    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String history(Model model,Principal p) {
    	
    	List<Tickets> list=tkService.findByName(p.getName());
    	model.addAttribute("list", list);
        return "history";
    }
    

    
}
