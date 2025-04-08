package com.thepcenter.DreamAnalitics.model.analysis;

import java.util.List;

public interface Enfoque {
    Analyzer getSymbolicAnalyzer();
    Analyzer getEmotionAnalyzer();
    Analyzer getStatisticalAnalyzer();
    Analyzer getCognitiveAnalyzer();
    List<String> getAnalizadoresActivos();
}