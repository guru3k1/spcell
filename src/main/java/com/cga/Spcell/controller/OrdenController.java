package com.cga.Spcell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cga.Spcell.service.OrdenService;

@Controller
@RequestMapping("/v1")
public class OrdenController {

	@Autowired
	OrdenService _ordenService;
}
