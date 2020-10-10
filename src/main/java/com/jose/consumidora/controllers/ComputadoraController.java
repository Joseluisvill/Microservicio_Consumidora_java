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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    final String URL="http://127.0.0.1:8081/clase1/resources/sistemas";
    private int ejecuciones;
    Computadora computador;
    
    @Inject
    ComputadoraFacade computadoraFacade;
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
        ejecuciones=0;
        computador=new Computadora();
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
    public String crearComputadora()
    {
        try{
        
            Client client=ClientBuilder.newClient();
            WebTarget preparo=client.target(URL+"/crearcomputadora");
            Invocation.Builder invocationBuiler=preparo
                    .request(MediaType.APPLICATION_JSON);
            Response respuesta=invocationBuiler
                    .post(Entity.entity(computador,MediaType.APPLICATION_JSON));
        }catch(Exception e)
        {
            System.out.println("Error");
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful"));
        return "";
    }
    public String buscarComputadora()
    {
        /*computador= preparar()
                .path("/buscarcomputadora")
                .request(MediaType.APPLICATION_JSON)
                .get(Computadora.class);*/
        System.out.println("valor"+computador.getSerial());
        //FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage("Marca",  "Your message: " + computador.getMarca()) );
        return "";
    }
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
    
    protected WebTarget preparar()
    {
        return ClientBuilder.newClient().target(URL);
    }
}
