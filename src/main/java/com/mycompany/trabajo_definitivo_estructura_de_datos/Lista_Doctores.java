package com.mycompany.trabajo_definitivo_estructura_de_datos;

public class Lista_Doctores {
    private Doctor inicio;

    public Lista_Doctores() {
        this.inicio = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void agregar(Doctor nuevoDoctor) {
        if (estaVacia()) {
            inicio = nuevoDoctor;
        } else {
            Doctor actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoDoctor);
        }
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("NO HAY DOCTORES REGISTRADOS");
            return;
        }
        Doctor actual = inicio;
        while (actual != null) {
            actual.mostrarInfo();
            System.out.println("-----------------------------------");
            actual = actual.getSiguiente();
        }
    }

    public Doctor buscarPorId(String id) {
        Doctor actual = inicio;
        while (actual != null) {
            if (actual.getId().equals(id)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminarPorId(String id) {
        if (estaVacia()) {
            return false;
        }

    
        if (inicio.getId().equals(id)) {
            inicio = inicio.getSiguiente();
            return true;
        }

        Doctor actual = inicio;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getId().equals(id)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}