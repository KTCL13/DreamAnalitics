package com.thepcenter.DreamAnalitics.model.analysis;


import com.thepcenter.DreamAnalitics.model.Dream;

public class ConductualCognitiveAnalyzer implements Analyzer {
    @Override
    public String analyze(Dream dream) {
        return "Análisis cognitivo conductual: distorsiones cognitivas presentes en el sueño.";
    }
}
