package com.uptc.model;

import java.util.List;

public interface DreamRepository {
    void saveDream(Dream dream);
    List<Dream> getAllDreams();
}
