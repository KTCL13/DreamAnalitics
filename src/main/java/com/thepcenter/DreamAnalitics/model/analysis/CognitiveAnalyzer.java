package com.thepcenter.DreamAnalitics.model.analysis;

import com.thepcenter.DreamAnalitics.model.Dream;

public class CognitiveAnalyzer {
    public String analyze(Dream dream) {
        return "Análisis cognitivo de: " + dream.getDescription();
    }
}
