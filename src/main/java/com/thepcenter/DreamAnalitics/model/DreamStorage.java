package com.thepcenter.DreamAnalitics.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DreamStorage {
    private static final String FILE_NAME = "suenos_guardados.ser";

    public static void guardar(List<Dream> dreams) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(dreams);
        } catch (IOException e) {
            System.err.println("Error al guardar los sueños: " + e.getMessage());
        }
    }

    public static List<Dream> cargar() {
        File archivo = new File(FILE_NAME);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Dream>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los sueños: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
