package com.mycompany.trabajo_definitivo_estructura_de_datos;

import java.util.Scanner;

public class Menu {
    
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        Operaciones op = new Operaciones();
        int opcion = -1;

        do {
            System.out.println("\n==================================================");
            System.out.println("        SISTEMA DE TRIAJE HOSPITALARIO");
            System.out.println("==================================================");
            System.out.println(" 1. Registrar Paciente");
            System.out.println(" 2. Mostrar Pacientes");
            System.out.println(" 3. Modificar Paciente");
            System.out.println(" 4. Eliminar Paciente");
            System.out.println(" 5. Modificar Doctor");
            System.out.println(" 6. Eliminar Doctor");
            System.out.println(" 7. Registrar Doctor");
            System.out.println(" 8. Mostrar Doctores");
            System.out.println(" 9. Ordenar Pacientes por Prioridad Efectiva");
            System.out.println(" 0. Salir");
            System.out.println("==================================================");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println(); 

                switch (opcion) {
                    case 1:
                        op.ingresarPaciente();
                        break;
                    case 2:
                        op.mostrarPacientes();
                        break;
                    case 3:
                        op.modificarPaciente();
                        break;
                    case 4:
                        op.eliminarPaciente();
                        break;
                    case 5:
                        op.modificarDoctor();
                        break;
                    case 6:
                        op.eliminarDoctor();
                        break;
                    case 7:
                        op.registrarDoctor();
                        break;
                    case 8:
                        op.mostrarDoctores();
                        break;
                    case 9:
                        op.ordenarPacientesPorGravedad();
                        break;
                    case 0:
                        System.out.println("¡Gracias por usar el sistema de triaje! Saliendo...");
                        break;
                    default:
                        System.out.println("ERROR: Opción no válida. Intente entre 0 y 9.");
                }
            } else {
                System.out.println("ERROR: Debe ingresar un número entero válido.");
                scanner.next(); 
            }

        } while (opcion != 0);

        scanner.close();
    }
}