package com.mycompany.trabajo_definitivo_estructura_de_datos;

public class Operaciones {
    Lista_Doble listaPacientes = new Lista_Doble();
    Lista_Doctores listaDoctores = new Lista_Doctores();
    Validaciones v = new Validaciones();
    

    public void registrarDoctor() {
        System.out.println("--- REGISTRO DE DOCTOR ---");
        String id = v.leerTexto("Ingrese ID del doctor: ");
        
        if (listaDoctores.buscarPorId(id) != null) {
            System.out.println("ERROR: Ya existe un doctor registrado con ese ID.");
            return;
        }

        String nombre;
        do {
            nombre = v.leerTexto("Nombre: ");
            if (!v.validarLetras(nombre)) {
                System.out.println("ERROR: Solo se permiten letras.");
            }
        } while (!v.validarLetras(nombre));

        int edad = v.leerEntero("Edad: ");

        String ciudad;
        do {
            ciudad = v.leerTexto("Ciudad: ");
            if (!v.validarLetras(ciudad)) {
                System.out.println("ERROR: Solo se permiten letras.");
            }
        } while (!v.validarLetras(ciudad));

        String celular;
        do {
            celular = v.leerTexto("Celular: ");
            if (!v.validarTelefono(celular)) {
                System.out.println("ERROR: Formato de celular inválido.");
            }
        } while (!v.validarTelefono(celular));

        double salario = v.leerDobles("Salario: ");

        Doctor nuevoDoc = new Doctor(id, nombre, edad, ciudad, celular, salario);
        listaDoctores.agregar(nuevoDoc);
        System.out.println("¡DOCTOR REGISTRADO EXITOSAMENTE!");
    }

    public void mostrarDoctores() {
        listaDoctores.mostrar();
    }

    public void modificarDoctor() {
        if (listaDoctores.estaVacia()) {
            System.out.println("NO HAY DOCTORES REGISTRADOS PARA MODIFICAR");
            return;
        }

        String id = v.leerTexto("Ingrese el ID del doctor a modificar: ");
        Doctor d = listaDoctores.buscarPorId(id);

        if (d == null) {
            System.out.println("ERROR: No se encontró ningún doctor con ese ID.");
            return;
        }

        System.out.println("Doctor encontrado: " + d.getNombre());
        System.out.println("Ingrese los nuevos datos:");

        String nuevoNombre;
        do {
            nuevoNombre = v.leerTexto("Nuevo nombre: ");
            if (!v.validarLetras(nuevoNombre)) {
                System.out.println("ERROR: Solo se permiten letras.");
            }
        } while (!v.validarLetras(nuevoNombre));

        int nuevaEdad = v.leerEntero("Nueva edad: ");
        String nuevaCiudad = v.leerTexto("Nueva ciudad: ");
        String nuevoCelular = v.leerTexto("Nuevo celular: ");
        double nuevoSalario = v.leerDobles("Nuevo salario: ");

        d.setNombre(nuevoNombre);
        d.setEdad(nuevaEdad);
        d.setCiudad(nuevaCiudad);
        d.setCelular(nuevoCelular);
        d.setSalario(nuevoSalario);

        System.out.println("¡DOCTOR MODIFICADO EXITOSAMENTE!");
    }

    public void eliminarDoctor() {
        if (listaDoctores.estaVacia()) {
            System.out.println("NO HAY DOCTORES REGISTRADOS PARA ELIMINAR");
            return;
        }

        String id = v.leerTexto("Ingrese el ID del doctor a eliminar: ");
        boolean eliminado = listaDoctores.eliminarPorId(id);

        if (eliminado) {
            System.out.println("¡DOCTOR ELIMINADO EXITOSAMENTE!");
        } else {
            System.out.println("ERROR: No se encontró ningún doctor con ese ID.");
        }
    }

    public boolean existePaciente(int idPaciente) {
        return listaPacientes.buscarPorId(idPaciente) != null;
    }

    public void ingresarPaciente() {
        int id;
        do {
            id = v.leerEntero("INGRESE ID DEL PACIENTE: ");
            if (existePaciente(id)) {
                System.out.println("ERROR: Ya existe un paciente registrado con ese ID.");
            }
        } while (existePaciente(id));

        String nombre;
        do {
            nombre = v.leerTexto("INGRESE NOMBRE: ");
            if (!v.validarLetras(nombre)) {
                System.out.println("ERROR: Solo se permiten letras.");
            }
        } while (!v.validarLetras(nombre));

        int edad = v.leerEntero("INGRESE EDAD: ");
        double peso = v.leerDobles("INGRESE PESO DE TRIAGE (gravedad): ");
        
        Paciente nuevo = new Paciente(id, nombre, edad, peso);
        listaPacientes.insertar(nuevo);

        System.out.println("¡PACIENTE REGISTRADO EXITOSAMENTE!");
    }
    
    public void ordenarPacientesPorGravedad() {
        if (listaPacientes.estaVacia()) {
            System.out.println("NO HAY PACIENTES REGISTRADOS PARA ORDENAR");
            return;
        }
        listaPacientes.ordenarPorGravedad();
        System.out.println("¡PACIENTES ORDENADOS POR PRIORIDAD EFECTIVA!");
    }

    public void modificarPaciente() {
        if (listaPacientes.estaVacia()) {
            System.out.println("NO HAY PACIENTES REGISTRADOS PARA MODIFICAR");
            return;
        }

        int id = v.leerEntero("Ingrese el ID del paciente a modificar: ");
        Paciente p = listaPacientes.buscarPorId(id);

        if (p == null) {
            System.out.println("ERROR: No se encontró ningún paciente con ese ID.");
            return;
        }

        System.out.println("Paciente encontrado: " + p.getNombre());
        System.out.println("Ingrese los nuevos datos:");

        String nuevoNombre;
        do {
            nuevoNombre = v.leerTexto("Nuevo nombre: ");
            if (!v.validarLetras(nuevoNombre)) {
                System.out.println("ERROR: Solo se permiten letras.");
            }
        } while (!v.validarLetras(nuevoNombre));

        int nuevaEdad = v.leerEntero("Nueva edad: ");
        double nuevoPeso = v.leerDobles("Nuevo peso de triaje (gravedad): ");

        p.setNombre(nuevoNombre);
        p.setEdad(nuevaEdad);
        p.setPesoTriage(nuevoPeso);

        System.out.println("¡PACIENTE MODIFICADO EXITOSAMENTE!");
    }

    public void eliminarPaciente() {
        if (listaPacientes.estaVacia()) {
            System.out.println("NO HAY PACIENTES REGISTRADOS PARA ELIMINAR");
            return;
        }

        int id = v.leerEntero("Ingrese el ID del paciente a eliminar: ");
        boolean eliminado = listaPacientes.eliminarPorId(id);

        if (eliminado) {
            System.out.println("¡PACIENTE ELIMINADO EXITOSAMENTE!");
        } else {
            System.out.println("ERROR: No se encontró ningún paciente con ese ID.");
        }
    }
    
    public void mostrarPacientes() {
        if (listaPacientes.estaVacia()) {
            System.out.println("NO HAY PACIENTES REGISTRADOS EN EL SISTEMA.");
            return;
        }
        System.out.println("--- LISTA DE PACIENTES ---");
        listaPacientes.mostrar();
    }
}
