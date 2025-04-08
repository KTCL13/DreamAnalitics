package com.thepcenter.DreamAnalitics.model.analysis;


import com.thepcenter.DreamAnalitics.model.Dream;

public class ConductualStatisticalAnalyzer implements Analyzer {
    @Override
    public String analyze(Dream dream) {
        return "Análisis estadístico conductual: patrones repetitivos de conducta en sueños.";
    }
}