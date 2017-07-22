package com.cga.Spcell.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.cga.Spcell.model.Cliente;
import com.cga.Spcell.model.Marca;
import com.cga.Spcell.model.Modelo;
import com.cga.Spcell.model.Terminal;
import com.cga.Spcell.service.ClienteService;
import com.cga.Spcell.service.MarcaService;
import com.cga.Spcell.service.ModeloService;
import com.cga.Spcell.service.TerminalService;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class LayoutBackup {
/*
    @Autowired
    MarcaService _marcaService;
    @Autowired
    ModeloService _modeloService;
    @Autowired
    TerminalService _terminalService;
    @Autowired
    ClienteService _clienteService;

    Marca marca;
    Modelo modelo;
    final TextField numeroSerie = new TextField("Numero de Serie");
    final ComboBox<Marca> marcasList = new ComboBox<>("Marca");
    final ComboBox<Modelo> modelosList = new ComboBox<>("Modelo");
    final List <Modelo> losmodelos = _modeloService.findAllModelos();
    final Terminal terminal = new Terminal();;
    final Marca marca;
    final Modelo modelo;
    final Cliente cliente;
    cliente = _clienteService.findById(new Long(1));
    Button button = new Button("Guardar");
    button.addClickListener( event -> {
    	try{
    		if(numeroSerie.getValue()!=""){
            	
            	terminal.setNumero_serie(numeroSerie.getValue());
            	terminal.setCliente(cliente);
            	
            System.out.println("Marca " + terminal.getMarca().getMarca());
            System.out.println("Modelo " + terminal.getModelo());
            System.out.println("Numero de Serie " + terminal.getNumero_serie());
            
            System.out.println("Cliente " + terminal.getCliente());
            _terminalService.saveTerminal(terminal);
            }
    	}catch(Exception e){
    		System.out.println("Error "+e);
    	}
        
    });
    marcasList.setItems(_marcaService.findAllMarcas());
    marcasList.setItemCaptionGenerator(Marca::getMarca);
    marcasList.addSelectionListener(event ->{
    	terminal.setMarca(event.getSelectedItem().get());
    final List lms ;
    lms = losmodelos.stream()
            .filter(n-> 
            n.getMarca().getIdMarca()
            .equals(marcasList.getSelectedItem().get().getIdMarca()))
            .collect(Collectors.toList());
    modelosList.setItems(lms);
    });
    modelosList.addSelectionListener(event -> {
    	terminal.setModelo(event.getSelectedItem().get());
    });

    layout.addComponents(marcasList,modelosList,numeroSerie, button);
    
    setContent(layout);
*/
}
