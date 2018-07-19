package com.Trains.auth.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author laharipratap
 *
 */
@Controller
public class MyErrorController implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError() {
       
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}

