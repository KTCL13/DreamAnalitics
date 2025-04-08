package com.thepcenter.DreamAnalitics.model.analysis;

public class EnfoqueJungiano implements Enfoque{
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
}
