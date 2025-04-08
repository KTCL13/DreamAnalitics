package com.thepcenter.DreamAnalitics.view;

import com.thepcenter.DreamAnalitics.model.Dream;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("\n=== Sistema de Sueños Lúcidos ===");
        System.out.println("1. Registrar sueño");
        System.out.println("2. Aplicar método de análisis");
        System.out.println("3. Generar informes");
        System.out.println("4. Seleccionar enfoque terapéutico");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int mostrarMenuRegistro() {
        System.out.println("\n--- Registro de Sueños ---");
        System.out.println("1. Registrar un sueño");
        System.out.println("2. Ver todos los sueños registrados");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String seleccionarRepositorio() {
        System.out.println("Seleccione el tipo de repositorio:");
        System.out.println("1. Historial");
        System.out.println("2. Temporal");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        return (opcion == 1) ? "historial" : "temporal";
    }

    public Dream pedirDatosDelSueno() {
        scanner.nextLine(); // limpiar buffer
        System.out.print("Descripción del sueño: ");
        String descripcion = scanner.nextLine();

        System.out.print("Duración (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Intensidad emocional (baja/media/alta): ");
        String intensidad = scanner.nextLine();

        System.out.print("Claridad visual (baja/media/alta): ");
        String claridad = scanner.nextLine();

        System.out.print("Nivel de conciencia (vaga/media/clara): ");
        String conciencia = scanner.nextLine();

        return new Dream(descripcion, duracion, intensidad, claridad, conciencia);
    }

    public void mostrarSueños(List<Dream> sueños) {
        System.out.println("\n📜 Sueños registrados:");
        for (Dream d : sueños) {
            System.out.println("- " + d.getDescripcion());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String seleccionarEnfoqueTerapéutico() {

        System.out.println("Seleccione enfoque terapéutico:");
        System.out.println("1. Jungiano");
        System.out.println("2. Conductual");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1:
                return "jungiano";
            case 2:
                return "conductual";
            default:
                System.out.println("Opción inválida. Se seleccionará 'jungiano' por defecto.");
                return "jungiano";
        }
    }
    public void mostrarSueñosEnumerados(List<Dream> dreams) {
        System.out.println("Sueños registrados:");
        for (int i = 0; i < dreams.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, dreams.get(i).getDescripcion());
        }
    }

    public int seleccionarIndiceSueno(int max) {
        int opcion;
        do {
            System.out.print("Seleccione el número del sueño a analizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion < 1 || opcion > max);
        return opcion - 1;
    }
}
