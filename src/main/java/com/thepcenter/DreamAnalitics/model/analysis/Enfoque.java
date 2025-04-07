package com.thepcenter.DreamAnalitics.model.analysis;

public interface Enfoque {
    SymbolicAnalyzer getSymbolicAnalyzer();
    EmotionAnalyzer getEmotionAnalyzer();
    StatisticalAnalyzer getStatisticalAnalyzer();
    CognitiveAnalyzer getCognitiveAnalyzer();
}
