package com.mycompany.trabajo_definitivo_estructura_de_datos;
import java.time.Duration;
import java.time.LocalDateTime;

public class Paciente {
    private int idPaciente;
    private String nombre;
    private int edad;
    private double pesoTriage;
    private LocalDateTime tiempoLlegada;
    
    private Paciente siguiente;
    private Paciente anterior;

    public Paciente(int idPaciente, String nombre, int edad, double pesoTriage) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.pesoTriage = pesoTriage;
        this.tiempoLlegada = LocalDateTime.now();
        
        this.siguiente = null;
        this.anterior = null;
    }

    public double calcularPrioridadEfectiva(double omega1, double omega2) {
        long segundosEspera = Duration.between(this.tiempoLlegada, LocalDateTime.now()).getSeconds();
        double tiempoEsperaMinutos = segundosEspera / 60.0;
        double factorEdad = this.edad / 10.0;
        
        double prioridadEfectiva = this.pesoTriage + (tiempoEsperaMinutos * omega1) + (factorEdad * omega2);
        return prioridadEfectiva;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public double getPesoTriage() {
        return pesoTriage;
    }

    public void setPesoTriage(double pesoTriage) {
        this.pesoTriage = pesoTriage;
    }

    public LocalDateTime getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(LocalDateTime tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public Paciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Paciente siguiente) {
        this.siguiente = siguiente;
    }

    public Paciente getAnterior() {
        return anterior;
    }

    public void setAnterior(Paciente anterior) {
        this.anterior = anterior;
    }
    @Override
    public String toString() {
        return "Paciente{" +
            "id=" + idPaciente +
            ", nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", pesoTriage=" + pesoTriage +
            ", esperaMin=" + (Duration.between(tiempoLlegada, LocalDateTime.now()).getSeconds() / 60.0) +
            '}';
    }
}
