package com.thepcenter.DreamAnalitics.model.analysis;

import com.thepcenter.DreamAnalitics.model.Dream;

public class SymbolicAnalyzer {
    public String analyze(Dream dream) {
        return "Análisis simbólico de: " + dream.getDescription();
    }
}