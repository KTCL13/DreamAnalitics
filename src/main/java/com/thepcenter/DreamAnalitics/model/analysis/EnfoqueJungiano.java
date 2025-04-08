package com.thepcenter.DreamAnalitics.model.analysis;

import java.util.Arrays;
import java.util.List;

public class EnfoqueJungiano implements Enfoque {
    @Override
    public Analyzer getSymbolicAnalyzer() {
        return new JungianSymbolicAnalyzer();
    }

    @Override
    public Analyzer getEmotionAnalyzer() {
        return new JungianEmotionAnalyzer();
    }

    @Override
    public Analyzer getStatisticalAnalyzer() {
        return new JungianStatisticalAnalyzer();
    }

    @Override
    public Analyzer getCognitiveAnalyzer() {
        return new JungianCognitiveAnalyzer();
    }

    @Override
    public List<String> getAnalizadoresActivos() {
        return Arrays.asList("symbolic", "emotion");
    }
}
