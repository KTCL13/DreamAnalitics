package com.thepcenter.DreamAnalitics.model.analysis;

import java.util.List;

public interface Enfoque {
    SymbolicAnalyzer getSymbolicAnalyzer();
    EmotionAnalyzer getEmotionAnalyzer();
    StatisticalAnalyzer getStatisticalAnalyzer();
    CognitiveAnalyzer getCognitiveAnalyzer();
    List<Analyzer> getAnalizadoresActivos();
}