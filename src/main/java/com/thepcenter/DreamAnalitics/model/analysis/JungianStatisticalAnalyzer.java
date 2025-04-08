package com.thepcenter.DreamAnalitics.model.analysis;

import com.thepcenter.DreamAnalitics.model.Dream;

public class JungianStatisticalAnalyzer implements Analyzer{
    @Override
    public String analyze(Dream dream) {
        return "El anális jungiano es incompatible para los análisis estadísticos.";
    }
}