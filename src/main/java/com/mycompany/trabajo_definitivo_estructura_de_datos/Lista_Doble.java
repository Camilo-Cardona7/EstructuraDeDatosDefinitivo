package com.mycompany.trabajo_definitivo_estructura_de_datos;

public class Lista_Doble {
    private Paciente inicio;
    private Paciente fin;

    public Lista_Doble() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertar(Paciente nuevo) {
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("NO HAY PACIENTES REGISTRADOS.");
            return;
        }
        Paciente actual = inicio;
        while (actual != null) {
            System.out.println("ID: " + actual.getIdPaciente() + 
                               " | Nombre: " + actual.getNombre() + 
                               " | Edad: " + actual.getEdad() + 
                               " | Peso Triage: " + actual.getPesoTriage() +
                               " | Prioridad Efectiva: " + actual.calcularPrioridadEfectiva(1.0, 1.0));
            System.out.println("--------------------------------------------------");
            actual = actual.getSiguiente();
        }
    }

    public Paciente buscarPorId(int id) {
        Paciente actual = inicio;
        while (actual != null) {
            if (actual.getIdPaciente() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminarPorId(int id) {
        Paciente actual = buscarPorId(id);
        if (actual == null) {
            return false;
        }

        if (actual == inicio && actual == fin) {
            inicio = null;
            fin = null;
        } else if (actual == inicio) {
            inicio = inicio.getSiguiente();
            inicio.setAnterior(null);
        } else if (actual == fin) {
            fin = fin.getAnterior();
            fin.setSiguiente(null);
        } else {
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }
        return true;
    }

    public void ordenarPorGravedad() {
        if (estaVacia() || inicio == fin) {
            return;
        }
        boolean huboCambio;
        do {
            huboCambio = false;
            Paciente actual = inicio;
            while (actual.getSiguiente() != null) {
                Paciente siguiente = actual.getSiguiente();
                if (actual.calcularPrioridadEfectiva(1.0, 1.0) < siguiente.calcularPrioridadEfectiva(1.0, 1.0)) {
                    int tempId = actual.getIdPaciente();
                    String tempNombre = actual.getNombre();
                    int tempEdad = actual.getEdad();
                    double tempPeso = actual.getPesoTriage();
                    java.time.LocalDateTime tempTiempo = actual.getTiempoLlegada();

                    actual.setIdPaciente(siguiente.getIdPaciente());
                    actual.setNombre(siguiente.getNombre());
                    actual.setEdad(siguiente.getEdad());
                    actual.setPesoTriage(siguiente.getPesoTriage());
                    actual.setTiempoLlegada(siguiente.getTiempoLlegada());

                    siguiente.setIdPaciente(tempId);
                    siguiente.setNombre(tempNombre);
                    siguiente.setEdad(tempEdad);
                    siguiente.setPesoTriage(tempPeso);
                    siguiente.setTiempoLlegada(tempTiempo);

                    huboCambio = true;
                }
                actual = actual.getSiguiente();
            }
        } while (huboCambio);
    }
}