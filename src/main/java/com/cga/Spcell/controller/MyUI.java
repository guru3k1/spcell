package com.cga.Spcell.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;

import com.vaadin.ui.*;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import com.cga.Spcell.model.Cliente;
import com.cga.Spcell.model.Marca;
import com.cga.Spcell.model.Modelo;
import com.cga.Spcell.model.Terminal;
import com.cga.Spcell.service.ClienteService;
import com.cga.Spcell.service.MarcaService;
import com.cga.Spcell.service.ModeloService;
import com.cga.Spcell.service.TerminalService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;

@SpringUI
@Theme("mytheme")
public class MyUI extends UI {
	private VerticalLayout layout;
	@Override
    protected void init(VaadinRequest vaadinRequest) {

        setupLayout();
        addHeader();
        addMenu();
        addContainer();
        addFooter();

        
	}
	private void setupLayout(){
		layout = new VerticalLayout();
		layout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		setContent(layout);
	}
	private void addHeader(){

	}


	private void addMenu(){

	}
	private void addContainer(){

	}

	private void addFooter() {
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
