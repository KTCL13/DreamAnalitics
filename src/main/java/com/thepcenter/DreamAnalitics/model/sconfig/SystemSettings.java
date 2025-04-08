package com.thepcenter.DreamAnalitics.model.sconfig;

import java.util.HashMap;
import java.util.Map;

public class SystemSettings {

    // Instancia única (eager initialization - se crea al cargar la clase)
    private static final SystemSettings instance = new SystemSettings();

    // Ejemplo de configuraciones clínicas
    private Map<String, String> reglasLenguaje = new HashMap<>();
    private Map<String, Boolean> validacionesClinicas = new HashMap<>();
    private Map<String, String> parametrosEticos = new HashMap<>();

    // Constructor privado para evitar instanciación externa
    private SystemSettings() {
        // Inicializamos algunas configuraciones por defecto
        reglasLenguaje.put("idioma", "español");
        reglasLenguaje.put("modoFormal", "true");

        validacionesClinicas.put("verificarEdadMinima", true);
        validacionesClinicas.put("permitirSueñosViolentos", false);

        parametrosEticos.put("nivelSensibilidad", "alto");
        parametrosEticos.put("registroAnonimo", "true");
    }

    // Método público para obtener la instancia única
    public static SystemSettings getInstance() {
        return instance;
    }

    // Métodos de acceso para las configuraciones
    public String getReglaLenguaje(String clave) {
        return reglasLenguaje.get(clave);
    }

    public void setReglaLenguaje(String clave, String valor) {
        reglasLenguaje.put(clave, valor);
    }

    public Boolean getValidacionClinica(String clave) {
        return validacionesClinicas.get(clave);
    }

    public void setValidacionClinica(String clave, Boolean valor) {
        validacionesClinicas.put(clave, valor);
    }

    public String getParametroEtico(String clave) {
        return parametrosEticos.get(clave);
    }

    public void setParametroEtico(String clave, String valor) {
        parametrosEticos.put(clave, valor);
    }
}
