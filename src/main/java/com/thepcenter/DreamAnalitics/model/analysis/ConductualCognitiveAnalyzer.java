package com.uptc.model.analysis;

import com.uptc.model.Dream;

public class ConductualCognitiveAnalyzer implements CognitiveAnalyzer {
    @Override
    public String analyze(Dream dream) {
        return "Análisis cognitivo conductual: distorsiones cognitivas presentes en el sueño.";
    }
}
