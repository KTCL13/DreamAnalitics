package com.thepcenter.DreamAnalitics.controller;

import com.thepcenter.DreamAnalitics.model.Dream;
import com.thepcenter.DreamAnalitics.model.DreamRepository;
import com.thepcenter.DreamAnalitics.model.DreamRepositoryFactory;
import com.thepcenter.DreamAnalitics.model.analysis.Enfoque;
import com.thepcenter.DreamAnalitics.model.analysis.EnfoqueConductual;
import com.thepcenter.DreamAnalitics.model.analysis.EnfoqueJungiano;
import com.thepcenter.DreamAnalitics.view.ConsoleView;

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
        inicializarRepositorio();

        do {
            opcion = view.mostrarMenuPrincipal();
            switch (opcion) {
                case 1 -> mostrarMenuRegistroSueno();
                case 2 -> aplicarAnalisis();
                case 3 -> view.mostrarMensaje("📄 Función 'Generar informes' en desarrollo");
                case 4 -> seleccionarEnfoqueTerapeutico();
                case 5 -> view.mostrarMensaje("👋 Saliendo del sistema...");
                default -> view.mostrarMensaje("❌ Opción inválida");
            }
        } while (opcion != 5);
    }

    private void inicializarRepositorio() {
        if (repository == null) {
            String tipo = view.seleccionarRepositorio();
            repository = DreamRepositoryFactory.create(tipo);
            view.mostrarMensaje("✅ Repositorio '" + tipo + "' inicializado");
        }
    }

    private void mostrarMenuRegistroSueno() {
        int opcion;
        do {
            opcion = view.mostrarMenuRegistro();
            switch (opcion) {
                case 1 -> registrarSueno();
                case 2 -> view.mostrarSueños(repository.getAllDreams());
                case 3 -> view.mostrarMensaje("↪ Volviendo al menú principal");
                default -> view.mostrarMensaje("❌ Opción inválida");
            }
        } while (opcion != 3);
    }

    private void registrarSueno() {
        Dream nuevo = view.pedirDatosDelSueno();
        repository.saveDream(nuevo);
        view.mostrarMensaje("💤 Sueño registrado exitosamente");
    }

    private void seleccionarEnfoqueTerapeutico() {
        String tipo = view.seleccionarEnfoqueTerapéutico();
        enfoqueSeleccionado = crearEnfoque(tipo);
        view.mostrarMensaje("\n🎯 Enfoque activo: " + tipo.toUpperCase());
    }

    private Enfoque crearEnfoque(String tipo) {
        return switch (tipo.toLowerCase(Locale.ROOT)) {
            case "jungiano" -> new EnfoqueJungiano();
            case "conductual" -> new EnfoqueConductual();
            default -> throw new IllegalArgumentException("Enfoque no soportado: " + tipo);
        };
    }

    private void aplicarAnalisis() {
        if (!validarPrecondicionesAnalisis())
            return;

        List<Dream> sueños = repository.getAllDreams();
        view.mostrarSueñosEnumerados(sueños);

        Dream seleccionado = obtenerSuenoParaAnalizar(sueños);
        String resultado = generarResultadoAnalisis(seleccionado);

        view.mostrarMensaje(resultado);
    }

    private boolean validarPrecondicionesAnalisis() {
        if (repository.getAllDreams().isEmpty()) {
            view.mostrarMensaje("⚠️ No hay sueños registrados");
            return false;
        }
        if (enfoqueSeleccionado == null) {
            view.mostrarMensaje("⚠️ Seleccione un enfoque primero (Opción 4)");
            return false;
        }
        return true;
    }

    private Dream obtenerSuenoParaAnalizar(List<Dream> sueños) {
        int indice = view.seleccionarIndiceSueno(sueños.size());
        return sueños.get(indice);
    }

    private String generarResultadoAnalisis(Dream sueno) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\n🔮 Análisis del sueño: ").append(sueno.getDescripcion()).append("\n\n");

        enfoqueSeleccionado.getAnalizadoresActivos()
                .forEach(tipo -> resultado.append(obtenerSeccionAnalisis(tipo, sueno)));

        return resultado.toString();
    }

    private String obtenerSeccionAnalisis(String tipo, Dream sueno) {
        return switch (tipo) {
            case "symbolic" -> formatSeccion("🧠 Simbólico", enfoqueSeleccionado.getSymbolicAnalyzer().analyze(sueno));
            case "emotion" -> formatSeccion("💓 Emocional", enfoqueSeleccionado.getEmotionAnalyzer().analyze(sueno));
            case "statistical" ->
                formatSeccion("📊 Estadístico", enfoqueSeleccionado.getStatisticalAnalyzer().analyze(sueno));
            case "cognitive" ->
                formatSeccion("🧩 Cognitivo", enfoqueSeleccionado.getCognitiveAnalyzer().analyze(sueno));
            default -> "";
        };
    }

    private String formatSeccion(String titulo, String contenido) {
        return titulo + ":\n" + contenido + "\n\n";
    }
}