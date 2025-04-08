package com.thepcenter.DreamAnalitics.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DreamStorage {
    private static final String FILE_NAME = "suenos_guardados.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void guardar(List<Dream> dreams) {
        try {
            File file = getResourceFile();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, dreams);
        } catch (IOException e) {
            System.err.println("Error al guardar los sueños: " + e.getMessage());
        }
    }

    public static List<Dream> cargar() {
        try {
            File file = getResourceFile();
            if (!file.exists()) {
                return new ArrayList<>();
            }

            return objectMapper.readValue(file, new TypeReference<List<Dream>>() {});
        } catch (IOException e) {
            System.err.println("Error al cargar los sueños: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static File getResourceFile() throws IOException {
        File resourcesDir = new File("src/main/resources");
        if (!resourcesDir.exists()) {
            resourcesDir.mkdirs();
        }
        return new File(resourcesDir, FILE_NAME);
    }
}
