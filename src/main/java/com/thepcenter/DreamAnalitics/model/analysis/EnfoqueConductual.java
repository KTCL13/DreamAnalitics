package com.thepcenter.DreamAnalitics.model.analysis;


public class EnfoqueConductual implements Enfoque {
    @Override
    public SymbolicAnalyzer getSymbolicAnalyzer() {
        return new ConductualSymbolicAnalyzer();
    }

    @Override
    public EmotionAnalyzer getEmotionAnalyzer() {
        return new ConductualEmotionAnalyzer();
    }

    @Override
    public StatisticalAnalyzer getStatisticalAnalyzer() {
        return new ConductualStatisticalAnalyzer();
    }

    @Override
    public CognitiveAnalyzer getCognitiveAnalyzer() {
        return new ConductualCognitiveAnalyzer();
    }
}
