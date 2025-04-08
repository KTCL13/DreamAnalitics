package com.thepcenter.DreamAnalitics.model.analysis;

import com.thepcenter.DreamAnalitics.model.Dream;

public class StatisticAnalyzer {
    public String analyze(Dream dream) {
        return "Análisis estadístico de: " + dream.getDescripcion();
    }
}