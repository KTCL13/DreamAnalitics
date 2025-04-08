package com.thepcenter.DreamAnalitics.model;

import java.util.ArrayList;
import java.util.List;

public class TemporaryDreamRepository implements DreamRepository {
    private List<Dream> tempList = new ArrayList<>();

    @Override
    public void saveDream(Dream dream) {
        tempList.add(dream);
        System.out.println("Sueño guardado temporalmente.");
    }

    @Override
    public List<Dream> getAllDreams() {
        return tempList;
    }
}
