/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumidora.controllers;

import com.jose.computadoraclient.entity.Computadora;
import com.jose.computadoraclient.services.ComputadoraServices;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose Luis
 */
@Named(value = "computadoraController")
@SessionScoped
public class ComputadoraController implements Serializable {

    private String valor;
    private String ejecuciones;
    Computadora computador;
    @Inject
    ComputadoraServices computadoraServices;
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

    //public ComputadoraController() {
    //}
    
    @PostConstruct
    public void init()
    {
        valor="Comienzo";
        //ejecuciones=0;
        computador=new Computadora();
    }
    /*public String leerBuenosDias()
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
    }*/
    public String leerComputadora()
    {  
        computador= computadoraServices.buscarcomputadora();
        System.out.println("valor"+computador.getModelo());
        return "";
    }
    /*public String crearcomputadora()
    {//crear computadora lo hice yo
        Computadora computador= new Computadora("4222","DELL","HERRERA","INTEL",120.0,8);
        Response respuesta = preparar()
                .path("/crearcomputadora")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(computador, MediaType.APPLICATION_JSON));
       /* if(respuesta.getStatus()==400 || respuesta.getStatus()==401)
        {
            
        }
        return "";
    }*/
    public String buscar()
    {
        //computador=computadoraServices.BusquedaSerial(computador.getSerial());
        computador= computadoraServices.buscarcomputadora();
        
        return"";
    }
    public String crearComputadora()
    {if(computadoraServices.crearComputadora(computador))
            {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Se creo Correctamente") );
            }
            else
            {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("NO se creo Correctamente") );
            }
            return "";
    }
    public String buscarcomputadora()
    {
        computador= computadoraServices.buscarcomputadora();
        /*String id=computador.getSerial().toString();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Marca",  "Your message: " + id) );
        computador= preparar()
                .path("/buscarcomputadora/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Computadora.class);
        System.out.println("valor"+computador.getSerial());*/
        
        return "";
    }
    /*public String buscarcomputadoraquery()
    {
        String id=computador.getSerial().toString();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Marca",  "Your message: " + id) );
        computador= preparar()
                .path("/computadoraunica")
                .queryParam("id", id)
                .request()
                .get(Computadora.class);
        System.out.println("valor"+computador.getSerial());
        
        return "";
    }*/
    /*public String mostrarcomputadora()
    {
        computador=preparar()
                .path("/computadoralista")
                .request(MediaType.APPLICATION_JSON)
                .get(Computadora.class);
        System.out.println("Las computadoras creada son "+computador.getModelo());
        return "";
    }*/
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
    
    
}
