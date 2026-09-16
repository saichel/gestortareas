package com.venanaciob.dam.gestortareas;

import java.util.Scanner;

/**
 * Practicando control de versiones (Gestor de tareas)
 * Comentario de sara para poder modificar la rama nueva !
 */
public class App {
	
	private static final Scanner scanner = new Scanner(System.in);
	private static final GestorTareas gestor = new GestorTareas();
	
    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1: crearTarea(); break;
                case 2: listarTareas(); break;
                case 3: completarTarea(); break;
                case 4: eliminarTarea(); break;
                case 5: System.out.println("Vuelva pronto!!!"); break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 5);
        scanner.close();
        
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("!!! GESTOR DE TAREAS!!");
        System.out.println("1. Añadir tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
    }

    private static void crearTarea() {
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        try {
            Tarea tarea = gestor.crearTarea(descripcion);
            System.out.println("Tarea creada: " + tarea);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarTareas() {
        System.out.println();
        System.out.println("===== TAREAS =====");
        if (gestor.obtenerTareas().isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (Tarea tarea : gestor.obtenerTareas()) {
            System.out.println(tarea);
        }
    }

    private static void completarTarea() {
        int id = leerEntero("Identificador de la tarea: ");
        if (gestor.completarTarea(id)) {
            System.out.println("Tarea completada.");
        } else {
            System.out.println("No existe una tarea con ese identificador.");
        }
    }

    private static void eliminarTarea() {
        int id = leerEntero("Identificador de la tarea: ");
        if (gestor.eliminarTarea(id)) {
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("No existe una tarea con ese identificador.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número entero.");
            }
        }
    }
    
}
