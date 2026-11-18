package com.mycompany.trabajo_definitivo_estructura_de_datos;

public class Doctor {
    private String id;
    private String nombre;
    private int edad;
    private String ciudad;
    private String celular;
    private double salario;
    
    private Doctor siguiente; 

    public Doctor(String id, String nombre, int edad, String ciudad, String celular, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.celular = celular;
        this.salario = salario;
        this.siguiente = null;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Celular: " + celular);
        System.out.println("Salario: " + salario);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Doctor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Doctor siguiente) {
        this.siguiente = siguiente;
    }
}