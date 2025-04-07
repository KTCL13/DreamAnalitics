package com.uptc.model.analysis;

import com.uptc.model.Dream;

public interface Enfoque {
    SymbolicAnalyzer getSymbolicAnalyzer();
    EmotionAnalyzer getEmotionAnalyzer();
    StatisticalAnalyzer getStatisticalAnalyzer();
    CognitiveAnalyzer getCognitiveAnalyzer();
}
