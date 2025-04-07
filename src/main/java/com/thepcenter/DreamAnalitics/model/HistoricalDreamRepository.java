package com.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class HistoricalDreamRepository implements DreamRepository {
    private List<Dream> dreams;

    public HistoricalDreamRepository() {
        this.dreams = DreamStorage.cargar();
    }

    @Override
    public void saveDream(Dream dream) {
        dreams.add(dream);
        DreamStorage.guardar(dreams);
    }

    @Override
    public List<Dream> getAllDreams() {
        return new ArrayList<>(dreams);
    }
}
