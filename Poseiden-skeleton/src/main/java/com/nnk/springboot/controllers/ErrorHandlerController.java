package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlerController implements ErrorController{
	
	private static Logger log = LoggerFactory.getLogger(ErrorHandlerController.class);
	
	@Override
	@RequestMapping("/error")
	@ResponseBody
	public String getErrorPath() {
    	log.info("GET Request to /error");

        return "Server internal error";
	}
}
