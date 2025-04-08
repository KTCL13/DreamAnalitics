package com.thepcenter.DreamAnalitics.model.analysis;

import java.util.Arrays;
import java.util.List;

public class EnfoqueConductual implements Enfoque {
    @Override
    public Analyzer getSymbolicAnalyzer() {
        return new ConductualSymbolicAnalyzer();
    }

    @Override
    public Analyzer getEmotionAnalyzer() {
        return new ConductualEmotionAnalyzer();
    }

    @Override
    public Analyzer getStatisticalAnalyzer() {
        return new ConductualStatisticalAnalyzer();
    }

    @Override
    public Analyzer getCognitiveAnalyzer() {
        return new ConductualCognitiveAnalyzer();
    }

    @Override
    public List<String> getAnalizadoresActivos() {
        return Arrays.asList("symbolic", "emotion");
    }
}