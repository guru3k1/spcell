package com.cga.Spcell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@Controller
public class MainController {
	@RequestMapping("/")
	@ResponseBody
	public String index(){
		String response = "Bienvenido a SPCELL";
		
		return response;
	}
}
