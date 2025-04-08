package com.thepcenter.DreamAnalitics.controller;

import com.thepcenter.DreamAnalitics.model.Dream;
import com.thepcenter.DreamAnalitics.model.DreamRepository;
import com.thepcenter.DreamAnalitics.model.DreamRepositoryFactory;
import com.thepcenter.DreamAnalitics.model.analysis.Enfoque;
import com.thepcenter.DreamAnalitics.model.analysis.EnfoqueConductual;
import com.thepcenter.DreamAnalitics.model.analysis.EnfoqueJungiano;
import com.thepcenter.DreamAnalitics.view.ConsoleView;

import main.java.com.thepcenter.DreamAnalitics.model.analysis.Analyzer;

import java.util.List;
import java.util.Locale;

public class Control {
    private final ConsoleView view;
    private DreamRepository repository;
    private Enfoque enfoqueSeleccionado;

    public Control(ConsoleView view) {
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        if (repository == null) {
            inicializarRepositorio(); // ¡Siempre cargar el repositorio al inicio!
        }
        do {
            opcion = view.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    mostrarMenuRegistroSueno();
                    break;
                case 2:
                    view.mostrarMensaje("🔧 Función 'Aplicar método de análisis'");
                    seleccionarEnfoque(view.seleccionarEnfoqueTerapéutico());
                    analizarSuenoSeleccionado();
                    break;
                case 3:
                    view.mostrarMensaje("📄 Función 'Generar informes' aún no implementada.");
                    break;
                case 4:
                    view.mostrarMensaje("🎯 Función 'Seleccionar enfoque terapéutico' aún no implementada.");
                    break;
                case 5:
                    view.mostrarMensaje("👋 Saliendo del sistema...");
                    break;
                default:
                    view.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void inicializarRepositorio() {
        String tipo = view.seleccionarRepositorio();
        repository = DreamRepositoryFactory.create(tipo);
        view.mostrarMensaje("Repositorio inicializado: " + tipo);
    }

    private void mostrarMenuRegistroSueno() {
        int opcion;
        do {
            opcion = view.mostrarMenuRegistro();
            switch (opcion) {
                case 1:
                    Dream nuevo = view.pedirDatosDelSueno();
                    repository.saveDream(nuevo);
                    view.mostrarMensaje("✅ Sueño registrado.");
                    break;
                case 2:
                    view.mostrarSueños(repository.getAllDreams());
                    break;
                case 3:
                    view.mostrarMensaje("↩️ Volviendo al menú principal...");
                    break;
                default:
                    view.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 3);
    }

    public void seleccionarEnfoque(String tipo) {
        this.enfoqueSeleccionado = obtenerEnfoque(tipo);
        System.out.println("Enfoque terapéutico seleccionado: " + tipo);
    }

    public Enfoque obtenerEnfoque(String tipo) {
        switch (tipo.toLowerCase(Locale.ROOT)) {
            case "jungiano":
                return new EnfoqueJungiano();
            case "conductual":
                return new EnfoqueConductual();
            default:
                throw new IllegalArgumentException("Enfoque terapéutico no reconocido: " + tipo);
        }
    }

    public Enfoque getEnfoqueSeleccionado() {
        return enfoqueSeleccionado;
    }

    private void analizarSuenoSeleccionado() {
        if (repository == null || repository.getAllDreams().isEmpty()) {
            view.mostrarMensaje("⚠️ No hay sueños registrados para analizar.");
            return;
        }

        if (enfoqueSeleccionado == null) {
            view.mostrarMensaje("⚠️ Primero debe seleccionar un enfoque terapéutico (opción 4).");
            return;
        }

        List<Dream> sueños = repository.getAllDreams();
        view.mostrarSueñosEnumerados(sueños);

        int indice = view.seleccionarIndiceSueno(sueños.size());
        Dream seleccionado = sueños.get(indice);

        // Aplicar los analizadores del enfoque
        StringBuilder resultado = new StringBuilder();
        resultado.append("🔍 Análisis del sueño: ").append(seleccionado.getDescripcion()).append("\n\n");

        resultado.append("🧠 Análisis simbólico:\n")
                .append(enfoqueSeleccionado.getSymbolicAnalyzer().analyze(seleccionado)).append("\n\n");

        resultado.append("💓 Análisis emocional:\n")
                .append(enfoqueSeleccionado.getEmotionAnalyzer().analyze(seleccionado)).append("\n\n");

        resultado.append("📊 Análisis estadístico:\n")
                .append(enfoqueSeleccionado.getStatisticalAnalyzer().analyze(seleccionado)).append("\n\n");

        resultado.append("🧩 Análisis cognitivo:\n")
                .append(enfoqueSeleccionado.getCognitiveAnalyzer().analyze(seleccionado)).append("\n");

        view.mostrarMensaje(resultado.toString());
    }
}
