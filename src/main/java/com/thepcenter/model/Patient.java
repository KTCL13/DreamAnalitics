package com.thepcenter.model;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private List<Dream> dreams = new ArrayList<>();

    public Patient(String name) {
        this.name = name;
    }

    public void addDream(Dream dream) {
        dreams.add(dream);
    }

    public List<Dream> getDreams() {
        return dreams;
    }

   
}
