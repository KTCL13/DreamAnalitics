package com.thepcenter.model;
import java.util.ArrayList;
import java.util.List;

public class Dream implements DreamPrototype {
    private int duration;
    private String emotionalIntensity;
    private String visualClarity;
    private List<String> tags = new ArrayList<>();

    public Dream(int duration, String emotionalIntensity, String visualClarity, List<String> tags) {
        this.duration = duration;
        this.emotionalIntensity = emotionalIntensity;
        this.visualClarity = visualClarity;
        this.tags = tags;
    }

    @Override
    public Dream cloneDream() {
        return new Dream(duration, emotionalIntensity, visualClarity, new ArrayList<>(tags));
    }

   
}