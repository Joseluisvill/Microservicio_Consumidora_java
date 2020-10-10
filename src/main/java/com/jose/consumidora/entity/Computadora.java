/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumidora.entity;


    public class Computadora
    {
        private String serial;
        private String marca;
        private String modelo;
        private String marcaProcesador;
        private Double velocidadProcesador;
        private int cantidadRam;


   public String getSerial()
    {
        return serial;
    }
    public void setSerial(String serial)
    {
        if(!serial.contains("@"))
        {
            this.serial=serial;
        }
            
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarcaProcesador() {
        return marcaProcesador;
    }

    public void setMarcaProcesador(String marcaProcesador) {
        this.marcaProcesador = marcaProcesador;
    }

    public Double getVelocidadProcesador() {
        return velocidadProcesador;
    }

    public void setVelocidadProcesador(Double velocidadProcesador) {
        this.velocidadProcesador = velocidadProcesador;
    }

    public int getCantidadRam() {
        return cantidadRam;
    }

    public void setCantidadRam(int cantidadRam) {
        this.cantidadRam = cantidadRam;
    }
    public Computadora()
    {
    }
    public Computadora(String serial, String marca, String modelo, String marcaProcesador) {
        this.serial = serial;
        this.marca = marca;
        this.modelo = modelo;
        this.marcaProcesador = marcaProcesador;
    }

    public Computadora(String serial, String marca, String modelo, String marcaProcesador, Double velocidadProcesador, int cantidadRam) {
        this.serial = serial;
        this.marca = marca;
        this.modelo = modelo;
        this.marcaProcesador = marcaProcesador;
        this.velocidadProcesador = velocidadProcesador;
        this.cantidadRam = cantidadRam;
    }
    /*public Computadora(String serial,int cantidadRam)
    {
        this(serial,"HP","Panama 2020","",8.0,cantidadRam);
    }*/
}