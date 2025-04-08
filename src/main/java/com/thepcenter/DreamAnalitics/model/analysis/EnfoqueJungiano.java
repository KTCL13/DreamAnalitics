package com.thepcenter.DreamAnalitics.model.analysis;

import java.util.Arrays;
import java.util.List;

public class EnfoqueJungiano implements Enfoque {
    @Override
    public SymbolicAnalyzer getSymbolicAnalyzer() {
        return new JungianSymbolicAnalyzer();
    }

    @Override
    public EmotionAnalyzer getEmotionAnalyzer() {
        return new JungianEmotionAnalyzer();
    }

    @Override
    public StatisticalAnalyzer getStatisticalAnalyzer() {
        return new JungianStatisticalAnalyzer();
    }

    @Override
    public CognitiveAnalyzer getCognitiveAnalyzer() {
        return new JungianCognitiveAnalyzer();
    }

    @Override
    public List<Analyzer> getAnalizadoresActivos() {
        return Arrays.asList(getSymbolicAnalyzer(), getEmotionAnalyzer());
    }
}
