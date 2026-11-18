package com.mycompany.trabajo_definitivo_estructura_de_datos;

import java.util.Scanner;

public class Validaciones {
    private Scanner sc = new Scanner(System.in);
    
    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Solo numeros enteros válidos.");
            }
        }
    }
    
    public double leerDobles(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                double num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    System.out.println("ERROR: No se permiten números negativos.");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Solo números válidos.");
            }
        }
    }
    
    public String leerTexto(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String tex = sc.nextLine();
            if (!tex.trim().isEmpty()) {
                return tex;
            } else {
                System.out.println("ERROR: El campo no puede estar vacío.");
            }
        }
    } 
  
    public boolean validarLetras(String dato) {
        return dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    
    public boolean validarNumeros(String dato) {
        return dato.matches("[0-9]+");
    }
    
    public boolean validarTelefono(String telefono) {
        return telefono.matches("[0-9]{10,}");
    }
}
