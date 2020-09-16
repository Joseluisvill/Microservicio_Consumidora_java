/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumidora.controllers;

import com.jose.consumidora.entity.Computadora;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jose Luis
 */
@Named(value = "computadoraController")
@SessionScoped
public class ComputadoraController implements Serializable {
    private String valor;
    final String URL="http://127.0.0.1:8080/clase1/resources/sistemas";
    private int ejecuciones;
    Computadora computador;
    
    public String getValor() {
        return valor;
    }

    /**
     * Creates a new instance of ComputadoraController
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    public Computadora getComputador() {
        return computador;
    }

    public void setComputador(Computadora computador) {
        this.computador = computador;
    }

    public ComputadoraController() {
    }
    @PostConstruct
    public void init()
    {
        valor="Comienzo";
        ejecuciones=0;
        computador= new Computadora();
    }
    public String leerBuenosDias()
    {  
        valor= preparar()
                .path("/saludo")
                .request()
                .get(String.class)
                +ejecuciones
                ;
        ejecuciones++;
        System.out.println("valor"+valor);
        return "";
    }
    public String leerComputadora()
    {  
        computador= preparar()
                .path("/computadora")
                .request(MediaType.APPLICATION_JSON)
                .get(Computadora.class);
        System.out.println("valor"+computador.getModelo());
        return "";
    }
    public String mundi()
    {
        if(true)
        {
            return "";
        }
        return "";
    }
    public Boolean isLeido()
    {
        return true;
    }
    
    protected WebTarget preparar()
    {
        return ClientBuilder.newClient().target(URL);
    }
}
